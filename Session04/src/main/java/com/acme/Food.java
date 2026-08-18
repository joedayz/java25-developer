package com.acme;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Food extends Product{

    private static Period defaultExpiryPeriod = Period.ofDays(Product.MAX_EXPIRY_PERIOD);
    private LocalDate bestBefore = LocalDate.now().plus(defaultExpiryPeriod);
    private BigDecimal discount;

    static{

        System.out.println("Cargando Food");
    }

    {
        System.out.println("Bloque de inicialización de instancia de Food");
    }


    public Food(){
        super();
        System.out.println("Constructor de Food");
    }

    public Food(String name, LocalDate bestBefore) {
        super(name);
        this.bestBefore = bestBefore;
    }



    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }


    public BigDecimal getDiscount() {
        return getPrice().subtract(this.discount.add(super.getDiscount()));
    }
}
