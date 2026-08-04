package org.example;

import java.time.LocalDate;
import java.util.Calendar;

public class CalendarSamples {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2026);
        cal.add(Calendar.MONTH, 1);


        LocalDate fecha = LocalDate.now();
        LocalDate siguiente = fecha.plusMonths(1);

        System.out.println(fecha);      // no cambia
        System.out.println(siguiente);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(2026, 7, 3); // pensabas que era 3 de julio, pero es 3 de agosto porque los meses empiezan en 0

        LocalDate.of(2026, 8, 3); // esto si es 3 de agosto

        cal.get(Calendar.DAY_OF_WEEK);

        fecha.getDayOfWeek();

        // Imaginate que tu diseñas el api de time

        Calendar cal3 = Calendar.getInstance();

        int year = cal3.get(Calendar.YEAR);
        int month = cal3.get(Calendar.MONTH);
        int day = cal3.get(Calendar.DAY_OF_MONTH);

        LocalDate fecha3 = LocalDate.now();

        fecha3.getYear();
        fecha3.getMonth();
        fecha3.getDayOfMonth();

        /*
        * Calendar hacía muchas cosas:

almacenar fecha
almacenar hora
zona horaria
calendario gregoriano
cálculos
conversiones
        *
        * */

        // LocalDate hace una sola cosa: almacenar fecha. Y lo hace muy bien.
        // LocalTime hace una sola cosa: almacenar hora. Y lo hace muy bien.
        // LocalDateTime hace una sola cosa: almacenar fecha y hora. Y lo hace muy bien.
        // ZonedDateTime hace una sola cosa: almacenar fecha y hora con zona horaria. Y lo hace muy bien.
        // Instant hace una sola cosa: almacenar un instante en el tiempo. Y lo hace muy bien.
        // Duration hace una sola cosa: almacenar una duración de tiempo. Y lo hace muy bien.
        // Period hace una sola cosa: almacenar un periodo de tiempo. Y lo hace muy bien.

        // Mutable
        Calendar calX = Calendar.getInstance();

        // Desde java 8 + deben usar las clases de java.time, que son inmutables y thread-safe
    }
}
