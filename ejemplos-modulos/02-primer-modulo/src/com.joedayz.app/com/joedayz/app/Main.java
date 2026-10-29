package com.joedayz.app;

import com.joedayz.saludos.Saludador;

public class Main {
    public static void main(String[] args) {
        IO.println(new Saludador().saludar("Java 25"));

        Module m = Main.class.getModule();
        IO.println("módulo:    " + m.getName());
        IO.println("requiere:  " + m.getDescriptor().requires());
        IO.println("lee saludos: " + m.canRead(Saludador.class.getModule()));
    }
}
