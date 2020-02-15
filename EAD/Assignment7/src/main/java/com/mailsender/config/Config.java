package com.mailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mailsender.mail.MockMailSender;
import com.mailsender.mail.SmtpMailSender;

@Configuration
public class Config {

	@Bean
	public MockMailSender mockMail() {
		return new MockMailSender();
	}
	
	@Bean
	public SmtpMailSender smtpMail() {
		return new SmtpMailSender();
	}	
}