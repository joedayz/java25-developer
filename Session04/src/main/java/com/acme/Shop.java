package com.acme;

public class Shop  extends Object {


    private static final String  NAME = "My Shop";


    static{
        System.out.println("Cargando Shop");
    }

    {
        System.out.println("Bloque de inicialización de instancia de Shop");
    }


    public Shop() {
        super();
        System.out.println("Constructor de Shop");
    }

    static void main() {



        //teoria de instancia
        // primero ejecuta los bloques de inicializacion
        // segundo ejecuta los constructores



    }

    // 1. Las clases que se inicializan son
    // Object
    // Shop
    // Product
    // Food
}
