package com.mailservice;

import java.util.List;

public interface MailService {

	
	public String sendMail(Mail mail);
	public List<Mail> getallMail();
	public Mail getbymailid(String mailid);
}
