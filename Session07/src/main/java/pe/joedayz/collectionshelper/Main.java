package pe.joedayz.collectionshelper;

import pe.joedayz.collections.Drink;
import pe.joedayz.collections.Food;
import pe.joedayz.collections.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");
        Product p3 = new Food("Cookie");

        List<Product> menu = new ArrayList<>();
        menu.add(p1);
        menu.add(p2);
        menu.add(p3);

        Collections.sort(menu);

        System.out.println("Sorted menu: " + menu);

        Collections.reverse(menu);
        System.out.println("Reversed menu: " + menu);

        Collections.shuffle(menu);
        System.out.println("Shuffled menu: " + menu);

        Collections.sort(menu);

        System.out.println("Sorted menu: " + menu);

        int x = Collections.binarySearch(menu, p2); // antes de binarysearch primero ordenen



        System.out.println("Binary search for " + p2.getName() + ": " + x);


        Collections.fill(menu, new Food("Pie"));

        System.out.println("Menu after fill: " + menu);

    }
}
