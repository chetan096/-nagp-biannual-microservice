package com.nagp.exam.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.exam.models.DriverRequestDO;

@RestController
@RequestMapping("/drivers/")
public class DriverInventoryController {
	
	@PutMapping("/trip/{tripId}/status/{status}")
    public String updateTrip(@PathVariable("tripId") String tripId,@PathVariable("status") String status ) {
		 return "Trip Updated";
	}
	
	@GetMapping("/available")
	public String getAvailableDriver(@RequestBody DriverRequestDO driverRequest) {
		// return available driver id
		return "Available DriverId";
	}
	
	@GetMapping("/trip/book/{driverId}")
	public String bookDriver(@PathVariable("driverId") String driverId) {
		return "Trip assigned to driver";
	}

}
