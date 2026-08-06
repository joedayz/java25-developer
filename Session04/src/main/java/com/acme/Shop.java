package com.acme;

public class Shop {


    static void main() {
        new Product(); // creando un objeto

        Product p1 =  new Product();
        Product p2 =  new Product();
        Product p3 =  new Product();




        p1.setName("Tea");
        p2.setName("Cake");
        System.out.println("p1 name: " + p1.getName());
        System.out.println("p2 name: " + p2.getName());
        System.out.println("p3 name: " + p3.getName());

        p1.setName("Coffee");

        System.out.println("p1 name: " + p1.getName());

        System.out.println("Total de productos es " + Product.getContador());

        System.out.println("Total de productos v2 es " +  p3.getContador());

        System.out.println("Total de productos v2 es " +  p1.getContador());

    }
}
