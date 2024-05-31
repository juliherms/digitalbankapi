package com.github.juliherms.digitalbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DigitalBankException extends RuntimeException {

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("PicPay internal server error");

        return pb;
    }
}
