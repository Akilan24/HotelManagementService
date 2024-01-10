package com.authservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="user-service",url = "http://localhost:8081/User")
public interface UserProxy {
	@GetMapping("/getuserbyname/{username}")
	public User showUserByUserName(@PathVariable String username);	 
}
