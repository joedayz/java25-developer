package com.acme;

public class Pato {

    String nombre;
    int edad;


    public Pato(){

        this.edad = 1;
        this.nombre = "Pato";
    }

    public Pato(int edad, String nombre){
        this.edad = edad;
        this(nombre);
    }

    public Pato(String nombre){
        this.nombre = nombre;
        this.edad = 1;

    }

    static void main() {
        Pato pato = new Pato(1, "Pato");

    }
}
