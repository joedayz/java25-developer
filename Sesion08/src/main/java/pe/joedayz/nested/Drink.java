package pe.joedayz.nested;

import java.math.BigDecimal;

public class Drink extends Product{
    public Drink(String name) {
        super(name);
    }

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }
}
