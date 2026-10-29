package pe.joedayz.streamsapi;

import pe.joedayz.nested.Drink;
import pe.joedayz.nested.Food;
import pe.joedayz.nested.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndPartitioning {

    static void main() {

        List<Product> list = List.of(
                new Food("Cake", BigDecimal.valueOf(5.0), LocalDate.now()),
                new Drink("Tea", BigDecimal.valueOf(10.00), LocalDate.now().plusDays(5)),
                new Drink("Jugo", BigDecimal.valueOf(20.00), LocalDate.now().minusDays(3))
        );

        Map<Boolean, List<Product>> productTypes = list.stream()
                .collect(Collectors.partitioningBy(
                        product -> product instanceof Drink
                ));

        System.out.println("Product Types = " + productTypes);


        Map<LocalDate, List<Product>> productGroups = list.stream()
                .collect(Collectors.groupingBy(
                        Product::getBestBefore
                ));

        System.out.println("Product Groups = " + productGroups);
    }
}
