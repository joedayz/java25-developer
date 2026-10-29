package com.joedayz.servicio;

import com.joedayz.metricas.Metricas;
import com.joedayz.util.Dinero;
import com.joedayz.util.interno.Contador;

public class Catalogo {

    // Dinero pertenece a com.joedayz.util: aparece en la API pública de este módulo,
    // por eso servicio declara "requires transitive com.joedayz.util".
    public Dinero precio(String producto) {
        int n = Contador.incrementar();                 // permitido por el export calificado
        if (hayMetricas()) {
            Metricas.registrar("consulta #" + n + ": " + producto);
        }
        return Dinero.soles(producto.length() * 10 + ".50");
    }

    // requires static: el módulo puede no estar presente en ejecución
    public static boolean hayMetricas() {
        return Catalogo.class.getModule().getLayer().findModule("com.joedayz.metricas").isPresent();
    }
}
