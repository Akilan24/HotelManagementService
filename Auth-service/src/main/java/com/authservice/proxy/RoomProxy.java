package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.Room;

import jakarta.validation.Valid;

@FeignClient(name = "room-service", url = "http://localhost:8083/Room")
public interface RoomProxy {

	@PostMapping("/Room/add")
	public String addroom(@RequestBody @Valid Room room) throws Exception;

	@PutMapping("/Room/update")
	public String updateroom(@RequestBody @Valid Room room);

	@DeleteMapping("/Room/deletebyid/{id}")
	public String deleteroom(@PathVariable Integer id);

	@GetMapping("/Room/getall")
	public List<Room> getall();

	@GetMapping("/Room/getbyid/{id}")
	public Room getroom(@PathVariable Integer id);

	@GetMapping("/Room/getbyhotelid/{hid}")
	public List<Room> getroombyhid(@PathVariable Integer hid);

	@GetMapping("/Room/getbyprice/{price}")
	public List<Room> getroom(@PathVariable Double price);

	@GetMapping("/Room/getbyroomtype/{type}")
	public List<Room> getroombytype(@PathVariable String type);
}
