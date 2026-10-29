package com.joedayz.legado;

import com.joedayz.legado.interno.Redondeo;

public class Calculadora {
    public double promedio(double... valores) {
        double suma = 0;
        for (double v : valores) suma += v;
        return Redondeo.dosDecimales(suma / valores.length);
    }
}
