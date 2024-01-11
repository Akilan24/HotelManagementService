package com.bookingdetailsservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Bookingdetails")
public class BookingDetailsController {

	@Autowired
	BookingDetailsService service;

	@GetMapping("/getall")
	public ResponseEntity<List<BookingDetails>> listBookingDetails() {
		return new ResponseEntity<>(service.showAllBookingDetails(), HttpStatus.OK);
	}

	@GetMapping("/checkifavail/{roomid}/{hotelid}/{fromDate}/{ToDate}")
	public ResponseEntity<Boolean> checkRoomAvailability(@PathVariable int roomid,@PathVariable int hotelid,@PathVariable Date fromDate, @PathVariable Date ToDate) {
		return new ResponseEntity<>(service.checkAvailability(roomid,hotelid,fromDate, ToDate), HttpStatus.OK);
	}

	@GetMapping("/getbyid/{bookingid}")
	public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable Integer booking_id) {
		return new ResponseEntity<>(service.showBookingDetailsbyId(booking_id), HttpStatus.OK);
	}
	@PostMapping("/paymentstatuschangebybid/{bookingid}")
	public ResponseEntity<BookingDetails> paymentstatuschange(@PathVariable Integer booking_id) {
		return new ResponseEntity<>(service.paymentstatuschange(booking_id), HttpStatus.OK);
	}
	@PutMapping("/bookroom/{userid}")
	public ResponseEntity<BookingDetails> bookroom(@PathVariable String user_id,@RequestBody BookingDetails bd) {
		return new ResponseEntity<>(service.BookRoom(user_id,bd), HttpStatus.OK);
	}
	@DeleteMapping("/deletebyid/{bookingid}")
	public ResponseEntity<String> remove(@PathVariable Integer booking_id) {
		return new ResponseEntity<>(service.removeBookingDetails(booking_id), HttpStatus.OK);
	}
}
