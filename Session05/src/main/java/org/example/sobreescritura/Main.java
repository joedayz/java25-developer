package org.example.sobreescritura;

public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Food(),
                new Drink(),
                new Food()
        };

        for (Product product : products) {
            product.showDetails();
        }
    }
}
