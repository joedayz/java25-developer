package pe.joedayz.intefacesconocidas;


import java.util.Arrays;

public class ComparableMain {

    public static void main(String[] args) {

        Product[] products = {
                new Product("Laptop", 1200.0),
                new Product("Smartphone", 800.0),
                new Product("Tablet", 600.0)
        };

        //Arrays.sort(products);

        Arrays.sort(products, new ProductPriceSorter());

        System.out.println(Arrays.toString(products));
    }
}
