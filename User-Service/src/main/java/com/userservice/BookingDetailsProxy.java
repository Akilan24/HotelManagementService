package com.userservice;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bookingdetails-service", url = "http://localhost:8084/Bookingdetails")
public interface BookingDetailsProxy {

	@GetMapping("/getall")
	public List<BookingDetails> listBookingDetails();

	@GetMapping("/checkifavail/{roomid}/{hotelid}/{fromDate}/{ToDate}")
	public ResponseEntity<?> checkRoomAvailability(@PathVariable int roomid, @PathVariable int hotelid,
			@PathVariable Date fromDate, @PathVariable Date ToDate);

	@GetMapping("/getbyid/{bookingid}")
	public boolean getBookingDetails(@PathVariable Integer booking_id);

	@GetMapping("/paymentstatuschangebybid/{bookingid}")
	public BookingDetails paymentstatuschange(@PathVariable Integer booking_id);

	@PutMapping("/bookroom/{userid}")
	public BookingDetails bookroom(@PathVariable String user_id, @RequestBody BookingDetails bd);

	@DeleteMapping("/deletebyid/{bookingid}")
	public String remove(@PathVariable Integer booking_id);
}
