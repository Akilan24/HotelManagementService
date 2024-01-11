package com.authservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.externalentity.Hotel;
import com.authservice.externalentity.Mail;
import com.authservice.externalentity.Payment;
import com.authservice.externalentity.Room;
import com.authservice.externalentity.User;
import com.authservice.proxy.HotelProxy;
import com.authservice.proxy.MailProxy;
import com.authservice.proxy.PaymentProxy;
import com.authservice.proxy.RoomProxy;
import com.authservice.proxy.UserProxy;

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
	private PasswordEncoder bcrytp;

	@GetMapping("/U")
	public String User() {
		return "asd";
	}

	@GetMapping("/User/getallusers")
	public ResponseEntity<List<User>> listUser() {
		return userProxy.listUser();
	}

	@PostMapping("/User/adduser")
	public ResponseEntity<String> addUser(User user) {
		user.setPassword(bcrytp.encode(user.getPassword()));
		return userProxy.addUser(user);
	}

	@PutMapping("/User/updateuser/{user_id}")
	public ResponseEntity<com.authservice.externalentity.User> updateUser(String user_id, User user) {
		return userProxy.updateUser(user_id, user);
	}

	@PutMapping("/updatepassword/{user_id}/{password}")
	public ResponseEntity<String> updatepassword(String user_id, String password) {
		password = bcrytp.encode(password);
		return userProxy.updatepassword(user_id, password);
	}

	@GetMapping("/User/getuserbyid/{user_id}")
	public User showUserByUserName(String username) {
		return userProxy.showUserByUserName(username);
	}

	@GetMapping("/User/getuserbyemail/{email}")
	public ResponseEntity<com.authservice.externalentity.User> showUserByEmail(String email) {
		return userProxy.showUserByEmail(email);
	}

	@GetMapping("/User/getuserbymobile/{mobile}")
	public ResponseEntity<com.authservice.externalentity.User> showUserByMobileNumber(String mobile) {
		return userProxy.showUserByMobileNumber(mobile);
	}

	@GetMapping("/User/deleteuserbyid/{user_id}")
	public ResponseEntity<String> remove(String userId) {
		return userProxy.remove(userId);
	}

	@GetMapping("/Hotel/getallhotel")
	public ResponseEntity<List<Hotel>> getHotels() {
		return hotelProxy.getHotels();
	}

	@GetMapping("/Hotel/gethotelbyid/{id}")
	public ResponseEntity<Hotel> gethotelbyid(long id) {
		return hotelProxy.gethotelbyid(id);
	}

	@GetMapping("/Hotel/gethotelbyhotelname/{hotelname}")
	public ResponseEntity<Hotel> gethotelbyhotelname(String hotelname) {
		return hotelProxy.gethotelbyhotelname(hotelname);
	}

	@GetMapping("/Hotel/gethotelbycityname/{cityname}")
	public ResponseEntity<List<Hotel>> gethotelbycityname(String cityname) {
		return hotelProxy.gethotelbycityname(cityname);
	}

	@PostMapping("/Hotel/addhotel")
	public ResponseEntity<Hotel> addhotel(Hotel htl) throws Exception {
		return hotelProxy.addhotel(htl);
	}

	@PutMapping("/Hotel/updatehotel")
	public ResponseEntity<Hotel> updatehotel(Hotel ht) {
		return hotelProxy.updatehotel(ht);
	}

	@DeleteMapping("/Hotel/deletebyid/{id}")
	public ResponseEntity<String> deletehotel(long id) {
		return hotelProxy.deletehotel(id);
	}

	@PostMapping("/Room/add")
	public ResponseEntity<String> addroom(Room room) throws Exception {
		return roomProxy.addroom(room);
	}

	@PutMapping("/Room/update")
	public ResponseEntity<String> updateroom(Room room) {
		return roomProxy.updateroom(room);
	}

	@DeleteMapping("/Room/deletebyid/{id}")
	public ResponseEntity<String> deleteroom(Integer id) {
		return roomProxy.deleteroom(id);
	}

	@GetMapping("/Room/getall")
	public ResponseEntity<List<Room>> getall() {
		return roomProxy.getall();
	}

	@GetMapping("/Room/getbyid/{id}")
	public ResponseEntity<Room> getroom(Integer id) {
		return roomProxy.getroom(id);
	}

	@GetMapping("/Room/getbyhotelid/{hid}")
	public ResponseEntity<List<Room>> getroombyhid(Integer hid) {
		return roomProxy.getroombyhid(hid);
	}

	@GetMapping("/Room/getbyprice/{price}")
	public ResponseEntity<List<Room>> getroom(Double price) {
		return roomProxy.getroom(price);
	}

	@GetMapping("/Room/getbyroomtype/{type}")
	public ResponseEntity<List<Room>> getroombytype(String type) {
		return roomProxy.getroombytype(type);
	}

	@PostMapping("/Payment/doPayment/{bookingid}")
	public ResponseEntity<Payment> addPayment(int bookingid) throws Exception {
		return paymentProxy.addPayment(bookingid);
	}

	@GetMapping("/Payment/getallpayment")
	public ResponseEntity<List<Payment>> getallpayments() {
		return paymentProxy.getallpayments();
	}

	@GetMapping("/Payment/getpaymentbybookingid/{bookingid}")
	public ResponseEntity<Payment> getpaymentbybookingid(int bookingid) {
		return paymentProxy.getpaymentbybookingid(bookingid);
	}

	@GetMapping("/Payment/getpaymentbypaymentid/{paymentid}")
	public ResponseEntity<Payment> getpaymentbypaymentid(long paymentid) {
		return paymentProxy.getpaymentbypaymentid(paymentid);
	}

	@GetMapping("/Payment/paymentCancel/{paymentid}")
	public ResponseEntity<String> paymentCancel(long paymentid) {
		return paymentProxy.paymentCancel(paymentid);
	}

	@PostMapping("/Mail/adduser")
	public ResponseEntity<String> sendMail(Mail mail) {
		return mailProxy.sendMail(mail);
	}

	@GetMapping("/Mail/getallmail")
	public ResponseEntity<List<Mail>> getallMail() {
		return mailProxy.getallMail();
	}

	@GetMapping("/Mail/getbymailid/{mailid}")
	public ResponseEntity<Mail> getbymailid(String mailid) {
		return mailProxy.getbymailid(mailid);
	}

}
