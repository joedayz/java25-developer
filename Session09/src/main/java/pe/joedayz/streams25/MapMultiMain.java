package pe.joedayz.streams25;

import java.util.stream.Stream;

/**
 * mapMulti (Java 16) emite cero o más elementos sin crear un Stream intermedio por cada entrada.
 * flatMap, que sí está en el PDF, hace lo mismo pero abre un Stream nuevo en cada elemento.
 */
public class MapMultiMain {

    static void main() {
        var conFlatMap = Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n * 10))
                .toList();

        var conMapMulti = Stream.of(1, 2, 3)
                .<Integer>mapMulti((n, downstream) -> {
                    downstream.accept(n);
                    downstream.accept(n * 10);
                })
                .toList();

        System.out.println("flatMap   = " + conFlatMap);
        System.out.println("mapMulti  = " + conMapMulti);

        var palabras = Stream.of("java streams", "java 25", "   ")
                .<String>mapMulti((linea, downstream) -> {
                    for (String palabra : linea.split(" ")) {
                        if (!palabra.isBlank()) {
                            downstream.accept(palabra);
                        }
                    }
                })
                .distinct()
                .toList();

        System.out.println("palabras  = " + palabras);
    }
}
