package com.github.juliherms.digitalbank.repository;

import com.github.juliherms.digitalbank.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}