package com.nagp.exam.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.exam.models.NotificationDO;

@RestController
@RequestMapping("/notification/")
public class NotificationController {
	
	private static Logger LOGGER=LoggerFactory.getLogger(NotificationController.class); 
	
	
	@PostMapping
	public String sendNotification(@RequestBody NotificationDO request) {
		LOGGER.info("Notification Body recieved:{}",request);
		return "Notification Sent";
		
		
	}


}
