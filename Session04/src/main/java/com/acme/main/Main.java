package com.acme.main;

import com.acme.Pato;
import com.acme.Product;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        //String s = "hola";
        //java.util.Random random = new java.util.Random();

        Product productObj = new Product();
        productObj.setPrice(new java.math.BigDecimal("19.99"));
        System.out.println("Product price: " + productObj.getPrice());

        Product.setDefaultExpiryPeriod(5);

        productObj = null;

        //Math m = new Math();

        // java.lang.OutOfMemoryError
        random();

        max(2, 5);

        abs(5.5);

        Product.setDefaultExpiryPeriod(7);



        System.out.println("Product default expiry period set to 7 days.");

        productObj.setFiscalDetails(19.99, 0.1, 0.21);

        productObj.setFiscalDetails();
        productObj.setFiscalDetails(1.99);
        productObj.setFiscalDetails(1.99, 0.1);
        productObj.setFiscalDetails(new double[]{1.99, 0.1, 0.21});


        Pato lucas = new Pato();  // constructor por defecto

    }
}
