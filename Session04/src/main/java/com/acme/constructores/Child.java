package com.acme.constructores;

public class Child extends Parent{
    final int y;
    int x = 7;

    { // Bloque de inicializacion de instancia se ejecuta antes del constructor
        System.out.println("init x = " + x);
    }

    public Child(int v) { // Constructor
        System.out.println("Prologo");
        this.y = v;
        super(); // Llamada al constructor de la clase padre
        System.out.println("Epilogo " + y);
    }

    static void main() {
        Child child = new Child(3);

    }
}
