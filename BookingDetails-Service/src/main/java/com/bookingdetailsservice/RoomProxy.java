package com.bookingdetailsservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="room-service",url = "http://localhost:8083/Room")
public interface RoomProxy {

	
	@GetMapping("/getbyid/{id}")
	public Room getroom(@PathVariable Integer id);
}
