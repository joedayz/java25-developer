package org.example;

public class Operadores {

    public static void main(String[] args) {
        //post increment y post decrement
        int a = 5;
        System.out.println("a = " + a);  // a = 5
        System.out.println("a++ = " + a++);
        System.out.println("a = " + a);  // a = 6

        int b = 5;
        System.out.println("b = " + b);  // b = 5
        System.out.println("b-- = " + b--);
        System.out.println("b = " + b);  // b = 4

        // pre increment y pre decrement, y unary

        System.out.println("++a = " + ++a);  // a = 7
        System.out.println("--b = " + --b);  // b = 3

        System.out.println(+5);
        System.out.println(-3);


        // ~ operador bitwise NOT
        int c = 5;  //  00000101
        System.out.println("c = " + c);  // c = 5
        System.out.println("~c = " + ~c);  // ~c = -6        11111010

        //Tip    (5 + 1) * -1 = -6
        int d = 11;
        System.out.println("d = " + d);  // d = 11
        System.out.println("~d = " + ~d);  // ~d = -12        11110011

        int e = -5;
        System.out.println("e = " + e);  // e = -5
        System.out.println("~e = " + ~e);  // ~e = 4        00000100

        // ! operador lógico NOT
        boolean f = true;
        System.out.println("f = " + f);  // f = true
        System.out.println("!f = " + !f);  // !f = false


        // post increment y pre increment con operadores aritméticos
        int g = 5;
        int h = g++ + 2;  // h = 5 + 2
        System.out.println("g = " + g);  // g = 6
        System.out.println("h = " + h);  // h = 7

        int i = 5;
        int j = ++i + 2;  // j = 6 + 2
        System.out.println("i = " + i);  // i = 6
        System.out.println("j = " + j);  // j = 8

        // combinando post y pre increment
        int k = 5;
        int l = k++ + ++k;  // l = 5 + 7
        System.out.println("k = " + k);  // k = 7
        System.out.println("l = " + l);  // l = 12

        int m = 5;
        int n = 7;
        int o = m++ + ++n;  // o = 5 + 8
        System.out.println("m = " + m);  // m = 6
        System.out.println("n = " + n);  // n = 8
        System.out.println("o = " + o);  // o = 13
    }
}
