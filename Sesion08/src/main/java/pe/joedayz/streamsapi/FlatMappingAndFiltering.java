package pe.joedayz.streamsapi;

import pe.joedayz.nested.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMappingAndFiltering {

    static void main() {

        Customer joe = new Customer("Joe");
        Customer bob = new Customer("Bob");

        Product tea = new Product("Tea", BigDecimal.valueOf(1.99));
        Product coffee = new Product("Coffee", BigDecimal.valueOf(1.99));
        Product cake = new Product("Cake", BigDecimal.valueOf(2.99));

        List<Order> orders = List.of(
                new Order(
                        joe,
                        LocalDate.of(2018, 11, 21),
                        List.of(tea, cake)
                ),
                new Order(
                        bob,
                        LocalDate.of(2018, 11, 21),
                        List.of(coffee)
                ),
                new Order(
                        joe,
                        LocalDate.of(2018, 11, 22),
                        List.of(coffee, cake)
                )
        );

        Map<Customer, Set<Product>> customerProducts =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.flatMapping(
                                        order -> order.getItems().stream(),
                                        Collectors.toSet()
                                )
                        ));

        System.out.println("Customer Products = " + customerProducts);




        Map<Customer, Set<Order>> customerOrdersOnDate =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.filtering(
                                        order -> order.getDate().equals(
                                                LocalDate.of(2018, 11, 22)
                                        ),
                                        Collectors.toSet()
                                )
                        ));

        System.out.println("Customer Orders on Date = " + customerOrdersOnDate);

    }
}
