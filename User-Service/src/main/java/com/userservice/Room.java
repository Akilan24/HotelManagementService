package com.userservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	
	private int room_no;
	private Double rate_per_day;
    private String roomtype;
	private long hotelId;

}
