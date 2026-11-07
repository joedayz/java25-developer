package com.acme.pasedeparametros;

import com.acme.Product;

public class Main {

    public static void main(String[] args) {
        double v1 = 1.99;
        change(v1);
        System.out.println("v1: " + v1);

        Product p1 = new Product();
        order(p1);
        System.out.println("p1 price: " + p1.getPrice());
    }

    static void order(Product p2){
        p2.setPrice(new java.math.BigDecimal("1.99"));
    }

    static void change(double v2){
        v2 = 2.99;
    }
}




