package com.joedayz.legado;

import com.joedayz.legado.interno.Redondeo;

public class Principal {
    public static void main(String[] args) {
        var calc = new Calculadora();
        IO.println("promedio:       " + calc.promedio(14, 17, 19));
        IO.println("uso de interno: " + Redondeo.dosDecimales(3.14159));   // nada lo impide

        Module m = Principal.class.getModule();
        IO.println("módulo:         " + (m.isNamed() ? m.getName() : "sin nombre (unnamed module)"));
        IO.println("String está en: " + String.class.getModule().getName());
    }
}
