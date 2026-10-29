package com.joedayz.servicio.entidad;

// Paquete abierto (opens) pero no exportado: no se puede usar al compilar desde otro módulo,
// pero sí por reflexión profunda en ejecución (como haría JPA, Jackson, etc.).
public class Producto {
    private String nombre = "café";

    @Override
    public String toString() {
        return "Producto[" + nombre + "]";
    }
}
