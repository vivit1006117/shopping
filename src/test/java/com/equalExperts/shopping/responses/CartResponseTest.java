package com.equalExperts.shopping.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartResponseTest {
    private CartResponse cartResponse = new CartResponse();

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLaces() {
        cartResponse.setTotalPrice(12.123);
        assertEquals("12.12", cartResponse.getTotalPrice());
    }

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLacesUpperIf3rdValueGreaterThan5() {
        cartResponse.setTotalPrice(12.126);
        assertEquals("12.13", cartResponse.getTotalPrice());
    }

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLacesLowerIf3rdValueEqualTo5() {
        cartResponse.setTotalPrice(12.125);
        assertEquals("12.12", cartResponse.getTotalPrice());
    }
}