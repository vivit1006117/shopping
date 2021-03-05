package com.equalExperts.shopping.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Product {
    private Long id;
    private String name;
    private Double price;

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }
}
