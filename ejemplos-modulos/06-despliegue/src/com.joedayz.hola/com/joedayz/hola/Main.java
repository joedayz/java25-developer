package com.joedayz.hola;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOG.info("arrancando");
        IO.println("Hola desde una imagen a medida");
        IO.println("java.home = " + System.getProperty("java.home").replaceAll(".*/(target/)", "$1"));
        IO.println("módulos   = " + ModuleLayer.boot().modules().stream().map(Module::getName).sorted().toList());
    }
}
