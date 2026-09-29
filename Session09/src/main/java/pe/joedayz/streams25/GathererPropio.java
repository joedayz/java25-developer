package pe.joedayz.streams25;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

/**
 * Gatherer propio: integrator, estado, finisher y andThen.
 * of() puede participar en un stream paralelo porque no guarda estado.
 * ofSequential() se usa cuando el resultado depende del orden de llegada.
 */
public class GathererPropio {

    static void main() {
        System.out.println("--- integrator sin estado: equivalente a map ---");
        System.out.println(Stream.of("java", "streams", "25")
                .gather(prefijar(">> "))
                .toList());

        System.out.println("--- estado + corte anticipado: equivalente a limit ---");
        System.out.println(Stream.of("a", "b", "c", "d", "e")
                .gather(limitar(3))
                .toList());

        System.out.println("--- finisher: emite la ventana incompleta del final ---");
        System.out.println(Stream.of("a", "b", "c", "d", "e")
                .gather(ventanas(2))
                .toList());

        System.out.println("--- andThen compone gatherers, igual que encadenar gather() ---");
        var compuesto = prefijar(">> ").andThen(Gatherers.windowFixed(2));
        System.out.println(Stream.of("java", "streams", "gatherers", "25")
                .gather(compuesto)
                .toList());

        System.out.println("--- tomarMientras: se detiene en el primer elemento que no cumple ---");
        System.out.println(Stream.of(2, 4, 6, 7, 8)
                .gather(tomarMientras(n -> n % 2 == 0))
                .toList());
    }

    static Gatherer<String, Void, String> prefijar(String prefijo) {
        return Gatherer.of(Gatherer.Integrator.ofGreedy(
                (estado, elemento, downstream) -> downstream.push(prefijo + elemento)));
    }

    static <T> Gatherer<T, Contador, T> limitar(int maximo) {
        return Gatherer.ofSequential(
                Contador::new,
                (estado, elemento, downstream) -> {
                    if (estado.vistos >= maximo) {
                        return false;
                    }
                    estado.vistos++;
                    return downstream.push(elemento);
                });
    }

    static <T> Gatherer<T, List<T>, List<T>> ventanas(int tamano) {
        return Gatherer.ofSequential(
                ArrayList::new,
                (ventana, elemento, downstream) -> {
                    ventana.add(elemento);
                    if (ventana.size() == tamano) {
                        var copia = List.copyOf(ventana);
                        ventana.clear();
                        return downstream.push(copia);
                    }
                    return true;
                },
                (ventana, downstream) -> {
                    if (!ventana.isEmpty()) {
                        downstream.push(List.copyOf(ventana));
                    }
                });
    }

    static <T> Gatherer<T, Bandera, T> tomarMientras(Predicate<T> condicion) {
        return Gatherer.ofSequential(
                Bandera::activa,
                (estado, elemento, downstream) -> {
                    if (!estado.sigue || !condicion.test(elemento)) {
                        estado.sigue = false;
                        return false;
                    }
                    return downstream.push(elemento);
                });
    }

    static final class Contador {
        int vistos;
    }

    static final class Bandera {
        boolean sigue = true;

        static Bandera activa() {
            return new Bandera();
        }
    }
}
