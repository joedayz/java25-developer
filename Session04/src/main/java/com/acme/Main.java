package com.acme;

public class Main {

    static void main() {
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

        Food x1 = new Food();
        Object x2 = x1;

        Product x3 = (Product) x2;
        x3.hashCode();
        x3.toString();
    }
}
