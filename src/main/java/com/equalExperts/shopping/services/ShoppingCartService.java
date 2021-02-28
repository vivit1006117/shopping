package com.equalExperts.shopping.services;

import com.equalExperts.shopping.domain.Cart;
import com.equalExperts.shopping.domain.Product;
import com.equalExperts.shopping.responses.CartProduct;
import com.equalExperts.shopping.responses.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShoppingCartService {
    private ProductService productService;

    Cart cart;
    @Autowired
    public ShoppingCartService(ProductService productService) {
        this.productService = productService;
        cart  = new Cart();
    }

    public CartResponse addItemToCart(Long id, Long quantity) {
        Product product = productService.getProduct(id);
        cart.addProduct(id, quantity);
        return createCartResponse(cart);
    }

    private CartResponse createCartResponse(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        double total = 0.0;
        for (Map.Entry<Long, Long> set : cart.getProduct().entrySet()) {
            Product productInCart = productService.getProduct(set.getKey());
            CartProduct cartProduct = new CartProduct(productInCart, set.getValue());
            cartResponse.setCartProducts(cartProduct);
            total = total + (productInCart.getPrice() * set.getValue());
        }
        cartResponse.setTotalPrice(total);
        return cartResponse;
    }
}
