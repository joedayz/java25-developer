package com.acme.sobrecarga;

import com.acme.enumeration.Product;

public class Impresora {

    void imprimir(int numero) {
        System.out.println("Imprimiendo número entero: " + numero);
    }

//    void imprimir(int abc) {
//        System.out.println("Imprimiendo número entero: " + numero);
//    }

    String imprimir(String texto) {
        System.out.println("Imprimiendo texto: " + texto);
        return texto;
    }

    static void main() {
        new Product();
        return ;
    }

}
