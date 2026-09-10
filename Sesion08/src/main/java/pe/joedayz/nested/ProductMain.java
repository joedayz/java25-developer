package pe.joedayz.nested;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMain {

    static void main() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop"));
        products.add(new Product("Mouse"));

//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
}
