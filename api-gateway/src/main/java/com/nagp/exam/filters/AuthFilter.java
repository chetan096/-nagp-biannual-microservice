package com.nagp.exam.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthFilter extends ZuulFilter {

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1; // run before PreDecoration
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String header = request.getHeader("Authorization");
		if ((header != null && !header.equalsIgnoreCase("12345")) || header == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseBody("Invalid Authorization key");
			ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
		}
		return null;
	}
}
