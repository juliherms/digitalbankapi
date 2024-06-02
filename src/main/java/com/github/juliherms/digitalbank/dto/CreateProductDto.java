package com.github.juliherms.digitalbank.dto;

import com.github.juliherms.digitalbank.entity.Product;
import com.github.juliherms.digitalbank.entity.Wallet;
import com.github.juliherms.digitalbank.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  CreateProductDto(@NotBlank String name) {

    public Product toProduct() {
        return new Product(
                name
        );
    }
}
