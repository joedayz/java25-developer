package com.acme;

public class Main {

     void main() {
        Pato pato = new Pato();

        System.out.println("Pato es "+ pato);

        Food food = new Food();
        Drink drink = new Drink();

        food.getId();
        drink.getId();

        food.getPrice();
        drink.getPrice();

        //Polimorfismo

        // CPadre = Chija

        Object obj = new Product();
        obj.hashCode(); // los metodos que puedes invocar son de la clase Object.

        Object obj2 = new Food();
        Object obj3 = new Drink();

        Product p1 = new Food();
        p1.getPrice();
        Product p2 = new Drink();
        p2.getPrice();

        //Product p = new Circulo();

        //Drink d = new Product();
        //Food f = new Object();

        //int i = 15L;
        //long l = 15;


        //Rules of reference type casting

        Food x1 = new Food();

        Product x2 = new Drink();

        x1.toString(); //toString es heredado de Object
        x1.getName(); //getName es heredado de Product
        x1.getBestBefore();

        Product x3 = x1;
        x3.toString();
        x3.getName();
        //x3.getBestBefore();

        Object x4 = x1;
        x4.toString();
        //x4.getName();
        //x4.getBestBefore();

        Product x5 = (Product) x4;
        x5.toString();
        x5.getName();
        //x5.getBestBefore();

        Drink x6 =  (Drink )x2;
        //Drink x7 = (Drink) x3;

        Product a = new Product();
        a.order(new Food());

        a.order(new Drink());

    }
}
