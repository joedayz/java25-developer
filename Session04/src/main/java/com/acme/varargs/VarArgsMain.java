package com.acme.varargs;

public class VarArgsMain {

    static void main(String... args) {
        double resultado = calcularPromedio();
        System.out.println("Promedio sin argumentos: " + resultado);

        resultado = calcularPromedio(10.0);
        System.out.println("Promedio con un argumento: " + resultado);

        resultado = calcularPromedio(10.0, 20.0, 30.0);
        System.out.println("Promedio con varios argumentos: " + resultado);

        resultado = calcularPromedio(new double[]{10.0, 20.0, 30.0});
        System.out.println("Promedio con un arreglo de argumentos: " + resultado);
    }

    static  double calcularPromedio(double... numeros) {
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        return numeros.length > 0 ? suma / numeros.length : 0;
    }
}
