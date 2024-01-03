package com.hotelservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface HotelService {

	public List<Hotel> getHotels();

	public Hotel gethotelByHotelId(long id);

	public Hotel gethotelByHotelName(String hotelName);

	public List<Hotel> gethotelByCity(String City);

	public Hotel addhotel(Hotel htl) throws Exception;

	public Hotel updatehotel(Hotel ht);

	public String deletehotel(long id);

}
