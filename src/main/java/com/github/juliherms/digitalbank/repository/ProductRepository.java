package com.github.juliherms.digitalbank.repository;

import com.github.juliherms.digitalbank.entity.Product;
import com.github.juliherms.digitalbank.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
}
