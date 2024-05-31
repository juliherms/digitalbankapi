package com.github.juliherms.digitalbank.infra.impl;

import com.github.juliherms.digitalbank.infra.IEmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class EmailSenderFake implements IEmailSender {

    private static final Logger logger = LoggerFactory.getLogger(EmailSenderFake.class);

    @Async
    @Override
    public void sender(String recipient, String subject, String message) {
        logger.info("===== Simulando envio de email =====");
        logger.info("Destinatário: "+recipient);
        logger.info("Assunto: "+subject);
        logger.info("Mensagem: "+message);
    }
}
