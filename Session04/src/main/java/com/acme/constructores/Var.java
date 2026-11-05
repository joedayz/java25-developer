package com.acme.constructores;

public class Var  extends Object{

    String name;
    boolean isActive;
    double price;

    public Var(){
    }

    public Var(String name){
        this.name = name;
        this.isActive= false;
    }

    public Var(String name, boolean isActive, double price){
        if(price<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this(name);
        this.isActive= isActive;
        this.price = price;
    }

}


class Prueba{
    static void main() {
        Var var = new Var("abc");

        Var var2 = new Var("abc", true, 0.0);

        Var var3 = new Var();
    }
}
