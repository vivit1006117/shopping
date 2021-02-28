package com.equalExperts.shopping.responses;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private List<CartProduct> cartProducts = new ArrayList<>();
    private String totalPrice;

    public CartResponse(){}


    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(CartProduct cartProduct) {
        this.cartProducts.add(cartProduct);
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        this.totalPrice = df.format(totalPrice);
    }
}
