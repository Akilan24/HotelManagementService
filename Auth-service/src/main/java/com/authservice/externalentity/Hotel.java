package com.authservice.externalentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	private long hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private String email;
	private String mobile1;
	private String mobile2;
	private String website;

}
