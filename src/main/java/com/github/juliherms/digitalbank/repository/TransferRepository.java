package com.github.juliherms.digitalbank.repository;

import com.github.juliherms.digitalbank.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
