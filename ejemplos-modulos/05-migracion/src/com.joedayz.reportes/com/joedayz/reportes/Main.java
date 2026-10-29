package com.joedayz.reportes;

import com.acme.fechas.Fechas;
import com.acme.texto.Texto;

public class Main {
    public static void main(String[] args) {
        IO.println(Texto.titulo("reporte de ventas") + " - " + Fechas.hoy());
        describir(Main.class.getModule());
        describir(Texto.class.getModule());
        describir(Fechas.class.getModule());
        describir(Texto.moduloDeAnsi());
    }

    static void describir(Module m) {
        String tipo = !m.isNamed() ? "SIN NOMBRE (classpath)"
                : m.getDescriptor().isAutomatic() ? "AUTOMÁTICO" : "con nombre";
        IO.println("  %-22s -> %s".formatted(m.isNamed() ? m.getName() : m.toString().replaceAll("@.*", ""), tipo));
    }
}
