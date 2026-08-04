package org.example;

import java.net.http.HttpClient;
import java.time.*;

public class InstantDurationPeriod {

    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();

        //ZonedDateTime peru =
         //       now.atZone(ZoneId.of("America/Lima"));

        System.out.println("Current Instant: " + now); //se muestra en UTC no en la zona horaria del sistema
        //UTC-05:00 Perú

        //Salida UTC
        //00:29
        //-5
        //19:29
        LocalDateTime local = LocalDateTime.now();
        System.out.println("Current LocalDateTime: " + local); //se muestra en la zona horaria del sistema
        ZonedDateTime zoned = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + zoned); //se muestra en la zona horaria del sistema


        // Duration
        Instant start = Instant.now();

        Thread.sleep(3000); // Simulate some processing time (3 seconds)

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Duration in seconds: " + duration.getSeconds());
        System.out.println("Duration in milliseconds: " + duration.toMillis());

        Duration timeout = Duration.ofSeconds(30);
        HttpClient.newBuilder()
                .connectTimeout(timeout) // aqui el espera 30 segundos para conectarse al servidor
                .build();

        // haz algo cada hora
        Duration intervalo = Duration.ofHours(1);

        // sumar 30 segundos a un instante
        Instant future = now.plus(Duration.ofSeconds(30)); // sumandole 30 segundos a un instante
        System.out.println("Future Instant: " + future);

        //Period

        LocalDate nacimiento = LocalDate.of(1974, 11, 06);
        LocalDate hoy = LocalDate.now();

        Period edad = Period.between(nacimiento, hoy);

        System.out.printf(
                "%d años, %d meses, %d días%n",
                edad.getYears(),
                edad.getMonths(),
                edad.getDays());

        //ejemplo de contrato
        LocalDate inicio = LocalDate.of(2026, 8, 3);

        LocalDate vencimiento =
                inicio.plus(Period.ofYears(1));

        System.out.println(vencimiento);

    }
}
