package com.hotelservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hrepo;

	@Override
	public List<Hotel> getHotels() throws HotelDetailsNotFoundException {
		List<Hotel> list = hrepo.findAll();
		if (list.isEmpty())
			throw new HotelDetailsNotFoundException("Hotel details are not found");
		return list;
	}

	@Override
	public Hotel gethotelByHotelId(long id) throws HotelDetailsNotFoundException {
		if (hrepo.findById(id).isPresent()) {
			Hotel h = hrepo.findById(id).get();
			return h;
		} else
			throw new HotelDetailsNotFoundException("Hotel details are not found");
	}

	@Override
	public Hotel addhotel(Hotel h) throws Exception {
		try {
			hrepo.save(h);
			return h;
		} catch (Exception e) {
			throw new Exception("Details are mismatched");
		}
	}

	@Override
	public Hotel updatehotel(Hotel ht) throws HotelDetailsNotFoundException {
		if (hrepo.findById(ht.getHotelId()).isPresent()) {
			Hotel h = hrepo.findById(ht.getHotelId()).get();
			h.setHotelName(ht.getHotelName());
			h.setAddress(ht.getAddress());
			h.setCity(ht.getCity());
			h.setDescription(ht.getDescription());
			h.setEmail(ht.getEmail());
			h.setMobile1(ht.getMobile1());
			h.setMobile2(ht.getMobile2());
			h.setWebsite(ht.getWebsite());
			hrepo.save(h);
			return h;
		} else
			throw new HotelDetailsNotFoundException("Hotel details are not found");
	}

	@Override
	public String deletehotel(long hid) throws HotelDetailsNotFoundException {
		if (hrepo.findById(hid).isPresent()) {
			Hotel h = hrepo.findById(hid).get();
			hrepo.deleteById(hid);
			return "Hotel details are deleted";
		} else
			throw new HotelDetailsNotFoundException("Hotel details are not found");
	}

	@Override
	public Hotel gethotelByHotelName(String hotelName) {
		if (hrepo.findByHotelName(hotelName).isPresent()) {
			Hotel h = hrepo.findByHotelName(hotelName).get();
			return h;
		} else
			throw new HotelDetailsNotFoundException("Hotel details are not found");
	}

	@Override
	public List<Hotel> gethotelByCity(String city) {
		if (hrepo.findAllByCity(city).isPresent()) {
			List<Hotel> h = hrepo.findAllByCity(city).get();
			return h;
		} else
			throw new HotelDetailsNotFoundException("Hotel details are not found");
	}
}
