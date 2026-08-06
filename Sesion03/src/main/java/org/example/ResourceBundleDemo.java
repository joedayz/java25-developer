package org.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        Locale locale = Locale.of("en", "GB");

        ResourceBundle bundle =
                ResourceBundle.getBundle("messages", locale);


        String helloPattern = bundle.getString("hello");
        String productPattern = bundle.getString("product");

        System.out.println(MessageFormat.format(helloPattern, "Joe"));

        System.out.println(
                MessageFormat.format(
                        productPattern,
                        "Coffee",
                        "£4.50",
                        10,
                        "31 Dec 2026"
                )
        );

        System.out.println();

        locale = Locale.of("ru");

        bundle = ResourceBundle.getBundle("messages", locale);

        helloPattern = bundle.getString("hello");
        productPattern = bundle.getString("product");

        System.out.println(MessageFormat.format(helloPattern, "Masha"));


        System.out.println(
                MessageFormat.format(
                        productPattern,
                        "Кофе",
                        "350₽",
                        5,
                        "31.12.2026"
                )
        );

        System.out.println();

        locale = Locale.of("es", "PE");

        bundle = ResourceBundle.getBundle("messages", locale);

        helloPattern = bundle.getString("hello");
        System.out.println(MessageFormat.format(helloPattern, "José"));

        System.out.println(bundle.getString("other"));
    }
}
