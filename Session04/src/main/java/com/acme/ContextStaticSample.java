package com.acme;

import java.time.Period;

public class ContextStaticSample {

    public final static void main(String[] args){
        ProductStatic.setExpiry(5);

        //Esto no es común
        var p1 = new ProductStatic();
        p1.setExpiry(2);

        System.out.println("Expiry is " + ProductStatic.getExpiry());

    }

}

class ProductStatic{

    String name;
    private static Period expiry;
    public static final int MAX_EXPIRY_DAYS = 5;
    public static final double PI = 3.14159;

    static{
        expiry = Period.ofDays(3);
        //name = "abc"; //NO COMPILA no puedo usar variable de instancia en un bloque estático
        //foo(); NO COMPILA no puedo usar métodos de instancia en un bloque estático
        System.out.println(ProductStatic.MAX_EXPIRY_DAYS);
    }

    public static void setExpiry(int days) {
        expiry = Period.ofDays(days);
    }

    public static Period getExpiry(){
        return expiry;
    }

    public void foo(){
        expiry = Period.ofDays(3);
        System.out.println(name);
    }
}
