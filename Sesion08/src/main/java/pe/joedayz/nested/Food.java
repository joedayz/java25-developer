package pe.joedayz.nested;

import java.math.BigDecimal;

public class Food extends Product{
    public Food(String name) {
        super(name);
    }

    public Food(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
