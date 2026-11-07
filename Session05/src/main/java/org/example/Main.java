package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Food food = new Food("Cake", null);
        food.getBestBefore();

        Drink drink = new Drink("Tea");
        drink.getName();

        //Polimorfismo
        Product product1 = new Food("Cake", null);
        //product1.getBestBefore(); //No se puede invocar el metodo getBestBefore() porque product1 es de tipo Product y no de tipo Food


        Product product2 = new Drink("Coffee");


        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Clase parent  =  Clase hija

        Object x1 = new Food("Cake", null);
        Product x2  = new Food("Cake", null);
        Food x3 = new Food("Cake", null);


        //String s = new BigDecimal();


        Food f = new Food("Cake", null);
        Product p = new Drink("Coffee");

        Food otra = (Food) p; // ClassCastException


    }
}
