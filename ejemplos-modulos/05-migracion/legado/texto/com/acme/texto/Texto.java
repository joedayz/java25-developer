package com.acme.texto;

import com.acme.colores.Ansi;

// JAR antiguo sin module-info. Depende de otro JAR que está en el classpath.
public class Texto {
    public static String titulo(String s) {
        return Ansi.negrita(s.toUpperCase());
    }

    public static Module moduloDeAnsi() {
        return Ansi.class.getModule();
    }
}
