package com.bookingdetailsservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{

	List<BookingDetails> findByHotelidAndRoomid(int hotelid, int room_id);

	boolean existsByBookingid(int bookingId);

}

