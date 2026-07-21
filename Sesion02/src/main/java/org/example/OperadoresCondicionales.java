package org.example;

public class OperadoresCondicionales {

    public static void main(String[] args) {
        int a =3  , b =2;
        boolean c = false;

        c = (a == b);
        System.out.println("c = " + c);  // c = false

        c = !(a == b);
        System.out.println("c = " + c);  // c = true

        c = (a >b && b == 2);
        System.out.println("c = " + c);  // c = true

        c  = (a <b && b == 2);
        System.out.println("c = " + c);  // c = false

        //c = (a <b ^^ b == 2);
        //System.out.println("c = " + c);  // c = true

        c = (a <b | b == 2);


        c = (a <b & b == 2);

        c = (a <b ^ b == 2);   //  T ^  F  ==>  T , F ^ T ==> T, T ^ T ==> F, F ^ F ==> F


        int d = (a >= b) ? a : b;
    }
}
