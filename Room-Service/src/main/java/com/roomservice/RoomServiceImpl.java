
package com.roomservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository rrepo;

	public String addRoomDetails(Room room) throws Exception {
		try {
			rrepo.save(room);
			return "Room Added successfully";
		} catch (Exception e) {
			throw new Exception("Details are mismatched");
		}

	}

	public String updateRoomDetails(Room room) {
		if (rrepo.findById(room.getRoom_no()).isPresent()) {
			Room roomdetails = rrepo.findById(room.getRoom_no()).get();
			roomdetails.setRoomtype(room.getRoomtype());
			roomdetails.setRate_per_day(room.getRate_per_day());
			rrepo.save(roomdetails);
			return "Room Details updated";
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");
	}

	public String removeRoomDetails(Integer rid) {
		if (rrepo.findById(rid).isPresent()) {
			rrepo.deleteById(rid);
			return "Room details are deleted";
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");
	}

	public List<Room> showAllRoomDetails() {

		if (!rrepo.findAll().isEmpty()) {
			return rrepo.findAll();
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");

	}

	public Room showRoomDetailsbyId(Integer id) {
		if (rrepo.findById(id).isPresent()) {
			Room r = rrepo.findById(id).get();
			return r;
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");
	}

	@Override
	public List<Room> showAllRoomDetailsByHotelId(int hid) {
		List<Room> r = rrepo.findAll().stream().filter(n -> n.getHotelId() == hid).collect(Collectors.toList());
		if (!r.isEmpty())
			return r;
		else
			throw new RoomDetailsNotFoundException("Room details are not found");

	}

	@Override
	public List<Room> showRoomDetailBytype(String type) {
		List<Room> r = rrepo.findAll().stream().filter(a -> a.getRoomtype().equals(type)).collect(Collectors.toList());
		if (!r.isEmpty()) {
			return r;
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");

	}

	@Override
	public List<Room> showRoomDetailByPrice(double price) {
		List<Room> r = rrepo.findAll().stream().filter(p -> p.getRate_per_day() <= price).collect(Collectors.toList());
		if (!r.isEmpty()) {
			return r;
		} else
			throw new RoomDetailsNotFoundException("Room details are not found");

	}
}
