package com.github.juliherms.digitalbank.service;

import com.github.juliherms.digitalbank.dto.CreateWalletDto;
import com.github.juliherms.digitalbank.entity.Wallet;
import com.github.juliherms.digitalbank.exception.WalletDataAlreadyExistsException;
import com.github.juliherms.digitalbank.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}
