package com.equalExperts.shopping.controller;

import com.equalExperts.shopping.responses.CartResponse;
import com.equalExperts.shopping.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("cart/add/{id}/{quantity}")
    public CartResponse loginUser(@PathVariable Long id,
                                  @PathVariable Long quantity) {
        return shoppingCartService.addItemToCart(id, quantity);
    }
}
