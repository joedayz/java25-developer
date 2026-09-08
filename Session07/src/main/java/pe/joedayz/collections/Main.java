package pe.joedayz.collections;

import java.util.*;

public class Main {

    static void main() {
        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");
        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);

        List<Product> list1 = new ArrayList<>();
        List<Product> list2 = new ArrayList<>(20);
        List<Product> list3 = new ArrayList<>(products);

        List<Product> list4 = Arrays.asList(p1, p2); // [ _ , _]
        //list4.add(new Food()); // This will throw an UnsupportedOperationException

        list4.set(0, new Food("Cake"));  // si te deja cambiar el elemento del indice 0
        list4.set(1, new Drink("Tea")); // si te deja cambiar el elemento del indice 1
        //list4.remove(1);

        List<Product> list5 = List.of(p1, p2); // lista inmutable
        //list5.add(new Food()); // This will throw an UnsupportedOperationException
        //list5.set(0, new Food());

    }
}
