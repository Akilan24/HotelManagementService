package com.mailservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailRepository mailrepo;

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	ApplicationEventPublisher aep;

	@Override
	public String sendMail(Mail mail) {
		Mail m = new Mail(mail.getToEmail(), mail.getSubject(), mail.getBody());
		aep.publishEvent(m);
		mailrepo.save(m);
		return "Mail sent Succesfully";
	}

	@EventListener
	public void mailsender(Mail m) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fromemail@gmail.com");
		message.setTo(m.getToEmail());
		message.setText(m.getBody());
		message.setSubject(m.getSubject());
		mailSender.send(message);

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
