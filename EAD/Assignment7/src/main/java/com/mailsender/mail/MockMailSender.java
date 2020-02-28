package com.mailsender.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mock")
@Primary
public class MockMailSender implements MailSender {
	@Override
	public void sendMail() {
		System.out.println("Mail is sending through MockMailSender");
	}

}
