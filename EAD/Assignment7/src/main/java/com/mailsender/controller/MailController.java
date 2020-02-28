package com.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailsender.mail.MailSender;

@RestController
public class MailController {
	private MailSender mail;
	
//	@Autowired 
//	public MailController(MailSender mail) {
//		this.mail = mail;
//	}
	
	@Autowired
	public void setMail(MailSender mail) {
		this.mail = mail;
	}
	
	
	@GetMapping("/SendMail")
	public String sendMail() {
		mail.sendMail();
		return "Mail sended successfully";
	}
	@GetMapping("/")
    public String home(){
        return "Hello World!";
    }
}
