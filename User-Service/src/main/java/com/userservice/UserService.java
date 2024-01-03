package com.userservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public String addUser(User user);

	public String removeUser(String user_id);

	public List<User> ShowAllUser();

	public User ShowUserByUserId(String user_id);

	public User ShowUserByUserName(String username);

	public User ShowUserByEmail(String email);

	public User ShowUserByMobileNumber(String mobilenumebr);

	public User updateUser(String user_id, User user);

}
