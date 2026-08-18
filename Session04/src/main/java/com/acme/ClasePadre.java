package com.acme;

public class ClasePadre extends Object {

    String name;

    public ClasePadre(){
        super();
    }

    public ClasePadre(String name){
        this.name = name;
    }

    public void saludar(){
        System.out.println("Hola, soy la clase padre");
    }
}
