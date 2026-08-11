package com.acme;

public class Pato {

    String nombre;
    int edad;

    public Pato(){
        this.edad = 0;
        this.nombre = "Pato";
    }

    public Pato(int edad, String nombre){
        this.edad = edad;
        this.nombre = nombre;
    }

    public Pato(String nombre){
        this.nombre = nombre;
    }
}
