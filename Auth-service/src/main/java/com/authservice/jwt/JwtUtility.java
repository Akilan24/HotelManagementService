package com.authservice.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.authservice.proxy.UserProxy;
import com.authservice.service.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;  

@Component
public class JwtUtility implements Serializable {

	private static final long serialVersionUID = 1L;

	@Value("${jwtSecret}")
	private String jwtSecret = "my$ecretKey";

	@Value("${jwtExpirationMs}")
	private int jwtExpirationMs;

	@Autowired
	UserProxy userproxy;

	public String generateToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		String username = ((UserDetailsImpl) authentication.getPrincipal()).getUsername();
		Date now = new Date();
		return Jwts.builder().setSubject(username).claim("roles", roles)
				.setIssuedAt(now).setExpiration(new Date(now.getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public Map<String, Object> createToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		long phoneNumber = Long.parseLong(userproxy.showUserByUserName(username).getMobile());
		int ph = (int) (phoneNumber / 10000);
		System.out.println(ph);
		claims.put("cartId", ph);

		return claims;

	}

	public boolean validatieToken(String token) {
		parse(token);
		return true;
	}

	private Jws<Claims> parse(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
	}

	public String getUsername(String token) {
		return parse(token).getBody().getSubject();
	}

}
