package com.acme;

public class Pato {

    private String nombre;
    private int edad;


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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
