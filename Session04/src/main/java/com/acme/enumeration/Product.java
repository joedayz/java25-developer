package com.acme.enumeration;

import java.math.BigDecimal;
import java.util.Objects;

public class Product extends Object {

    private String name;
    private BigDecimal price;
    private String caution;
    private Condition condition;

    public Product(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }

    public Product() {

    }

    public Product serve(){
        switch (condition){
            case HOT -> this.addCaution("Caution: This product is hot!");
            case WARM -> this.addCaution("Caution: This product is warm!");
            case COLD -> this.addCaution("Caution: This product is cold!");
        }
        return this;
    }

    private Product addCaution(String caution) {
        this.caution = caution;
        return this;
    }

    public void manageProduct(){
        Product p1 = new Product();
        orderProduct(p1);
        double v1 = p1.getPrice();
        changePrice(v1);
        System.out.println("Price after changePrice: " + v1);
    }

    private void changePrice(double v1) {
        v1 = 2.99;
    }

    private void orderProduct(Product p1) {
        p1.setPrice(BigDecimal.valueOf(1.99));
    }

    private void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }


    public double getPrice() {
        return price.doubleValue();
    }

    static void main() {
        Product p1 = new Product();
        p1.manageProduct();

        System.gc(); // sugerencia de cleanup de memoria
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(caution, product.caution) && condition == product.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, caution, condition);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", caution='" + caution + '\'' +
                ", condition=" + condition +
                '}';
    }


}
