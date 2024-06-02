package com.github.juliherms.digitalbank.service;

import com.github.juliherms.digitalbank.dto.CreateProductDto;
import com.github.juliherms.digitalbank.dto.ResponseProductDto;
import com.github.juliherms.digitalbank.entity.Product;
import com.github.juliherms.digitalbank.exception.ProductDataAlreadyExistsException;
import com.github.juliherms.digitalbank.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CacheEvict(value = "products", allEntries = true)
    public Product create(CreateProductDto dto) {

        var productDb = productRepository.findByName(dto.name());
        if (productDb.isPresent()) {
            throw new ProductDataAlreadyExistsException("Name already exists");
        }

        return productRepository.save(dto.toProduct());
    }

    @Cacheable(value = "products")
    public List<ResponseProductDto> list(){
        return productRepository.findAll().stream().map(ResponseProductDto::new).toList();
    }
}
