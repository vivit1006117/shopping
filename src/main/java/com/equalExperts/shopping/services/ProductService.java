package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct(Long id) {
        return new Product(id, "Dove Soap", 39.99);
    }
}
