package com.acme;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Product {

    public static final int MAX_EXPIRY_PERIOD = 5;

    private static int contador;




    //variables de instancia
    private int id;  // 0
    private String name = "Tea";  // null
    private BigDecimal price;  // null
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal tax = BigDecimal.ZERO;


    public static void setDefaultExpiryPeriod(int days) {
        //Product.defaultExpiryPeriod = Period.ofDays(days);
        //MAX_EXPIRY_PERIOD = 7;
        //System.out.println(name);
        //ERROR: System.out.println(Product.name);
    }


    //constructores
    public Product(){
        contador++;  // quiero guardar el numero de productos que generamos
    }


    //Dummy d = new Dummy();  NO SE PUEDE USAR CLASES SIN PAQUETE EN OTRAS CLASES.

    public void setFiscalDetails(double... values) {
        switch (values.length) {
            case 3:
                this.tax = BigDecimal.valueOf(values[2]);
            case 2:
                this.discount = BigDecimal.valueOf(values[1]);
            case 1:
                this.price = BigDecimal.valueOf(values[0]);
        }
    }

    //methods
    public  BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPrice(BigDecimal price, BigDecimal discount){
        this.price = price;
        this.discount = discount;
    }

    public void setPrice(double discount, double price){
        this.price = BigDecimal.valueOf(price);
        this.discount = BigDecimal.valueOf(discount);
    }

    public void setPrice(double price){
        this.price = BigDecimal.valueOf(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        var foo = "abc";

        if(name==null){
            var dummy = "Desconocido";  // variable local
            return dummy;
        }

        //foo = 5;

        return name;
    }

    public String consume(){
        var feedback = "Good!";  //variable local

        //

        return feedback;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void play() {}


    public static int getContador() {
        return contador;
    }
}
