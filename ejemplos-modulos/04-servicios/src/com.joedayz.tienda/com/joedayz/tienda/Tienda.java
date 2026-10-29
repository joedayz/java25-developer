package com.joedayz.tienda;

import com.joedayz.pagos.api.MedioPago;

import java.math.BigDecimal;
import java.util.ServiceLoader;

public class Tienda {
    public static void main(String[] args) {
        ServiceLoader<MedioPago> cargador = ServiceLoader.load(MedioPago.class);

        // Recorrer todos los proveedores encontrados en el module path
        for (MedioPago medio : cargador) {
            IO.println(medio.nombre() + ": " + medio.pagar(new BigDecimal("59.90")));
        }

        // stream(): inspeccionar el tipo del proveedor SIN instanciarlo
        IO.println("tipos: " + cargador.stream().map(p -> p.type().getSimpleName()).toList());

        // findFirst(): el primero disponible (o Optional vacío)
        String primero = cargador.findFirst().map(MedioPago::nombre).orElse("ninguno");
        IO.println("primero: " + primero);
    }
}
