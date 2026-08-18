package com.acme.bloquesdeinicializacion;

public class Dog {

    String name;
    static int contador = 0;

    {
        name = "Fido";
        System.out.println("Iniciando....");
    }

    static {
        System.out.println("En la clase contador inicia con = " + contador);
    }

    public Dog() {
        contador++;
        System.out.println("Name es " + name + " y contador es " + contador);
    }

    static void main() {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
    }

}
