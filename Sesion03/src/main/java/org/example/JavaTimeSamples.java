package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class JavaTimeSamples {

    public static void main(String[] args) {
        // Fecha actual
        LocalDate today = LocalDate.now(); // yyyy-MM-dd

        // Hora actual
        LocalTime thisTime = LocalTime.now(); // HH:mm:ss.nnnnnnnnn

        // Fecha y hora actual
        LocalDateTime currentDateTime = LocalDateTime.now(); // yyyy-MM-ddTHH:mm:ss.nnnnnnnnn

        // Crear una fecha específica
        LocalDate someDay = LocalDate.of(2019, Month.APRIL, 1);

        // Crear una hora específica
        LocalTime someTime = LocalTime.of(10, 6);

        // Crear una fecha y hora específica
        LocalDateTime otherDateTime =
                LocalDateTime.of(2019, Month.MARCH, 31, 23, 59);

        // Combinar una fecha y una hora
        LocalDateTime someDateTime = someDay.atTime(someTime);

        // Obtener solo la fecha de un LocalDateTime
        LocalDate whatWasTheDate = someDateTime.toLocalDate();

        // Imprimir resultados
        System.out.println("Today: " + today);
        System.out.println("This Time: " + thisTime);
        System.out.println("Current DateTime: " + currentDateTime);
        System.out.println("Some Day: " + someDay);
        System.out.println("Some Time: " + someTime);
        System.out.println("Other DateTime: " + otherDateTime);
        System.out.println("Some DateTime: " + someDateTime);
        System.out.println("What Was The Date: " + whatWasTheDate);
    }
}
