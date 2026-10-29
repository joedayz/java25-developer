package com.joedayz.saludos.interno;

// Clase pública, pero su paquete NO se exporta: fuera del módulo es invisible.
public class Formato {
    public static String titulo(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1) + "!";
    }
}
