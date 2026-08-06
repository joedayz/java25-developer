package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterSamples {

    public static void main(String[] args) {
        // Create a date
        LocalDate date = LocalDate.of(2019, Month.APRIL, 1);

        // Locale
        Locale locale = Locale.of("en", "GB");

        // Custom formatter
        DateTimeFormatter dateTimeFormat =
                DateTimeFormatter.ofPattern("EEEE dd MMM yyyy", locale);

        // Format
        String result = date.format(dateTimeFormat);

        // Format the date
        String formattedDate = date.format(dateTimeFormat);
        System.out.println("Formatted Date: " + formattedDate);

        // Parse
        date = LocalDate.parse("Tuesday 31 Mar 2020", dateTimeFormat);
        System.out.println("Parsed Date: " + date);


        // Change locale
        locale = Locale.of("ru");

        // Localized formatter
        dateTimeFormat = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .localizedBy(locale);

        // Format again
        result = date.format(dateTimeFormat);
        // result = dateTimeFormat.format(date);

        System.out.println(result); // 31 мар. 2020 г.






    }

}