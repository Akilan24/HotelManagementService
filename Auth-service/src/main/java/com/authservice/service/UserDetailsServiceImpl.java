package com.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authservice.externalentity.User;
import com.authservice.proxy.UserProxy;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserProxy userproxy;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userproxy.showUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found with username "+username);
		}
		return UserDetailsImpl.getUser(user);
	}

}
