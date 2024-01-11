package com.bookingdetailsservice;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BookingDetailsService {

	public BookingDetails BookRoom(String user_id, BookingDetails bookingdetails);

	public String removeBookingDetails(int bookingid);

	public List<BookingDetails> showAllBookingDetails();

	public BookingDetails showBookingDetailsbyId(int bookingid);

	public BookingDetails paymentstatuschange(int bookingid);

	public boolean checkAvailability(int roomid, int hotelid, Date fromDate, Date ToDate);
}