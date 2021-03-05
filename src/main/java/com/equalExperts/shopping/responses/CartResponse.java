package com.equalExperts.shopping.responses;

import java.util.ArrayList;
import java.util.List;

import static com.equalExperts.shopping.utils.Converter.roundDecimalTo2Points;

public class CartResponse {
    private List<CartProduct> cartProducts = new ArrayList<>();
    private double totalPrice;
    private double salesTaxAmount ;

    public CartResponse(){}


    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(CartProduct cartProduct) {
        this.cartProducts.add(cartProduct);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        setSalesTaxAmount(totalPrice);
        totalPrice += this.salesTaxAmount;
        this.totalPrice = roundDecimalTo2Points(totalPrice);;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    private void setSalesTaxAmount(double salesTaxAmount) {
        double totalSales = salesTaxAmount * 12.5 / 100;
        this.salesTaxAmount = roundDecimalTo2Points(totalSales);
    }
}
