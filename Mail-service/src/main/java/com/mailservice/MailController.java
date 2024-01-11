package com.mailservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Mail")
public class MailController {

	@Autowired
	MailService mailservice;

	@PostMapping("/adduser")
	public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
		return new ResponseEntity<>(mailservice.sendMail(mail), HttpStatus.OK);
	}

	@GetMapping("/getallmail")
	public ResponseEntity<List<Mail>> getallMail() {
		return new ResponseEntity<>(mailservice.getallMail(), HttpStatus.OK);
	}

	@GetMapping("/getbymailid/{mailid}")
	public ResponseEntity<Mail> getbymailid(@PathVariable @Valid String mailid) {
		return new ResponseEntity<>(mailservice.getbymailid(mailid), HttpStatus.OK);
	}
}
