package com.acme.enumeration;

public class Product {

    private String name;
    private String caution;
    private Condition condition;

    public Product(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
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

}
