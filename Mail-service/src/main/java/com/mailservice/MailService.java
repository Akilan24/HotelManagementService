package com.mailservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

	
	public String sendMail(Mail mail);
	public List<Mail> getallMail();
	public Mail getbymailid(String mailid);
}
