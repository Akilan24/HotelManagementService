package com.bookingdetailsservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	@Id
	@Pattern(regexp = "^\\d{3}$\n", message = "Please provide a valid room number")
	private int room_no;
	@NotNull
	private Double rate_per_day;
	@NotBlank
    private String roomtype;
	private long hotelId;

}
