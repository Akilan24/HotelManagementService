package com.mailservice;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

	@Id
	@Email(message = "Please provide a valid email address")
	private String toEmail;
	@NotBlank(message = "Please provide a subject for the mail")
	private String subject;
	@NotBlank(message = "Please provide a body for the mail")
	private String body;
}
