package com.userservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@FeignClient(name = "hotel-service", url = "http://localhost:8082/Hotel")
public interface HotelProxy {

	@GetMapping("/getallhotel")
	public List<Hotel> getHotels();

	@GetMapping("/gethotelbyid/{id}")
	public Hotel gethotelbyid(@PathVariable long id);

	@GetMapping("/gethotelbyhotelname/{hotelname}")
	public Hotel gethotelbyhotelname(@PathVariable String hotelname);

	@GetMapping("/gethotelbycityname/{cityname}")
	public List<Hotel> gethotelbycityname(@PathVariable String cityname);

	@PostMapping("/addhotel")
	public Hotel addhotel(@RequestBody @Valid Hotel htl) throws Exception;

	@PutMapping("/updatehotel")
	public Hotel updatehotel(@RequestBody @Valid Hotel ht);

	@DeleteMapping("/deletebyid/{id}")
	public Hotel deletehotel(@PathVariable long id);
}
