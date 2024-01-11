package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.Mail;

import jakarta.validation.Valid;

@FeignClient(name = "mail-service", url = "http://localhost:8086/Mail")
public interface MailProxy {

	@PostMapping("/Mail/adduser")
	public String sendMail(@RequestBody @Valid Mail mail);

	@GetMapping("/Mail/getallmail")
	public List<Mail> getallMail();

	@GetMapping("/Mail/getbymailid/{mailid}")
	public Mail getbymailid(@PathVariable @Valid String mailid);
}
