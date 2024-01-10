package com.mailservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailRepository mailrepo;

	@Override
	public String sendMail(Mail mail) {
		Mail m = new Mail(mail.getToEmail(), mail.getSubject(), mail.getBody());
		mailrepo.save(m);
		return "Mail sent Succesfully";
	}

	@Override
	public List<Mail> getallMail() {
		List<Mail> list = mailrepo.findAll();
		if (list.isEmpty()) {
			throw new MailNotFoundException("Mail details are not found");
		}
		return list;
	}

	@Override
	public Mail getbymailid(String mailid) {
		if (mailrepo.findById(mailid).isPresent()) {
			return mailrepo.findById(mailid).get();
		} else
			throw new MailNotFoundException("Mail details are not found");

	}

}
