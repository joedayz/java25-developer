package com.acme;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {

    private static int contador;

    //variables de instancia
    private int id;  // 0
    private String name = "Tea";  // null
    private BigDecimal price;  // null
    private LocalDate bestBefore = LocalDate.now().plusDays(3);




    //constructores
    public Product(){
        contador++;  // quiero guardar el numero de productos que generamos
    }


    //Dummy d = new Dummy();  NO SE PUEDE USAR CLASES SIN PAQUETE EN OTRAS CLASES.

    //methods
    public  BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public void play() {}


    public static int getContador() {
        return contador;
    }
}
