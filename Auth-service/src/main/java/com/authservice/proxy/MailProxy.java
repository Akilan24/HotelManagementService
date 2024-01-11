package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.authservice.externalentity.Mail;

import jakarta.validation.Valid;

@FeignClient(name = "mail-service", url = "http://localhost:8086/")
public interface MailProxy {

	@PostMapping("/Mail/adduser")
	public ResponseEntity<String> sendMail(@RequestBody @Valid Mail mail);

	@GetMapping("/Mail/getallmail")
	public ResponseEntity<List<Mail>> getallMail();

	@GetMapping("/Mail/getbymailid/{mailid}")
	public ResponseEntity<Mail> getbymailid(@PathVariable @Valid String mailid);
}
