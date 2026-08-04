package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantDurationPeriod {

    public static void main(String[] args) {
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
    }
}
