package com.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.authservice.jwt.EntryPointJwt;
import com.authservice.jwt.TokenFilter;
import com.authservice.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

	@Autowired
	TokenFilter tokenFilter;
	@Autowired
	EntryPointJwt entryPoint;
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
	public DaoAuthenticationProvider authenticate() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain doFilter(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint(entryPoint)
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/Main/**").permitAll()
				.requestMatchers("/registration/authorization/**").authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}
