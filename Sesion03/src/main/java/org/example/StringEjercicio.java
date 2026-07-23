package org.example;

public class StringEjercicio {

    public static void main(String[] args) {
        String a = "    Hollywood    ";

        a = a.trim();

        System.out.println("a = " + a);

        String b = a.concat(" is a city in California");
        System.out.println("b = " + b);
        String c  = a + " is a city in California";
        System.out.println("c = " + c);
        String d = c.toLowerCase();
        System.out.println("d = " + d);
        String e = c.toUpperCase();
        System.out.println("e = " + e);
        boolean f = d.contains("W");
        System.out.println("f = " + f);



    }
}
