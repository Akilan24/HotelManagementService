package com.mailservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class MailController {

	@Autowired
	MailService mailservice;

	public ResponseEntity<String> sendMail(@RequestBody Mail mail) {
		return new ResponseEntity<>(mailservice.sendMail(mail), HttpStatus.OK);
	}

	public ResponseEntity<List<Mail>> getallMail() {
		return new ResponseEntity<>(mailservice.getallMail(), HttpStatus.OK);
	}
	public ResponseEntity<Mail> getbymailid(@PathVariable String mailid) {
		return new ResponseEntity<>(mailservice.getbymailid(mailid), HttpStatus.OK);
	}
}
