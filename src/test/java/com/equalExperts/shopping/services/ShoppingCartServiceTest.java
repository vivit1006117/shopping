package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Product;
import com.equalExperts.shopping.responses.CartResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ShoppingCartServiceTest {
    private ShoppingCartService shoppingCartService;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = Mockito.mock(ProductService.class);
        shoppingCartService = new ShoppingCartService(productService);
    }

    @Test
    void ShouldAddItemToCart() {
        when(productService.getProduct(anyLong())).thenReturn(new Product(20L, "Dove Soap", 39.99));
        CartResponse cartResponse = shoppingCartService.addItemToCart(20L, 5L);
        assertEquals(224.94, cartResponse.getTotalPrice());
        assertEquals(39.99, cartResponse.getCartProducts().get(0).getProduct().getPrice());
        assertEquals(5, cartResponse.getCartProducts().get(0).getQuantity());
        assertEquals("Dove Soap", cartResponse.getCartProducts().get(0).getProduct().getName());
    }

    @Test
    void ShouldAdditionalAddItemToCart() {
        when(productService.getProduct(anyLong())).thenReturn(new Product(20L, "Dove Soap", 39.99));
        shoppingCartService.addItemToCart(20L, 5L);
        CartResponse cartResponse = shoppingCartService.addItemToCart(20L, 3L);
        assertEquals(359.91, cartResponse.getTotalPrice());
        assertEquals(39.99, cartResponse.getCartProducts().get(0).getProduct().getPrice());
        assertEquals(8, cartResponse.getCartProducts().get(0).getQuantity());
        assertEquals("Dove Soap", cartResponse.getCartProducts().get(0).getProduct().getName());
    }

    @Test
    void ShouldAdd2ItemsToCart() {
        when(productService.getProduct(20L)).thenReturn(new Product(20L, "Dove Soap", 39.99));
        when(productService.getProduct(30L)).thenReturn(new Product(30L, "Axe Deo", 99.99));
        shoppingCartService.addItemToCart(20L, 2L);
        CartResponse cartResponse = shoppingCartService.addItemToCart(30L, 2L);
        assertEquals(39.99, cartResponse.getCartProducts().get(0).getProduct().getPrice());
        assertEquals(2, cartResponse.getCartProducts().get(0).getQuantity());
        assertEquals("Dove Soap", cartResponse.getCartProducts().get(0).getProduct().getName());

        assertEquals(99.99, cartResponse.getCartProducts().get(1).getProduct().getPrice());
        assertEquals(2, cartResponse.getCartProducts().get(1).getQuantity());
        assertEquals("Axe Deo", cartResponse.getCartProducts().get(1).getProduct().getName());

        assertEquals(35.00, cartResponse.getSalesTaxAmount());
        assertEquals(314.96, cartResponse.getTotalPrice());
    }
}