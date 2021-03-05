package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {
    private CartService cartService = new CartService();

    @Test
    void shouldGetEmptyCart() {
        assertEquals(new Cart(), cartService.getCart());
    }
}