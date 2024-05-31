package com.github.juliherms.digitalbank.infra.impl;

import com.github.juliherms.digitalbank.exception.EmailNotSentException;
import com.github.juliherms.digitalbank.infra.IEmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class EmailSender implements IEmailSender {

    private final JavaMailSender emailSender;

    public EmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Async
    @Override
    public void sender(String recipient, String subject, String message) {
        try {
            var email = new SimpleMailMessage();
            email.setFrom("naoresponda@codechella.com.br");
            email.setTo(recipient);
            email.setSubject(subject);
            email.setText(message);
            emailSender.send(email);
        } catch (Exception e) {
            throw new EmailNotSentException();
        }
    }
}
