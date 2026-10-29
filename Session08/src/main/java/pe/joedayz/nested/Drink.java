package pe.joedayz.nested;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Drink extends Product{
    public Drink(String name) {
        super(name);
    }

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    public Drink(String name, BigDecimal price, LocalDate bestBefore) {
        super(name, price);
        setBestBefore(bestBefore);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
