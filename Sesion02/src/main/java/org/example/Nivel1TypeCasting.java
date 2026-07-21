package org.example;

public class Nivel1TypeCasting {

    public static void main(String[] args) {

        byte b = 10;
        short s = b;  // byte se convierte en short
        int i = s; // short se convierte en int
        long l = i; // int se convierte en long
        float f = l; // long se convierte en float
        double d = f; // float se convierte en double

        int x = b; // byte se convierte en int

        final int z = 100;
        byte b2 =  z; // Aqui el compilador se da cuenta que z nunca va a cambiar de valor 100


    }
}
