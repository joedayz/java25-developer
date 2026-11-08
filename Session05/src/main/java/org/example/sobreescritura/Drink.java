package org.example.sobreescritura;

public class Drink extends Product {
    @Override
    protected void showDetails() {
        System.out.println("Drink: Cola");
    }
}
