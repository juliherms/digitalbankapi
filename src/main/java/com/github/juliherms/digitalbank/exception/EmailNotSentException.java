package com.github.juliherms.digitalbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class EmailNotSentException extends DigitalBankException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Email not sent.");
        pb.setDetail("There was a problem sending email.");

        return pb;
    }
}
