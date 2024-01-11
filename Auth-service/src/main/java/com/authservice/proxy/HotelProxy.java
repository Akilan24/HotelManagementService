package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.Hotel;

import jakarta.validation.Valid;

@FeignClient(name = "hotel-service", url = "http://localhost:8082/Hotel")
public interface HotelProxy {
	@GetMapping("/Hotel/getallhotel")
	public List<Hotel> getHotels();

	@GetMapping("/Hotel/gethotelbyid/{id}")
	public Hotel gethotelbyid(@PathVariable long id);

	@GetMapping("/Hotel/gethotelbyhotelname/{hotelname}")
	public Hotel gethotelbyhotelname(@PathVariable String hotelname);

	@GetMapping("/Hotel/gethotelbycityname/{cityname}")
	public List<Hotel> gethotelbycityname(@PathVariable String cityname);

	@PostMapping("/Hotel/addhotel")
	public Hotel addhotel(@RequestBody @Valid Hotel htl) throws Exception;

	@PutMapping("/Hotel/updatehotel")
	public Hotel updatehotel(@RequestBody @Valid Hotel ht);

	@DeleteMapping("/Hotel/deletebyid/{id}")
	public String deletehotel(@PathVariable long id);
}
