package com.acme.fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// JAR antiguo sin module-info, pero su MANIFEST.MF declara Automatic-Module-Name.
public class Fechas {
    public static String hoy() {
        return LocalDate.of(2026, 10, 19).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
