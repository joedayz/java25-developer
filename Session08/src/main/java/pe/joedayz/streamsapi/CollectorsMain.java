package pe.joedayz.streamsapi;

import pe.joedayz.nested.Drink;
import pe.joedayz.nested.Food;
import pe.joedayz.nested.Product;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsMain {
    static void main() {

        List<Product> list = List.of(
                new Food("Cake", BigDecimal.valueOf(5.0)),
                new Drink("Tea", BigDecimal.valueOf(10.00)),
                new Drink("Jugo", BigDecimal.valueOf(20.00))
        );


        DoubleSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingDouble(
                        product -> product.getPrice().doubleValue()
                ));

        System.out.println("Count = " + stats.getCount());
        System.out.println("Sum = " + stats.getSum());
        System.out.println("Average = " + stats.getAverage());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Max = " + stats.getMax());

        String names = list.stream()
                .collect(Collectors.mapping(
                        Product::getName,
                        Collectors.joining(", ")
                ));

        System.out.println("Names = " + names);

        List<Product> drinks = list.stream()
                .filter(product -> product instanceof Drink)
                .collect(Collectors.toList());

        System.out.println("Drinks = " + drinks);
    }
}
