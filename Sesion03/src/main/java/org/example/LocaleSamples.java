package org.example;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocaleSamples {

    public static void main(String[] args) throws ParseException {
        // Idioma + País
        Locale uk = Locale.of("en", "GB");      // English - Great Britain
        Locale us = Locale.of("en", "US");      // English - United States
        Locale fr = Locale.of("fr", "FR");      // French - France
        Locale ca = Locale.of("fr", "CA");      // French - Canada
        Locale caribbean = Locale.of("fr", "029"); // French - Caribbean

        // Idioma + País + Variante
        Locale thaiVariant = Locale.of("th", "TH", "TH");
        // Thai - Thailand (Thai digits variant)

        // Solo idioma
        Locale french = Locale.of("fr");

        // Locale por defecto del sistema
        Locale current = Locale.getDefault();

        // Locale usando un Language Tag BCP 47
        Locale thaiBuddhist = Locale.forLanguageTag(
                "th-TH-u-ca-buddhist-nu-thai"
        );

        // Mostrar resultados
        System.out.println("UK: " + uk);
        System.out.println("US: " + us);
        System.out.println("France: " + fr);
        System.out.println("Canada: " + ca);
        System.out.println("Caribbean: " + caribbean);
        System.out.println("Thai Variant: " + thaiVariant);
        System.out.println("French: " + french);
        System.out.println("Current: " + current);
        System.out.println("Thai Buddhist: " + thaiBuddhist);

        // aplicandolo a numeros, moneda, porcentajes

        BigDecimal price = BigDecimal.valueOf(2.99);
        Double tax = 0.2;
        int quantity = 12345;


        Locale locale = Locale.of("en", "GB");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        System.out.println("Price: " + currencyFormat.format(price));
        System.out.println("Tax: " + percentageFormat.format(tax));
        System.out.println("Quantity: " + numberFormat.format(quantity));


        // Parsing
        BigDecimal p = BigDecimal.valueOf(
                currencyFormat.parse("£1.7").doubleValue());

        Double t = percentageFormat.parse("12%").doubleValue();

        int q = numberFormat.parse("54,321").intValue();

        System.out.println(p);   // 1.7
        System.out.println(t);   // 0.12
        System.out.println(q);   // 54321




    }
}
