package com.acme;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Drink extends Product{


    @Override
    public BigDecimal getPrice() {
        LocalTime now = LocalTime.now();
        BigDecimal discount = (now.isAfter(LocalTime.of(17, 30))
                && now.isBefore(LocalTime.of(18, 30)))
                ? super.getPrice().multiply(BigDecimal.valueOf(0.2))
                : BigDecimal.ZERO;
        return super.getPrice().subtract(discount);
    }
}
