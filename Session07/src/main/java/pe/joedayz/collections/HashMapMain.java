package pe.joedayz.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    static void main() {

        Map<Product, Integer> items1 = new HashMap<>();

        Map<Product, Integer> items2 = new HashMap<>(20);

        Map<Product, Integer> items3 = new HashMap<>(items1);

        Map<Product, Integer> items4 = Map.of( new Food("Cake"), 1, new Drink("Tea"), 2);

        Map<Product, Integer> items5 = Map.ofEntries(
            Map.entry(new Food("Cake"), 1),
            Map.entry(new Drink("Tea"), 2)
        );


        //////

        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");

        Map<Product, Integer> items = new HashMap<>();


        items.put(p1, Integer.valueOf(2));
        items.put(p2, Integer.valueOf(2));

        Integer n1 = items.put(p1, Integer.valueOf(5));

        System.out.println("Items: " + items);

        items.remove(p2);

        boolean hasTea = items.containsKey(p2);
        boolean hasTwo = items.containsValue(n1);
        System.out.println("Items after removing Tea: " + items);

        System.out.println("Has Tea: " + hasTea);
        System.out.println("Has Two: " + hasTwo);


        System.out.println("Items size: " + items.size());
        System.out.println("Item p1 " + items.get(p1));




    }
}
