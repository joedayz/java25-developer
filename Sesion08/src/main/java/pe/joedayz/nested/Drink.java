package pe.joedayz.nested;

import java.math.BigDecimal;

public class Drink extends Product{
    public Drink(String name) {
        super(name);
    }

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
