package pe.joedayz.nested;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {

    String name;
    BigDecimal price;
    private LocalDate bestBefore;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public LocalDate getBestBefore() {
        return this.bestBefore;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", bestBefore=" + bestBefore +
                '}';
    }
}
