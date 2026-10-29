package com.joedayz.util.interno;

public class Contador {
    private static int consultas;

    public static int incrementar() {
        return ++consultas;
    }
}
