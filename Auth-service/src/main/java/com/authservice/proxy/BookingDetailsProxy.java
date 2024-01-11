package com.authservice.proxy;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.BookingDetails;

@FeignClient(name = "bookindetails-service", url = "http://localhost:8084/Bookingdetails")
@Service
public interface BookingDetailsProxy {

	@GetMapping("/getall")
	public ResponseEntity<List<BookingDetails>> listBookingDetails();

	@GetMapping("/checkifavail/{roomid}/{hotelid}/{fromDate}/{ToDate}")
	public ResponseEntity<Boolean> checkRoomAvailability(@PathVariable int roomid, @PathVariable int hotelid,
			@PathVariable Date fromDate, @PathVariable Date ToDate);

	@GetMapping("/getbyid/{bookingid}")
	public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable Integer booking_id);

	@PostMapping("/paymentstatuschangebybid/{bookingid}")
	public ResponseEntity<BookingDetails> paymentstatuschange(@PathVariable Integer booking_id);

	@PutMapping("/bookroom/{userid}")
	public ResponseEntity<BookingDetails> bookroom(@PathVariable String user_id, @RequestBody BookingDetails bd);

	@DeleteMapping("/deletebyid/{bookingid}")
	public ResponseEntity<String> remove(@PathVariable Integer booking_id);
}
