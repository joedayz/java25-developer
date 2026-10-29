package com.joedayz.olvido;

import com.joedayz.pagos.api.MedioPago;

import java.util.ServiceLoader;

public class Olvido {
    public static void main(String[] args) {
        ServiceLoader.load(MedioPago.class).findFirst();   // compila, pero falla al ejecutar
    }
}
