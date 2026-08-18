package com.acme;

import java.time.LocalDate;
import java.time.Period;

public class Food extends Product{

    private static Period defaultExpiryPeriod = Period.ofDays(Product.MAX_EXPIRY_PERIOD);
    private LocalDate bestBefore = LocalDate.now().plus(defaultExpiryPeriod);

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

}
