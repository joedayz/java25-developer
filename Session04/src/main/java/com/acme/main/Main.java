package com.acme.main;

import com.acme.Product;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        //String s = "hola";
        //java.util.Random random = new java.util.Random();

        Product product = new Product();
        product.setPrice(new java.math.BigDecimal("19.99"));
        System.out.println("Product price: " + product.getPrice());

        Product.setDefaultExpiryPeriod(5);

        product = null;

        //Math m = new Math();

        // java.lang.OutOfMemoryError
        random();

        max(2, 5);

        abs(5.5);

        Product.setDefaultExpiryPeriod(7);

    }
}
