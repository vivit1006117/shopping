package com.equalExperts.shopping.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartResponseTest {
    private CartResponse cartResponse = new CartResponse();

    @Test
    void shouldSetTotalPriceAndSalesTax() {
        cartResponse.setTotalPrice(12.123);
        assertEquals(1.52, cartResponse.getSalesTaxAmount());
        assertEquals(13.64, cartResponse.getTotalPrice());
    }
}