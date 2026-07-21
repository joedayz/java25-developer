package org.example;

public class Nivel2TypeCasting {

    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;

        int c = a + b; // los tipos enteros pequenos a int, se convierten a int antes de la operacion

        char a1 = 'A';
        char b1 = 'B';

        int c1 = a1 + b1; // los tipos char se convierten a int antes de la operacion
    }
}
