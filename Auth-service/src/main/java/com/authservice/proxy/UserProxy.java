package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.User;

import jakarta.validation.Valid;

@FeignClient(name = "user-service", url = "http://localhost:8081/User")
@Service
public interface UserProxy {

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> listUser();

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody @Valid User user);

	@PutMapping("/updateuser/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody @Valid User user);

	@PutMapping("/updatepassword/{user_id}/{password}")
	public ResponseEntity<String> updatepassword(@PathVariable String user_id, @PathVariable @Valid String password);

	@GetMapping("/getuserbyid/{user_id}")
	public ResponseEntity<User> showUser(@PathVariable String userId);

	@GetMapping("/getuserbyname/{username}")
	public ResponseEntity<User> showUserByUserName(@PathVariable String username);

	@GetMapping("/getuserbyemail/{email}")
	public ResponseEntity<User> showUserByEmail(@PathVariable String email);

	@GetMapping("/getuserbymobile/{mobile}")
	public ResponseEntity<User> showUserByMobileNumber(@PathVariable String mobile);

	@GetMapping("/deleteuserbyid/{user_id}")
	public ResponseEntity<String> remove(@PathVariable String userId);
}
