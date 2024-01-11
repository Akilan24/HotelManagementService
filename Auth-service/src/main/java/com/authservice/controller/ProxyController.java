package com.authservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.externalentity.BookingDetails;
import com.authservice.externalentity.Hotel;
import com.authservice.externalentity.Mail;
import com.authservice.externalentity.Payment;
import com.authservice.externalentity.Room;
import com.authservice.externalentity.User;
import com.authservice.proxy.BookingDetailsProxy;
import com.authservice.proxy.HotelProxy;
import com.authservice.proxy.MailProxy;
import com.authservice.proxy.PaymentProxy;
import com.authservice.proxy.RoomProxy;
import com.authservice.proxy.UserProxy;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Main")
public class ProxyController {

	@Autowired
	private UserProxy userProxy;
	@Autowired
	private HotelProxy hotelProxy;
	@Autowired
	private RoomProxy roomProxy;
	@Autowired
	private PaymentProxy paymentProxy;
	@Autowired
	private MailProxy mailProxy;
	@Autowired
	private BookingDetailsProxy bookingDetailsProxy;

	@Autowired
	private PasswordEncoder bcrytp;

	@GetMapping("/User/getallusers")
	public ResponseEntity<List<User>> listUser() {
		return userProxy.listUser();
	}

	@PostMapping("/User/adduser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		user.setPassword(bcrytp.encode(user.getPassword()));
		return userProxy.addUser(user);
	}

	@PutMapping("/User/updateuser/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody @Valid User user) {
		return userProxy.updateUser(user_id, user);
	}

	@PutMapping("/updatepassword/{user_id}/{password}")
	public ResponseEntity<String> updatepassword(@PathVariable String user_id, @PathVariable @Valid String password) {
		password = bcrytp.encode(password);
		return userProxy.updatepassword(user_id, password);
	}

	@GetMapping("/getuserbyid/{user_id}")
	public ResponseEntity<User> showUser(@PathVariable String userId) {
		return userProxy.showUser(userId);
	}

	@GetMapping("/getuserbyname/{username}")
	public ResponseEntity<User> showUserByUserName(@PathVariable String username) {
		return userProxy.showUserByUserName(username);
	}

	@GetMapping("/User/getuserbyemail/{email}")
	public ResponseEntity<User> showUserByEmail(@PathVariable String email) {
		return userProxy.showUserByEmail(email);
	}

	@GetMapping("/User/getuserbymobile/{mobile}")
	public ResponseEntity<User> showUserByMobileNumber(@PathVariable String mobile) {
		return userProxy.showUserByMobileNumber(mobile);
	}

	@GetMapping("/User/deleteuserbyid/{user_id}")
	public ResponseEntity<String> remove(@PathVariable String userId) {
		return userProxy.remove(userId);
	}

	@GetMapping("/Hotel/getallhotel")
	public ResponseEntity<List<Hotel>> getHotels() {
		return hotelProxy.getHotels();
	}

	@GetMapping("/Hotel/gethotelbyid/{id}")
	public ResponseEntity<Hotel> gethotelbyid(@PathVariable long id) {
		return hotelProxy.gethotelbyid(id);
	}

	@GetMapping("/Hotel/gethotelbyhotelname/{hotelname}")
	public ResponseEntity<Hotel> gethotelbyhotelname(@PathVariable String hotelname) {
		return hotelProxy.gethotelbyhotelname(hotelname);
	}

	@GetMapping("/Hotel/gethotelbycityname/{cityname}")
	public ResponseEntity<List<Hotel>> gethotelbycityname(@PathVariable String cityname) {
		return hotelProxy.gethotelbycityname(cityname);
	}

	@PostMapping("/Hotel/addhotel")
	public ResponseEntity<Hotel> addhotel(@RequestBody Hotel htl) throws Exception {
		return hotelProxy.addhotel(htl);
	}

	@PutMapping("/Hotel/updatehotel")
	public ResponseEntity<Hotel> updatehotel(@RequestBody Hotel ht) {
		return hotelProxy.updatehotel(ht);
	}

	@DeleteMapping("/Hotel/deletebyid/{id}")
	public ResponseEntity<String> deletehotel(@RequestBody long id) {
		return hotelProxy.deletehotel(id);
	}

	@PostMapping("/Room/add")
	public ResponseEntity<String> addroom(@RequestBody Room room) throws Exception {
		return roomProxy.addroom(room);
	}

	@PutMapping("/Room/update")
	public ResponseEntity<String> updateroom(@RequestBody Room room) {
		return roomProxy.updateroom(room);
	}

	@DeleteMapping("/Room/deletebyid/{id}")
	public ResponseEntity<String> deleteroom(@PathVariable Integer id) {
		return roomProxy.deleteroom(id);
	}

	@GetMapping("/Room/getall")
	public ResponseEntity<List<Room>> getall() {
		return roomProxy.getall();
	}

	@GetMapping("/Room/getbyid/{id}")
	public ResponseEntity<Room> getroom(@PathVariable Integer id) {
		return roomProxy.getroom(id);
	}

	@GetMapping("/Room/getbyhotelid/{hid}")
	public ResponseEntity<List<Room>> getroombyhid(@PathVariable Integer hid) {
		return roomProxy.getroombyhid(hid);
	}

	@GetMapping("/Room/getbyprice/{price}")
	public ResponseEntity<List<Room>> getroom(@PathVariable Double price) {
		return roomProxy.getroom(price);
	}

	@GetMapping("/Room/getbyroomtype/{type}")
	public ResponseEntity<List<Room>> getroombytype(@PathVariable String type) {
		return roomProxy.getroombytype(type);
	}

	@PostMapping("/Payment/doPayment/{bookingid}")
	public ResponseEntity<Payment> addPayment(@PathVariable int bookingid) throws Exception {
		return paymentProxy.addPayment(bookingid);
	}

	@GetMapping("/Payment/getallpayment")
	public ResponseEntity<List<Payment>> getallpayments() {
		return paymentProxy.getallpayments();
	}

	@GetMapping("/Payment/getpaymentbybookingid/{bookingid}")
	public ResponseEntity<Payment> getpaymentbybookingid(@PathVariable int bookingid) {
		return paymentProxy.getpaymentbybookingid(bookingid);
	}

	@GetMapping("/Payment/getpaymentbypaymentid/{paymentid}")
	public ResponseEntity<Payment> getpaymentbypaymentid(@PathVariable long paymentid) {
		return paymentProxy.getpaymentbypaymentid(paymentid);
	}

	@GetMapping("/Payment/paymentCancel/{paymentid}")
	public ResponseEntity<String> paymentCancel(@PathVariable long paymentid) {
		return paymentProxy.paymentCancel(paymentid);
	}

	@PostMapping("/Mail/adduser")
	public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
		return mailProxy.sendMail(mail);
	}

	@GetMapping("/Mail/getallmail")
	public ResponseEntity<List<Mail>> getallMail() {
		return mailProxy.getallMail();
	}

	@GetMapping("/Mail/getbymailid/{mailid}")
	public ResponseEntity<Mail> getbymailid(@PathVariable String mailid) {
		return mailProxy.getbymailid(mailid);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<BookingDetails>> listBookingDetails() {
		return bookingDetailsProxy.listBookingDetails();
	}

	@GetMapping("/checkifavail/{roomid}/{hotelid}/{fromDate}/{ToDate}")
	public ResponseEntity<Boolean> checkRoomAvailability(@PathVariable int roomid, @PathVariable int hotelid,
			@PathVariable Date fromDate, @PathVariable Date ToDate) {
		return bookingDetailsProxy.checkRoomAvailability(roomid, hotelid, fromDate, ToDate);
	}

	@GetMapping("/getbyid/{bookingid}")
	public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable Integer booking_id) {
		return bookingDetailsProxy.getBookingDetails(booking_id);
	}

	@PostMapping("/paymentstatuschangebybid/{bookingid}")
	public ResponseEntity<BookingDetails> paymentstatuschange(@PathVariable Integer booking_id) {
		return bookingDetailsProxy.paymentstatuschange(booking_id);
	}

	@PutMapping("/bookroom/{userid}")
	public ResponseEntity<BookingDetails> bookroom(@PathVariable String user_id, @RequestBody BookingDetails bd) {
		return bookingDetailsProxy.bookroom(user_id, bd);
	}

	@DeleteMapping("/deletebyid/{bookingid}")
	public ResponseEntity<String> remove(@PathVariable Integer booking_id) {
		return bookingDetailsProxy.remove(booking_id);
	}
}
