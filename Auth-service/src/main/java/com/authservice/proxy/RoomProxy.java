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

import com.authservice.externalentity.Room;

import jakarta.validation.Valid;

@FeignClient(name = "room-service", url = "http://localhost:8083/")
@Service
public interface RoomProxy {

	@PostMapping("/Room/add")
	public ResponseEntity<String> addroom(@RequestBody @Valid Room room) throws Exception;

	@PutMapping("/Room/update")
	public ResponseEntity<String> updateroom(@RequestBody @Valid Room room);

	@DeleteMapping("/Room/deletebyid/{id}")
	public ResponseEntity<String> deleteroom(@PathVariable Integer id);

	@GetMapping("/Room/getall")
	public ResponseEntity<List<Room>> getall();

	@GetMapping("/Room/getbyid/{id}")
	public ResponseEntity<Room> getroom(@PathVariable Integer id);

	@GetMapping("/Room/getbyhotelid/{hid}")
	public ResponseEntity<List<Room>> getroombyhid(@PathVariable Integer hid);

	@GetMapping("/Room/getbyprice/{price}")
	public ResponseEntity<List<Room>> getroom(@PathVariable Double price);

	@GetMapping("/Room/getbyroomtype/{type}")
	public ResponseEntity<List<Room>> getroombytype(@PathVariable String type);
}
