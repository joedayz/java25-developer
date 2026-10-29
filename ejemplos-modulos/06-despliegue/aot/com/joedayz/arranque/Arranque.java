package com.joedayz.arranque;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Aplicación que carga muchas clases del JDK al arrancar (streams, lambdas, regex, java.time, HTTP).
// Sirve para medir el efecto del caché AOT (JEP 483, 514, 515).
public class Arranque {
    public static void main(String[] args) {
        Map<Boolean, Long> pares = IntStream.rangeClosed(1, 10_000).boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.counting()));
        var patron = Pattern.compile("(\\w+)@(\\w+)\\.pe");
        var correos = java.util.List.of("ana@joedayz.pe", "luis@acme.pe", "eva@joedayz.pe").stream()
                .map(patron::matcher).filter(java.util.regex.Matcher::matches)
                .collect(Collectors.groupingBy(m -> m.group(2), Collectors.mapping(m -> m.group(1), Collectors.toList())));
        var fecha = LocalDate.of(2026, 10, 19).format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM", java.util.Locale.of("es")));
        var cliente = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();
        var peticion = HttpRequest.newBuilder(URI.create("https://joedayz.pe")).GET().build();
        var maximo = correos.keySet().stream().max(Comparator.naturalOrder()).orElseThrow();
        IO.println(pares + " " + correos + " " + fecha + " " + peticion.method() + " " + maximo
                + " " + cliente.version());
    }
}
