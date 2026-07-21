package org.example;

public class MathSamples {

    public static void main(String[] args) {
        double a = 1.99, b = 2.99, c =0;
        c = Math.cos(a);

        c = Math.sin(b);

        c = Math.pow(2, 5); // 2 elevado a 5
        System.out.println("pow = " + c);

        c = Math.sqrt(16); // raiz cuadrada de 16
        System.out.println("sqrt = " + c);

        c = Math.max(3, 5);
        System.out.println("max = " + c);

        c = Math.max(1l, 2l);
        System.out.println("max = " + c);

        c = Math.max(1f, 2f);
        System.out.println("max = " + c);

        c = Math.max(25.0, 13.0);
        System.out.println("max = " + c);

        c = Math.min(3, 5);
        System.out.println("min = " + c);

        c = Math.min(1l, 2l);
        System.out.println("min = " + c);

        c = Math.min(1f, 2f);
        System.out.println("min = " + c);

        c = Math.min(25.0, 13.0);
        System.out.println("min = " + c);

        c = Math.pow(2, 5); // 2 elevado a 5
        System.out.println("pow = " + c);


        c = Math.random(); // Te devuelve un numero entre 0 y casi 1.
        System.out.println("random = " + c);


        int o = 11; int p =3;
        int r0 = Math.round(o/p);  // si le paso entero devuelve int

        long r1  =Math.round(15f);  // si le paso float devuelve int

        long r2 = Math.round(15.5);  // si le paso double devuelve long
        // OJO con este caso que recibe double y devuelve long.
        // no devuelve entero.


        int x = 12, y = 5;
        long z = Math.round((double)x / y);
        System.out.println("round division = " + z);
    }


}
