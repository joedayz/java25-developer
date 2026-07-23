package org.example;

public class StringBuilderSample {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(); // 16 de capacidad inicial
        System.out.println("Capacidad inicial: " + sb.capacity()); // 0 - 15

        sb.append("tea");
        sb.append('s');
        sb.insert(3, 'm');
        sb.delete(2, 4);
        sb.reverse();

        int length = sb.length();
        System.out.println("Length = " + length);

        System.out.println("Sb = " + sb);

        sb.insert(4, 's');


    }
}
