package com.paymentservice;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {

	private int bookingid;
	private String userid;
	private int roomid;
	private int hotelid;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date booked_from;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date booked_to;
	private int no_of_adults;
	private int no_of_children;
	private double amount;
	private String paymentStatus;

}