package pe.joedayz.iterandocolecciones;

import pe.joedayz.collections.Food;
import pe.joedayz.collections.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    static void main() {


        List<Product> products = new ArrayList<>();
        products.add(new Food("Cake"));
        products.add(new Food("Pizza"));
        products.add(new Food("Burger"));

//        for (Product product : products) {
//            System.out.println(product.getName());
//            products.remove(product); // This will throw ConcurrentModificationException
//        }

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product.getName());
            iterator.remove();
        }

        System.out.println("Products size after iteration: " + products.size()); // Should be 0
    }
}
