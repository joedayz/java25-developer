package org.example.sobreescritura;

public class Food extends Product {

    @Override
    public void showDetails() {
        System.out.println("Food: Hamburger");
    }
}
