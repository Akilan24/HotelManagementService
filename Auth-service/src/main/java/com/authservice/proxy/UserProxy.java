package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.User;

import jakarta.validation.Valid;

@FeignClient(name = "user-service", url = "http://localhost:8081/User")
public interface UserProxy {

	@GetMapping("/User/getallusers")
	public List<User> listUser();

	@PostMapping("/User/adduser")
	public String addUser(@RequestBody @Valid User user);

	@PutMapping("/User/updateuser/{user_id}")
	public User updateUser(@PathVariable("user_id") String userId, @RequestBody @Valid User user);

	@PutMapping("/updateuser/{user_id}/{password}")
	public String updateuser(@PathVariable String user_id, @PathVariable @Valid String password);

	@GetMapping("/User/getuserbyid/{user_id}")
	public User showUser(@PathVariable("user_id") String userId);

	@GetMapping("/User/getuserbyname/{username}")
	public User showUserByUserName(@PathVariable("username") String username);

	@GetMapping("/User/getuserbyemail/{email}")
	public User showUserByEmail(@PathVariable("email") String email);

	@GetMapping("/User/getuserbymobile/{mobile}")
	public User showUserByMobileNumber(@PathVariable("mobile") String mobile);

	@GetMapping("/User/deleteuserbyid/{user_id}")
	public String remove(@PathVariable("user_id") String userId);
}
