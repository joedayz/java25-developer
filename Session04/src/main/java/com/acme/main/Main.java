package com.acme.main;


import com.acme.Product;

public class Main {
    public static void main(String[] args) {
        //String s = "hola";
        //java.util.Random random = new java.util.Random();

        Product product = new Product();
        product.setPrice(new java.math.BigDecimal("19.99"));
        System.out.println("Product price: " + product.getPrice());

        Product.setDefaultExpiryPeriod(5);

        product = null;


        // java.lang.OutOfMemoryError

    }
}
