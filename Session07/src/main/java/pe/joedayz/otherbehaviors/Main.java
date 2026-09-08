package pe.joedayz.otherbehaviors;

import pe.joedayz.collections.Drink;
import pe.joedayz.collections.Food;
import pe.joedayz.collections.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        List<Product> products = new ArrayList<>();
        products.add(new Food("Cake"));
        products.add(new Drink("Tea"));
        products.add(new Drink("Cookie"));

        Product[] array = new Product[2];
        array = products.toArray(array);

        System.out.println("Array length: " + array.length);

        products.removeIf(product -> product.getName().length()>3);

        System.out.println("Products after removeIf: " + products);
    }
}
