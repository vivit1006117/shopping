package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Cart;
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
    private CartService cartService;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        cartService = Mockito.mock(CartService.class);
        productService = Mockito.mock(ProductService.class);
        shoppingCartService = new ShoppingCartService(cartService, productService);
    }

    @Test
    void ShouldAddItemToCart() {
        when(cartService.getCart()).thenCallRealMethod();;
        when(productService.getProduct(anyLong())).thenReturn(new Product(20L, "Dove Soap", 39.99));
        CartResponse cartResponse = shoppingCartService.addItemToCart(20L, 5L);
        assertEquals("199.95", cartResponse.getTotalPrice());
        assertEquals(39.99, cartResponse.getCartProducts().get(0).getProduct().getPrice());
        assertEquals(5, cartResponse.getCartProducts().get(0).getQuantity());
        assertEquals("Dove Soap", cartResponse.getCartProducts().get(0).getProduct().getName());
    }

    @Test
    void ShouldAdditionalAddItemToCart() {
        Cart cart = new Cart();
        cart.addProduct(20L, 5L);
        when(cartService.getCart()).thenReturn(cart);
        when(productService.getProduct(anyLong())).thenReturn(new Product(20L, "Dove Soap", 39.99));
        CartResponse cartResponse = shoppingCartService.addItemToCart(20L, 3L);
        assertEquals("319.92", cartResponse.getTotalPrice());
        assertEquals(39.99, cartResponse.getCartProducts().get(0).getProduct().getPrice());
        assertEquals(8, cartResponse.getCartProducts().get(0).getQuantity());
        assertEquals("Dove Soap", cartResponse.getCartProducts().get(0).getProduct().getName());
    }
}