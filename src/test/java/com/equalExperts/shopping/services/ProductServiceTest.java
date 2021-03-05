package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private ProductService productService  = new ProductService();

    @Test
    void shouldReturnDoveProduct() {
        assertEquals(new Product(20L, "Dove Soap", 39.99), productService.getProduct(20L));
    }
}