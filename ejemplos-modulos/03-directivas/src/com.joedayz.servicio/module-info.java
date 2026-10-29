module com.joedayz.servicio {
    requires transitive com.joedayz.util;   // quien lea servicio también lee util
    requires static com.joedayz.metricas;   // obligatorio al compilar, opcional al ejecutar

    exports com.joedayz.servicio;           // acceso en compilación y ejecución (solo public)
    opens com.joedayz.servicio.entidad;     // solo reflexión en ejecución (incluye private)
    // com.joedayz.servicio.interno: ni exportado ni abierto
}
