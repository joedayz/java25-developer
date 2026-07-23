package org.example;

import java.math.BigDecimal;

public class BigDecimalSample {

    /*
        double utiliza el estandar IEEE 754 para representar números de punto flotante,
        lo que significa que no puede representar todos los números decimales con precisión.
         Esto puede llevar a errores de redondeo y pérdida de precisión en cálculos financieros o científicos.

           Usa double cuando:
           - Realizas cálculos científicos.
           - Trabajas con gráficos, videojuegos o simulaciones.
           - Procesas datos donde un pequeño error es aceptable
           - La velocidad es más importante que la precisión absoluta.

           Usa BigDecimal cuando:
           - Manejas dinero
           - Calculas impuestos
           - Procesas Facturación
           - Calculas intereses bancarios
           - Realizas operaciones contables
     */

    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        System.out.println(a + b);

        BigDecimal c = new BigDecimal("0.1");
        BigDecimal d = new BigDecimal("0.2");
        System.out.println(c.add(d));


        double saldo = 100.00;

        saldo -= 19.99;
        saldo -= 29.99;
        saldo -= 50.02;

        System.out.println(saldo);



        BigDecimal saldo2 = new BigDecimal("100.00");

        saldo2 = saldo2.subtract(new BigDecimal("19.99"));
        saldo2 = saldo2.subtract(new BigDecimal("29.99"));
        saldo2 = saldo2.subtract(new BigDecimal("50.02"));

        System.out.println(saldo2);

        BigDecimal price = new BigDecimal("12.99");
        BigDecimal taxRate = new BigDecimal("0.2");
        BigDecimal tax = price.multiply(taxRate);

        // Si el digito siguiente es 0-4 se queda igual
        // si es 5-9 se aumenta uno en el ultimo digito conservado
        price = price.add(tax).setScale(2, BigDecimal.ROUND_HALF_UP);

        System.out.println(price);


    }
}
