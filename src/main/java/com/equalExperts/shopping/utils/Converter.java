package com.equalExperts.shopping.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

    public static double roundDecimalTo2Points(double totalPrice) {
        int price = (int)(totalPrice *  1000);
        int thirdValue = price % 10;
        if (thirdValue >= 5) {
            totalPrice += 0.001;
        }
        BigDecimal bigDecimal = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_EVEN);
        return bigDecimal.doubleValue();
    }
}
