package com.joedayz.metricas;

public class Metricas {
    public static void registrar(String evento) {
        IO.println("  [métricas] " + evento);
    }
}
