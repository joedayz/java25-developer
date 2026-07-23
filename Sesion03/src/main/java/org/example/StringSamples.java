package org.example;

public class StringSamples {

    public static void main(String[] args) {

        String a = "HelloWorld";
        String b = a.substring(0, 5); // b es "Hello"
        System.out.println("b = " + b);

        int c = a.indexOf('o'); // c es 4
        int d = a.indexOf('o', 5);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        int e = a.lastIndexOf('l'); // l es 8
        System.out.println("e = " + e);
        int f = a.indexOf('a'); // f es -1
        System.out.println("f = " + f);

        int h  = a.length();
        System.out.println("h = " + h);

        char i = a.charAt(0);
        System.out.println("i = " + i);

        char j = a.charAt(15);



    }
}
