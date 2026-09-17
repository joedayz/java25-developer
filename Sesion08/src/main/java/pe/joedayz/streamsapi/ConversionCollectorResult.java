package pe.joedayz.streamsapi;

import pe.joedayz.nested.Drink;
import pe.joedayz.nested.Food;
import pe.joedayz.nested.Product;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ConversionCollectorResult {

    static void main() {

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);

        List<Product> list = List.of(
                new Food("Cake", BigDecimal.valueOf(5.0)),
                new Drink("Tea", BigDecimal.valueOf(10.00)),
                new Drink("Jugo", BigDecimal.valueOf(20.00))
        );


        String averagePrice = list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.summarizingDouble(product -> product.getPrice().doubleValue()),
                        stats -> format.format(stats.getSum())
                ));

        System.out.println("Average Price in UK = " + averagePrice);
    }
}
