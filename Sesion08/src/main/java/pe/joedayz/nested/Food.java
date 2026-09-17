package pe.joedayz.nested;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product{
    public Food(String name) {
        super(name);
    }

    public Food(String name, BigDecimal price) {
        super(name, price);
    }

    public Food(String name, BigDecimal price, LocalDate bestBefore) {
        super(name, price);
        setBestBefore(bestBefore);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
