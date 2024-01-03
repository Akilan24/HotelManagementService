package com.roomservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RoomService {

	public String addRoomDetails(Room room) throws Exception;

	public String updateRoomDetails(Room room);

	public String removeRoomDetails(Integer rno);

	public List<Room> showAllRoomDetails();

	public List<Room> showAllRoomDetailsByHotelId(int hid);

	public Room showRoomDetails(Integer id);

	public List<Room> showRoomDetailBytype(String type);

	public List<Room> showRoomDetailByPrice(double price);
}
