package com.joedayz.saludos;

import com.joedayz.saludos.interno.Formato;

public class Saludador {
    public String saludar(String nombre) {
        return Formato.titulo("hola, " + nombre);
    }
}
