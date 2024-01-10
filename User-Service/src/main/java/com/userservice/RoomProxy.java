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

@FeignClient(name = "room-service", url = "http://localhost:8083/Room")
public interface RoomProxy {

	@PostMapping("/add")
	public String addroom(@RequestBody @Valid Room room) throws Exception;

	@PutMapping("/update")
	public String updateroom(@RequestBody @Valid Room room);

	@DeleteMapping("/deletebyid/{id}")
	public String deleteroom(@PathVariable Integer id);

	@GetMapping("/getall")
	public List<Room> getall();

	@GetMapping("/getbyid/{id}")
	public Room getroom(@PathVariable Integer id);

	@GetMapping("/getbyhotelid/{hid}")
	public List<Room> getroombyhid(@PathVariable Integer hid);

	@GetMapping("/getbyprice/{price}")
	public List<Room> getroom(@PathVariable Double price);

	@GetMapping("/getbyroomtype/{type}")
	public List<Room> getroombytype(@PathVariable String type);

}
