package com.authservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

@Service
public class ProxyServiceImpl {

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

	public List<User> listUser() {
		return userProxy.listUser();
	}

	public String addUser(User user) {
		return userProxy.addUser(user);
	}

	public User updateUser(String userId, User user) {
		return userProxy.updateUser(userId, user);
	}

	public User showUser(String userId) {
		return userProxy.showUser(userId);
	}

	public User showUserByUserName(String username) {
		return userProxy.showUserByUserName(username);
	}

	public User showUserByEmail(String email) {
		return userProxy.showUserByEmail(email);
	}

	public User showUserByMobileNumber(String mobile) {
		return userProxy.showUserByMobileNumber(mobile);
	}

	public String remove(String userId) {
		return userProxy.remove(userId);
	}

	public List<Hotel> getHotels() {
		return hotelProxy.getHotels();
	}

	public Hotel gethotelbyid(long id) {
		return hotelProxy.gethotelbyid(id);
	}

	public Hotel gethotelbyhotelname(String hotelname) {
		return hotelProxy.gethotelbyhotelname(hotelname);
	}

	public List<Hotel> gethotelbycityname(String cityname) {
		return hotelProxy.gethotelbycityname(cityname);
	}

	public Hotel addhotel(Hotel htl) throws Exception {
		return hotelProxy.addhotel(htl);
	}

	public Hotel updatehotel(Hotel ht) {
		return hotelProxy.updatehotel(ht);
	}

	public String deletehotel(long id) {
		return hotelProxy.deletehotel(id);
	}

	public String addroom(Room room) throws Exception {
		return roomProxy.addroom(room);
	}

	public String updateroom(Room room) {
		return roomProxy.updateroom(room);
	}

	public String deleteroom(Integer id) {
		return roomProxy.deleteroom(id);
	}

	public List<Room> getall() {
		return roomProxy.getall();
	}

	public Room getroom(Integer id) {
		return roomProxy.getroom(id);
	}

	public List<Room> getroombyhid(Integer hid) {
		return roomProxy.getroombyhid(hid);
	}

	public List<Room> getroom(Double price) {
		return roomProxy.getroom(price);
	}

	public List<Room> getroombytype(String type) {
		return roomProxy.getroombytype(type);
	}

	public Payment addPayment(int bookingid) throws Exception {
		return paymentProxy.addPayment(bookingid);
	}

	public List<Payment> getallpayments() {
		return paymentProxy.getallpayments();
	}

	public Payment getpaymentbybookingid(int bookingid) {
		return paymentProxy.getpaymentbybookingid(bookingid);
	}

	public Payment getpaymentbypaymentid(long paymentid) {
		return paymentProxy.getpaymentbypaymentid(paymentid);
	}

	public String paymentCancel(long paymentid) {
		return paymentProxy.paymentCancel(paymentid);
	}

	public String sendMail(Mail mail) {
		return mailProxy.sendMail(mail);
	}

	public List<Mail> getallMail() {
		return mailProxy.getallMail();
	}

	public Mail getbymailid(String mailid) {
		return mailProxy.getbymailid(mailid);
	}

	public ResponseEntity<List<BookingDetails>> listBookingDetails() {
		return bookingDetailsProxy.listBookingDetails();
	}

	public ResponseEntity<Boolean> checkRoomAvailability(int roomid, int hotelid, Date fromDate, Date toDate) {
		return bookingDetailsProxy.checkRoomAvailability(roomid, hotelid, fromDate, toDate);
	}

	public ResponseEntity<BookingDetails> getBookingDetails(Integer booking_id) {
		return bookingDetailsProxy.getBookingDetails(booking_id);
	}

	public ResponseEntity<BookingDetails> paymentstatuschange(Integer booking_id) {
		return bookingDetailsProxy.paymentstatuschange(booking_id);
	}

	public ResponseEntity<BookingDetails> bookroom(String user_id, BookingDetails bd) {
		return bookingDetailsProxy.bookroom(user_id, bd);
	}

	public ResponseEntity<String> remove(Integer booking_id) {
		return bookingDetailsProxy.remove(booking_id);
	}
}
