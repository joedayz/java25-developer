package org.example;



public class Wrappers {

    public static void main(String[] args) {
        int a = 42;
        Integer b = Integer.valueOf(a); // Boxing
        int c = b.intValue(); // Unboxing

        b = a;
        c = b;

        String d = "12.25";
        Float e = Float.valueOf(d); // Boxing
        float f = e.floatValue(); // Unboxing
        float f2 = Float.parseFloat(d);

        String g = String.valueOf(a);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        Integer x = 100;  // Boxing
        int y = b; // Unboxing
    }
}
