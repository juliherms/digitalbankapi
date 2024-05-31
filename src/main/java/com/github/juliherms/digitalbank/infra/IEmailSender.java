package com.github.juliherms.digitalbank.infra;

public interface IEmailSender {

    void sender(String recipient, String subject, String message);
}
