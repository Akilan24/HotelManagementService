package com.paymentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookingdetails-service" ,url = "http://localhost:8084/Bookindetails")
public interface BookingDetailsProxy {

	@GetMapping("/getbyid/{bookingid}")
	public BookingDetails getBookingDetails(@PathVariable Integer booking_id);
}
