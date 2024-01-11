package com.authservice.externalentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String user_id;
	private String userName;
	private String email;
	private String password;
	private String roles;
	private String mobile;
	private String address;

}
