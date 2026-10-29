package com.acme;

import java.math.BigDecimal;

public class FinalSample {

    private final String name;
    private final BigDecimal price = BigDecimal.ZERO;

    public FinalSample(){
        //this.name = "Cafe";  NO COMPILA

        this.name = "Cafe";
    }


    public void foo(final String s){
        //this.name = "Orange";
        //s = "abc";
    }

    public BigDecimal discount(BigDecimal price){
        return price.multiply(BigDecimal.valueOf(0.9));
    }

}
