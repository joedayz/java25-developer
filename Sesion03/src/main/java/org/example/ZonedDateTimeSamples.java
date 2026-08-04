package org.example;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeSamples {

    public static void main(String[] args) {

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId la = ZoneId.of("America/Los_Angeles");

        // Fecha y hora sin zona
        LocalDateTime someTime =
                LocalDateTime.of(2019, Month.APRIL, 1, 7, 14);

        // Asignar la zona de Londres
        ZonedDateTime londonTime =
                ZonedDateTime.of(someTime, london);
        System.out.println("London Time: " + londonTime);

        // Convertir al mismo instante en Los Ángeles
        ZonedDateTime laTime =
                londonTime.withZoneSameInstant(la);
        System.out.println("Los Angeles Time: " + laTime);

        System.out.println();

        System.out.println("London Offset : " + londonTime.getOffset());
        System.out.println("LA Offset     : " + laTime.getOffset());

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.JANUARY, 1, 7, 14);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, london);
        ZonedDateTime laTime2 =
                zonedDateTime.withZoneSameInstant(la);
        System.out.println("London Time: " + zonedDateTime);
        System.out.println("Los Angeles Time 2: " + laTime2);



    }
}
