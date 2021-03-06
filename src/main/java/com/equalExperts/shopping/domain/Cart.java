package com.equalExperts.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Cart {
    private Map<Long, Long> products = new HashMap<>();

    public Cart(){}

    public void addProduct(Long id, Long quantity) {
        if (products.containsKey(id)) {
            quantity += products.get(id);
            products.remove(id);
        }
        products.put(id, quantity);
    }

    public Map<Long, Long> getProduct() {
        return this.products;
    }
}
