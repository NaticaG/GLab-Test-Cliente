package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.test.dto.EmailBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(EmailBody emailBody)  {
		LOGGER.info("EmailBody: {}", emailBody.toString());
		Boolean respuesta = false;
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(emailBody.getEmail());
			helper.setText(emailBody.getContent(), true);
			helper.setSubject(emailBody.getSubject());

			sender.send(message);
			Thread.sleep(5000);
			respuesta = true;
			LOGGER.info("Mail enviado!");
		} catch (MessagingException e) {
			LOGGER.error("Hubo un error al enviar el mail: {}", e);
			respuesta = false;
		}
		catch (InterruptedException e) {
			LOGGER.error("Hubo un error al enviar el mail: {}", e);
			respuesta = false;
		}
		return respuesta;
	}

}
//import jakarta.mail.MessagingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import jakarta.mail.internet.MimeMessage;
//
//@Component
//public class EmailService {
//	private final static String EMAIL_CONFIRMATION_SUBJECT = "Confirm your udeesa account";
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	public void sendConfirmationEmail(String token, String email) {
//		// build email
//		// send message
//		String message = "Welcome to Udeesa, test token" + token;
//		String from = "no-reply@udeesa.org";
//		send(email, from, message);
//	}
//
//	@Async
//	void send(String to, String from, String email) {
//		try {
//			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//			MimeMessageHelper helper =
//					new MimeMessageHelper(mimeMessage, "utf-8");
//			helper.setFrom(from);
//			helper.setTo(to);
//			helper.setSubject(EMAIL_CONFIRMATION_SUBJECT);
//			helper.setText(email);
//			javaMailSender.send(mimeMessage);
//		} catch (MessagingException e) {
////			LOGGER.error("failed to send email", e);
//			throw new IllegalStateException("failed to send email");
//		}
//	}
//}