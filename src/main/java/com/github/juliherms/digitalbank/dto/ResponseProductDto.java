package com.github.juliherms.digitalbank.dto;

import com.github.juliherms.digitalbank.entity.Product;

import java.io.Serializable;

public record ResponseProductDto(String name) implements Serializable {
    public  ResponseProductDto(Product product){
        this(product.getName());
    }
}
