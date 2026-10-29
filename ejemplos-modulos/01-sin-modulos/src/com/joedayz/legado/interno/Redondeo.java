package com.joedayz.legado.interno;

// Pensada como clase "interna", pero en el classpath cualquiera puede usarla:
// public es el único nivel de visibilidad entre paquetes.
public class Redondeo {
    public static double dosDecimales(double x) {
        return Math.round(x * 100) / 100.0;
    }
}
