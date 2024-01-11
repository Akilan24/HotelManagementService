package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.Hotel;

import jakarta.validation.Valid;

@FeignClient(name = "hotel-service", url = "http://localhost:8082/")
@Service
public interface HotelProxy {
	@GetMapping("/Hotel/getallhotel")
	public ResponseEntity<List<Hotel>> getHotels();

	@GetMapping("/Hotel/gethotelbyid/{id}")
	public ResponseEntity<Hotel> gethotelbyid(@PathVariable long id);

	@GetMapping("/Hotel/gethotelbyhotelname/{hotelname}")
	public ResponseEntity<Hotel> gethotelbyhotelname(@PathVariable String hotelname);

	@GetMapping("/Hotel/gethotelbycityname/{cityname}")
	public ResponseEntity<List<Hotel>> gethotelbycityname(@PathVariable String cityname);

	@PostMapping("/Hotel/addhotel")
	public ResponseEntity<Hotel> addhotel(@RequestBody @Valid Hotel htl) throws Exception;

	@PutMapping("/Hotel/updatehotel")
	public ResponseEntity<Hotel> updatehotel(@RequestBody @Valid Hotel ht);

	@DeleteMapping("/Hotel/deletebyid/{id}")
	public ResponseEntity<String> deletehotel(@PathVariable long id);
}
