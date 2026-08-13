package com.acme.enumeration;

import java.math.BigDecimal;

public class Product {

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
    }
}
