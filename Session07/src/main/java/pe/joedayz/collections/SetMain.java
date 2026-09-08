package pe.joedayz.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMain {

    static void main() {


        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");
        Product p3 = new Food("Cookie");

        List<Product> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);


        Set<Product> productSet1 = new HashSet<>();
        Set<Product> productSet2 = new HashSet<>(20);
        Set<Product> productSet3 = new HashSet<>(20, 0.75f);
        Set<Product> productSet4 = new HashSet<>(list);
        Set<Product> productSet5 = Set.of(p1, p2); // lista inmutable

        //productSet5.add(new Food("Bread")); // This will throw an UnsupportedOperationException


        Set<Product> menu = new HashSet<>();

        menu.add(p1);  // insert element
        menu.add(p2);  // insert element
        menu.add(p2);  // insert nothing
        menu.add(p3);  // insert element

        menu.remove(p1);  // remove element
        menu.remove(p1);  // remove nothing

        boolean hasTea = menu.contains(p2);

        System.out.println("Menu: " + menu);

    }
}
