package org.mss.seaTravel.service;

import javax.transaction.Transactional;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class EmailServiceImpl implements IEmailService {
	private final JavaMailSender mailSender ;

	
	
	
	public EmailServiceImpl(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}




	@Override
	public void sendEmail(String sendTo, String subject, String msg) {
   SimpleMailMessage simpleMessage=new SimpleMailMessage();
   simpleMessage.setFrom("mssconsulting22@gmail.com");
   simpleMessage.setTo(sendTo);
   simpleMessage.setSubject(subject);
   simpleMessage.setText(msg);
   try {
		this.mailSender.send(simpleMessage);

   } catch (Exception e) {
       e.printStackTrace();
	}
	}
}
