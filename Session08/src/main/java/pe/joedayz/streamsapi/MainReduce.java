package pe.joedayz.streamsapi;

import pe.joedayz.nested.Product;

import java.util.List;
import java.util.Optional;

public class MainReduce {

    static void main() {
        List<Product> list = List.of(
                new Product("Laptop"),
                new Product("Mouse"),
                new Product("Teclado")
        );


        Optional<String> reduce = list.stream()
                .map(Product::getName)
                .reduce((s1, s2) -> s1 + ", " + s2);

        System.out.println("Primera forma de Reduce = " + reduce.orElse("No values"));


        String x2 = list.stream()
                .map(Product::getName)
                .reduce("", (s1, s2) -> s1 + " " + s2);

        System.out.println("Segunda forma de Reduce = " + x2);


        String x3 = list.stream()
                .parallel()
                .reduce(
                        "",
                        (result, product) -> result + " " + product.getName(),
                        (s1, s2) -> s1 + s2
                );
        System.out.println("Tercera forma de Reduce = " + x3);

    }
}
