package com.roomservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Room")
public class RoomController {

	@Autowired
	RoomServiceImpl rservice;

	@PostMapping("/add")
	public ResponseEntity<String> addroom(@RequestBody @Valid Room room) throws Exception {
		return new ResponseEntity<>(rservice.addRoomDetails(room), HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateroom(@RequestBody @Valid Room room) {
		return new ResponseEntity<>(rservice.updateRoomDetails(room), HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteroom(@PathVariable Integer id) {
		return new ResponseEntity<>(rservice.removeRoomDetails(id), HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Room>> getall() {
		return new ResponseEntity<>(rservice.showAllRoomDetails(), HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Room> getroom(@PathVariable Integer id) {
		return new ResponseEntity<>(rservice.showRoomDetailsbyId(id), HttpStatus.OK);
	}

	@GetMapping("/getbyhotelid/{hid}")
	public ResponseEntity<List<Room>> getroombyhid(@PathVariable Integer hid) {
		return new ResponseEntity<>(rservice.showAllRoomDetailsByHotelId(hid), HttpStatus.OK);
	}

	@GetMapping("/getbyprice/{price}")
	public ResponseEntity<?> getroom(@PathVariable Double price) {
		return new ResponseEntity<>(rservice.showRoomDetailByPrice(price), HttpStatus.OK);
	}

	@GetMapping("/getbyroomtype/{type}")
	public ResponseEntity<List<Room>> getroombytype(@PathVariable String type) {
		return new ResponseEntity<>(rservice.showRoomDetailBytype(type), HttpStatus.OK);
	}

}
