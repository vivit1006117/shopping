package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    public Cart getCart() {
        return new Cart();
    }
}
