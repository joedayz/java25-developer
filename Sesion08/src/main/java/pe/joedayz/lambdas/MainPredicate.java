package pe.joedayz.lambdas;

import pe.joedayz.nested.Drink;
import pe.joedayz.nested.Food;
import pe.joedayz.nested.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainPredicate {

    static void main() {

        List<Product> menu = new ArrayList<>();

        menu.add(new Food("Cake", BigDecimal.valueOf(1.99)));
        menu.add(new Food("Cookie", BigDecimal.valueOf(2.99)));
        menu.add(new Drink("Tea", BigDecimal.valueOf(1.99)));
        menu.add(new Drink("Coffee", BigDecimal.valueOf(1.99)));

        Predicate<Product> foodFilter = (p) -> p instanceof Food;

        Predicate<Product> priceFilter =
                (p) -> p.getPrice().compareTo(BigDecimal.valueOf(2)) < 0;

        menu.removeIf(foodFilter.negate().or(priceFilter));


        menu.removeIf(
                Predicate.isEqual(
                        new Food("Cake", BigDecimal.valueOf(1.99))
                )
        );

    }
}
