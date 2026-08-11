package com.acme;

import java.math.BigDecimal;

public class Item {

    private static int maxId = 0;

    private final int id;
    private final String name;
    private final BigDecimal price;

    {
        id = ++maxId;
    }

    public Item(){
        this.name = "default";
        this.price = BigDecimal.ZERO;
    }

    public Item(String name){
        this.name = name;
        this.price = BigDecimal.ZERO;
    }

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    static void main() {
        Item item1 = new Item("empanada");
        Item item2 = new Item("taco", new BigDecimal("1.99"));
        Item item3 = new Item();

        System.out.println("Max ID: " + Item.maxId); // Output: Max ID: 3
    }
}
