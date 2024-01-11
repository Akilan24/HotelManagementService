package com.bookingdetailsservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	BookingDetailsRepository bookingrepo;

	@Autowired
	RoomProxy rproxy;

	@Override
	public BookingDetails BookRoom(String user_id, BookingDetails bookingdetails) {

		int count = bookingrepo.findAll().size();
		int MIN_ID = 100000;
		if (count == 0)
			bookingdetails.setBookingid(MIN_ID);
		else
			bookingdetails.setBookingid(MIN_ID + 1);

		bookingdetails.setUserid(user_id);

		double amt = rproxy.getroom(bookingdetails.getRoomid()).getRate_per_day();
		bookingdetails.setPaymentStatus("Payment has to be done");
		bookingrepo.save(bookingdetails);
		return bookingdetails;
	}

	@Override
	public String removeBookingDetails(int booking_id) {
		if (bookingrepo.findById(booking_id).isPresent()) {
			bookingrepo.deleteById(booking_id);
			return "Booking details are deleted";
		} else
			throw new BookingDetailsNotFoundException("Booking details are not found");
	}

	@Override
	public List<BookingDetails> showAllBookingDetails() {
		List<BookingDetails> list = bookingrepo.findAll();
		if (bookingrepo.findAll().isEmpty())
			throw new BookingDetailsNotFoundException("Booking details are not found");
		return list;
	}

	@Override
	public BookingDetails showBookingDetailsbyId(int booking_id) {
		if (bookingrepo.findById(booking_id).isPresent()) {
			BookingDetails bd = bookingrepo.findById(booking_id).get();
			return bd;
		} else
			throw new BookingDetailsNotFoundException("Booking details are not found");
	}

	@Override
	public boolean checkAvailability(int roomid, int hotelid, Date fromDate, Date ToDate) {
		List<BookingDetails> bookings = bookingrepo.findByHotelidAndRoomid(hotelid, roomid);

		boolean isAvailable = bookings.stream().noneMatch(booking -> {
			Date bookedFrom = booking.getBooked_from();
			Date bookedTo = booking.getBooked_to();

			return (fromDate.before(bookedTo) || fromDate.equals(bookedTo))
					&& (ToDate.after(bookedFrom) || ToDate.equals(bookedFrom));
		});

		return isAvailable;
	}

	@Override
	public BookingDetails paymentstatuschange(int bookingid) {
		if (bookingrepo.findById(bookingid).isPresent()) {
			BookingDetails bd = bookingrepo.findById(bookingid).get();
			bd.setPaymentStatus("Payment done");
			return bookingrepo.save(bd);
		} else
			throw new BookingDetailsNotFoundException("Booking details are not found");
	
	}

}