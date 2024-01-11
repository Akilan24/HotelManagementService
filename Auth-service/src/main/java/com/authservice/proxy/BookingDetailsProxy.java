package com.authservice.proxy;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.BookingDetails;

@FeignClient(name = "bookingdetails-service", url = "http://localhost:8084/Bookingdetails")
public interface BookingDetailsProxy {

	@GetMapping("/Bookingdetails/getall")
	public ResponseEntity<List<BookingDetails>> listBookingDetails();

	@GetMapping("/Bookingdetails/checkifavail/{roomid}/{hotelid}/{fromDate}/{toDate}")
	public ResponseEntity<Boolean> checkRoomAvailability(@PathVariable int roomid, @PathVariable int hotelid,
			@PathVariable Date fromDate, @PathVariable Date toDate);

	@GetMapping("/Bookingdetails/getbyid/{bookingid}")
	public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable Integer booking_id);

	@GetMapping("/Bookingdetails/paymentstatuschangebybid/{bookingid}")
	public ResponseEntity<BookingDetails> paymentstatuschange(@PathVariable Integer booking_id);

	@PutMapping("/Bookingdetails/bookroom/{userid}")
	public ResponseEntity<BookingDetails> bookroom(@PathVariable String user_id, @RequestBody BookingDetails bd);

	@DeleteMapping("/Bookingdetails/deletebyid/{bookingid}")
	public ResponseEntity<String> remove(@PathVariable Integer booking_id);
}
