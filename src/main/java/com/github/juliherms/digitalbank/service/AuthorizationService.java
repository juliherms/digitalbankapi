package com.github.juliherms.digitalbank.service;

import com.github.juliherms.digitalbank.client.AuthorizationClient;
import com.github.juliherms.digitalbank.dto.TransferDto;
import com.github.juliherms.digitalbank.exception.DigitalBankException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new DigitalBankException();
        }

        return Objects.requireNonNull(resp.getBody()).authorized();
    }
}
