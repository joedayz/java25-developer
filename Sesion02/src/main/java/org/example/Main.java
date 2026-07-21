package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int i = 2_147_483_647;
        double salary = 1_000_000.00;

        float pi = 3.14F;  // no hay problema si es f o F


       // float f = 0.1;  NO COMPILA POR DESBORDAMIENTO

        double d = 12341234.231f;   // no hay problema si es float


        int j = 2_147_483_647;

        long k = 5_147_483_648L; //l  o L

        short sh = 32_767;

        byte b = 127;

        char ch = '\101'; // ASCII
        char ch2 = '\u0041'; // Unicode
        char ch3 = 'Z';
        char ch4 = 65_535; // ASCII
        System.out.println("ch = " + ch);
        System.out.println("ch2 = " + ch2);
        System.out.println("ch3 = " + ch3);
        System.out.println("ch4 = " + ch4);

        //Type casting
        byte b1 = 127;
        byte b2 = (byte) (b1 + 1); // overflow

        System.out.println("b2 = " + b2); // -128

        short sh2 = (short) (sh + 1);
        System.out.println(sh2 );

        char mychar = 65535;
        System.out.println("mychar = " + mychar);
        char mychar2 = (char) (mychar + 1);
        System.out.println("mychar2 = " + mychar2);

    }
}
