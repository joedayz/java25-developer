package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product extends Object {

    private int id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;

    public Product(String name){
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void order(Product p){
        BigDecimal price = p.getPrice();
        if(p instanceof Food f && f.getBestBefore().isBefore(LocalDate.now())){
            LocalDate day = f.getBestBefore();
        }else if(p instanceof Drink){
            //
        }
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
