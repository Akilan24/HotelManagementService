package com.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepo;

	@Override
	public String addUser(User user) {
		userrepo.save(user);
		return "User details are added";

	}

	@Override
	public User updateUser(String user_id, User u) {
		if (userrepo.findById(u.getUser_id()).isPresent()) {
			Optional<User> user = userrepo.findById(user_id);
			user.get().setAddress(u.getAddress());
			user.get().setEmail(u.getEmail());
			user.get().setMobile(u.getMobile());
			user.get().setPassword(u.getPassword());
			user.get().setRoles(u.getRoles());
			user.get().setUserName(u.getUserName());
			userrepo.save(user.get());
			return user.get();
		} else
			throw new UserNotFoundException("User details are not found");
	}

	@Override
	public String removeUser(String user_id) {

		if (userrepo.findById(user_id).isPresent()) {
			userrepo.deleteById(user_id);
			return "User details are deleted";
		} else {
			throw new UserNotFoundException("User details are not found");
		}
	}

	@Override
	public List<User> ShowAllUser() {
		List<User> list = (List<User>) userrepo.findAll();
		if (list.isEmpty()) {
			throw new UserNotFoundException("User details are not found");
		}
		return list;
	}

	@Override
	public User ShowUserByUserId(String user_id) {

		if (userrepo.findById(user_id).isPresent()) {
			User u = userrepo.findById(user_id).get();
			return u;
		} else
			throw new UserNotFoundException("User details are not found");

	}

	@Override
	public User ShowUserByUserName(String username) {
		if (userrepo.findByUserName(username).isPresent()) {
			User u = userrepo.findByUserName(username).get();
			return u;
		} else
			throw new UserNotFoundException("User details are not found");

	}

	@Override
	public User ShowUserByEmail(String email) {
		if (userrepo.findByEmail(email).isPresent()) {
			User u = userrepo.findByEmail(email).get();
			return u;
		} else
			throw new UserNotFoundException("User details are not found");

	}

	@Override
	public User ShowUserByMobileNumber(String mobile) {
		if (userrepo.findByMobile(mobile).isPresent()) {
			User u = userrepo.findByMobile(mobile).get();
			return u;
		} else
			throw new UserNotFoundException("User details are not found");

	}

}
