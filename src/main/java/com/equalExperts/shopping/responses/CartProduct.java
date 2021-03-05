package com.equalExperts.shopping.responses;

import com.equalExperts.shopping.domain.Product;

public class CartProduct {
    private Product product;
    private Long quantity;

    public CartProduct(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }
}
