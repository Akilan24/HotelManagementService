package com.authservice;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class AuthController {

	@Autowired
	DaoAuthenticationProvider authenticationManagaer;

//	@Autowired
//	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	JwtUtility jwtUtility;

	@PostMapping("/signin")
	public ResponseEntity<?> validateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManagaer.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		String jwtToken = jwtUtility.generateToken(authentication);
		Collection<? extends GrantedAuthority> authorites = userDetails.getAuthorities();
		List<String> roles = authorites.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		JSONResponse jsonResponse = new JSONResponse(jwtToken, userDetails.getUsername(), roles);
		return ResponseEntity.ok(jsonResponse);
	}

}
