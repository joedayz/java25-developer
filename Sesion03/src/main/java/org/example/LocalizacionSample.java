package org.example;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizacionSample {

    public static void main(String[] args) {
        Locale locale = Locale.of("en", "GB");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        String pattern = bundle.getString("product");

        String name = "Laptop";
        BigDecimal price = new BigDecimal("1000");
        int quantity = 2;
        LocalDate bestBefore = LocalDate.of(2024, 12, 31);


        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(locale);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", locale);

        String fPrice = currencyFormatter.format(price);
        String fQuantity = numberFormatter.format(quantity);
        String fBestBefore = bestBefore.format(dateFormatter);


        String resultado = MessageFormat.format(pattern, name, fPrice, fQuantity, fBestBefore);

        System.out.println(resultado);
    }
}
