package com.nagp.exam.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagp.exam.models.DriverRequestDO;
import com.nagp.exam.models.NotificationDO;
import com.nagp.exam.models.RideRequestDO;

@RestController
@RequestMapping("rides")
public class RideController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/request")
	public String findRide(@RequestBody RideRequestDO rideRequest) {
		// return ride if available driver
		DriverRequestDO driverRequest=new DriverRequestDO();
		ResponseEntity<String> response=this.restTemplate.exchange("http://driver-inventory/drivers/available", HttpMethod.POST, new HttpEntity(driverRequest), String.class);
		return "Ride fetched basis on the driver available";
	}
	
	@GetMapping("/book/{driverId}")
	public String bookRide(@PathVariable("driverId") String driverId) {
		ResponseEntity<String> response=this.restTemplate.exchange("http://driver-inventory/drivers/trip/book/"+driverId, HttpMethod.GET, HttpEntity.EMPTY, String.class);
		// send notification to user
		NotificationDO notification=new NotificationDO();
		notification.setReceiverName("chetan");
		notification.setEmail("chetan.mahajan@nagarro.com");
		ResponseEntity<String> responseNotification=this.restTemplate.exchange("http://notification/notification/", HttpMethod.POST, new HttpEntity(notification), String.class);
		return "Ride Booked";
	}
	
	

}
