package pe.joedayz.streams25;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fuentes y terminales que el PDF de Streams no muestra y que ya son el estilo de Java 25.
 * ofNullable e iterate acotado llegan en Java 9. Stream.toList() llega en Java 16.
 */
public class FuentesModernas {

    static void main() {
        System.out.println("--- Stream.of(null) vs ofNullable ---");
        String valor = null;

        try {
            System.out.println(Stream.of(valor).map(String::toUpperCase).toList());
        } catch (NullPointerException e) {
            System.out.println("Stream.of(null).map(toUpperCase) lanza NullPointerException");
        }
        System.out.println("ofNullable(null) = " + Stream.ofNullable(valor).map(String::toUpperCase).toList());
        System.out.println("ofNullable(\"java\") = " + Stream.ofNullable("java").map(String::toUpperCase).toList());


        System.out.println("--- iterate acotado (Java 9) ---");
        // El iterate de un solo argumento es infinito: hace falta limit.
        System.out.println("infinito + limit = " + Stream.iterate(1, n -> n + 1).limit(5).toList());
        // El de tres argumentos se detiene cuando el predicado deja de cumplirse.
        System.out.println("acotado          = " + Stream.iterate(1, n -> n <= 5, n -> n + 1).toList());

        System.out.println("--- Stream.toList() es inmodificable ---");
        List<String> conCollector = Stream.of("a", "b").collect(Collectors.toList());
        conCollector.add("c");
        System.out.println("Collectors.toList() admite add en la implementación actual: " + conCollector);

        List<String> conToList = Stream.of("a", "b").toList();
        try {
            conToList.add("c");
        } catch (UnsupportedOperationException e) {
            System.out.println("Stream.toList() rechaza add: " + conToList);
        }

        List<String> inmodificable = Stream.of("a", "b").collect(Collectors.toUnmodifiableList());
        try {
            inmodificable.add("c");
        } catch (UnsupportedOperationException e) {
            System.out.println("toUnmodifiableList() rechaza add: " + inmodificable);
        }
    }
}
