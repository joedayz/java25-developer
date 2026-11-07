package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product{

    private LocalDate bestBefore;
    private BigDecimal discount;

    public Food(String name, LocalDate bestBefore){

        //Begin prologo
        if(name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.bestBefore = bestBefore;
        //end prologo
        super(name);

    }


    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public BigDecimal getDiscount(){
        return getPrice().subtract(this.discount.add(super.getDiscount()));
    }
}
