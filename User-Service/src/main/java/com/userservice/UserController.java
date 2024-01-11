package com.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> listUser() {
		return new ResponseEntity<>(userService.ShowAllUser(), HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<String> adduser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}

	@PutMapping("/updateuser/{user_id}")
	public ResponseEntity<User> updateuser(@PathVariable String user_id, @RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.updateUser(user_id, user), HttpStatus.OK);
	}

	@PutMapping("/updatepassword/{user_id}/{password}")
	public ResponseEntity<String> updatepassword(@PathVariable String user_id, @PathVariable @Valid String password) {
		return new ResponseEntity<>(userService.updateUserpasswordbyId(user_id, password), HttpStatus.OK);
	}

	@GetMapping("/getuserbyid/{user_id}")
	public ResponseEntity<User> showUser(@PathVariable String user_id) {
		return new ResponseEntity<>(userService.ShowUserByUserId(user_id), HttpStatus.OK);
	}

	@GetMapping("/getuserbyname/{username}")
	public ResponseEntity<User> showUserByUserName(@PathVariable String username) {
		return new ResponseEntity<>(userService.ShowUserByUserName(username), HttpStatus.OK);
	}

	@GetMapping("/getuserbyemail/{email}")
	public ResponseEntity<User> showUserByEmail(@PathVariable String email) {
		return new ResponseEntity<>(userService.ShowUserByEmail(email), HttpStatus.OK);
	}

	@GetMapping("/getuserbymobile/{mobile}")
	public ResponseEntity<User> showUserByMobileNumber(@PathVariable String mobile) {
		return new ResponseEntity<>(userService.ShowUserByMobileNumber(mobile), HttpStatus.OK);
	}

	@GetMapping("/deleteuserbyid/{user_id}")
	public ResponseEntity<String> remove(@PathVariable String user_id) {
		return new ResponseEntity<>(userService.removeUser(user_id), HttpStatus.OK);
	}

}
