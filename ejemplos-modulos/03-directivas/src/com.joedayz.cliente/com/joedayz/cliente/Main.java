package com.joedayz.cliente;

import com.joedayz.servicio.Catalogo;
import com.joedayz.util.Dinero;               // sin "requires com.joedayz.util" en module-info

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        IO.println("1. requires transitive");
        Dinero d = new Catalogo().precio("laptop");
        IO.println("   precio = " + d);

        IO.println("2. requires static: ¿métricas disponibles? " + Catalogo.hayMetricas());

        IO.println("3. opens: reflexión profunda sobre un paquete abierto");
        Class<?> c = Class.forName("com.joedayz.servicio.entidad.Producto");
        Object p = c.getDeclaredConstructor().newInstance();
        Field f = c.getDeclaredField("nombre");
        f.setAccessible(true);
        f.set(p, "té");
        IO.println("   " + p);

        IO.println("4. paquete ni exportado ni abierto");
        Class<?> s = Class.forName("com.joedayz.servicio.interno.Secreto");   // cargar la clase sí se puede
        try {
            s.getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException e) {
            IO.println("   " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        try {
            s.getDeclaredField("clave").setAccessible(true);
        } catch (RuntimeException e) {
            IO.println("   " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
