package pe.joedayz.streams25;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collectors.teeing (Java 12) aplica dos collectors en una sola pasada
 * y combina sus resultados. El PDF recorre el stream una vez por cada agregado.
 */
public class TeeingMain {

    record Venta(String producto, double monto) {}

    record Resumen(long operaciones, double total, String ticketPromedio) {}

    static void main() {
        Resumen resumen = Stream.of(
                        new Venta("Te", 1.99),
                        new Venta("Torta", 2.99),
                        new Venta("Cafe", 1.50))
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.summingDouble(Venta::monto),
                        (operaciones, total) -> new Resumen(
                                operaciones,
                                total,
                                "%.2f".formatted(total / operaciones))));

        System.out.println(resumen);
    }
}
