package com.authservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@RestController
@RequestMapping("/Main")
public class ProxyController{

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

	@GetMapping("/User/getallusers")
	public List<User> listUser() {
		return userProxy.listUser();
	}

	@PostMapping("/User/adduser")
	public String addUser(User user) {
		return userProxy.addUser(user);
	}

	@PutMapping("/User/updateuser/{user_id}")
	public User updateUser(String userId, User user) {
		return userProxy.updateUser(userId, user);
	}

	@PutMapping("/updatepassword/{user_id}/{password}")
	public User showUser(String userId) {
		return userProxy.showUser(userId);
	}

	@GetMapping("/User/getuserbyid/{user_id}")
	public User showUserByUserName(String username) {
		return userProxy.showUserByUserName(username);
	}

	@GetMapping("/User/getuserbyemail/{email}")
	public User showUserByEmail(String email) {
		return userProxy.showUserByEmail(email);
	}

	@GetMapping("/User/getuserbymobile/{mobile}")
	public User showUserByMobileNumber(String mobile) {
		return userProxy.showUserByMobileNumber(mobile);
	}

	@GetMapping("/User/deleteuserbyid/{user_id}")
	public String remove(String userId) {
		return userProxy.remove(userId);
	}

	@GetMapping("/Hotel/getallhotel")
	public List<Hotel> getHotels() {
		return hotelProxy.getHotels();
	}

	@GetMapping("/Hotel/gethotelbyid/{id}")
	public Hotel gethotelbyid(long id) {
		return hotelProxy.gethotelbyid(id);
	}

	@GetMapping("/Hotel/gethotelbyhotelname/{hotelname}")
	public Hotel gethotelbyhotelname(String hotelname) {
		return hotelProxy.gethotelbyhotelname(hotelname);
	}

	@GetMapping("/Hotel/gethotelbycityname/{cityname}")
	public List<Hotel> gethotelbycityname(String cityname) {
		return hotelProxy.gethotelbycityname(cityname);
	}

	@PostMapping("/Hotel/addhotel")
	public Hotel addhotel(Hotel htl) throws Exception {
		return hotelProxy.addhotel(htl);
	}

	@PutMapping("/Hotel/updatehotel")
	public Hotel updatehotel(Hotel ht) {
		return hotelProxy.updatehotel(ht);
	}

	@DeleteMapping("/Hotel/deletebyid/{id}")
	public String deletehotel(long id) {
		return hotelProxy.deletehotel(id);
	}

	@PostMapping("/Room/add")
	public String addroom(Room room) throws Exception {
		return roomProxy.addroom(room);
	}

	@PutMapping("/Room/update")
	public String updateroom(Room room) {
		return roomProxy.updateroom(room);
	}

	@DeleteMapping("/Room/deletebyid/{id}")
	public String deleteroom(Integer id) {
		return roomProxy.deleteroom(id);
	}

	@GetMapping("/Room/getall")
	public List<Room> getall() {
		return roomProxy.getall();
	}

	@GetMapping("/Room/getbyid/{id}")
	public Room getroom(Integer id) {
		return roomProxy.getroom(id);
	}

	@GetMapping("/Room/getbyhotelid/{hid}")
	public List<Room> getroombyhid(Integer hid) {
		return roomProxy.getroombyhid(hid);
	}

	@GetMapping("/Room/getbyprice/{price}")
	public List<Room> getroom(Double price) {
		return roomProxy.getroom(price);
	}

	@GetMapping("/Room/getbyroomtype/{type}")
	public List<Room> getroombytype(String type) {
		return roomProxy.getroombytype(type);
	}

	@PostMapping("/Payment/doPayment/{bookingid}")
	public Payment addPayment(int bookingid) throws Exception {
		return paymentProxy.addPayment(bookingid);
	}

	@GetMapping("/Payment/getallpayment")
	public List<Payment> getallpayments() {
		return paymentProxy.getallpayments();
	}

	@GetMapping("/Payment/getpaymentbybookingid/{bookingid}")
	public Payment getpaymentbybookingid(int bookingid) {
		return paymentProxy.getpaymentbybookingid(bookingid);
	}

	@GetMapping("/Payment/getpaymentbypaymentid/{paymentid}")
	public Payment getpaymentbypaymentid(long paymentid) {
		return paymentProxy.getpaymentbypaymentid(paymentid);
	}

	@GetMapping("/Payment/paymentCancel/{paymentid}")
	public String paymentCancel(long paymentid) {
		return paymentProxy.paymentCancel(paymentid);
	}

	@PostMapping("/Mail/adduser")
	public String sendMail(Mail mail) {
		return mailProxy.sendMail(mail);
	}

	@GetMapping("/Mail/getallmail")
	public List<Mail> getallMail() {
		return mailProxy.getallMail();
	}

	@GetMapping("/Mail/getbymailid/{mailid}")
	public Mail getbymailid(String mailid) {
		return mailProxy.getbymailid(mailid);
	}

	@GetMapping("/Bookingdetails/getall")
	public ResponseEntity<List<BookingDetails>> listBookingDetails() {
		return bookingDetailsProxy.listBookingDetails();
	}

	@GetMapping("/Bookingdetails/checkifavail/{roomid}/{hotelid}/{fromDate}/{toDate}")
	public ResponseEntity<Boolean> checkRoomAvailability(int roomid, int hotelid, Date fromDate, Date toDate) {
		return bookingDetailsProxy.checkRoomAvailability(roomid, hotelid, fromDate, toDate);
	}

	@GetMapping("/Bookingdetails/getbyid/{bookingid}")
	public ResponseEntity<BookingDetails> getBookingDetails(Integer booking_id) {
		return bookingDetailsProxy.getBookingDetails(booking_id);
	}

	@GetMapping("/Bookingdetails/paymentstatuschangebybid/{bookingid}")
	public ResponseEntity<BookingDetails> paymentstatuschange(Integer booking_id) {
		return bookingDetailsProxy.paymentstatuschange(booking_id);
	}

	@PutMapping("/Bookingdetails/bookroom/{userid}")
	public ResponseEntity<BookingDetails> bookroom(String user_id, BookingDetails bd) {
		return bookingDetailsProxy.bookroom(user_id, bd);
	}

	@DeleteMapping("/Bookingdetails/deletebyid/{bookingid}")
	public ResponseEntity<String> remove(Integer booking_id) {
		return bookingDetailsProxy.remove(booking_id);
	}
}
