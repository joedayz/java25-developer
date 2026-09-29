package pe.joedayz.streams25;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

/**
 * Stream.gather y java.util.stream.Gatherers.
 * Preview en Java 22 y 23, final en Java 24 (JEP 485) y parte del LTS 25.
 * Un gatherer es una operación intermedia personalizable: lo que collect es al final del pipeline.
 */
public class GatherersIntegrados {

    static void main() {
        System.out.println("--- windowFixed: bloques que no se solapan ---");
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(Gatherers.windowFixed(3))
                .toList());

        System.out.println("--- windowSliding: ventanas que se desplazan de a uno ---");
        var promedios = Stream.of(10.0, 20.0, 30.0, 40.0)
                .gather(Gatherers.windowSliding(3))
                .map(ventana -> ventana.stream().mapToDouble(Double::doubleValue).average().orElseThrow())
                .toList();
        System.out.println("ventanas de 3 y su promedio = " + promedios);

        System.out.println("--- reduce termina el pipeline; fold y scan lo continúan ---");
        int reducido = Stream.of(10, 20, 30, 40).reduce(0, Integer::sum);
        var plegado = Stream.of(10, 20, 30, 40)
                .gather(Gatherers.fold(() -> 0, Integer::sum))
                .map(total -> "total=" + total)
                .toList();
        var acumulado = Stream.of(10, 20, 30, 40)
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();
        System.out.println("reduce = " + reducido);
        System.out.println("fold   = " + plegado);
        System.out.println("scan   = " + acumulado);

        System.out.println("--- mapConcurrent: virtual threads, conserva el orden ---");
        var ciudades = Stream.of("Lima", "Cusco", "Arequipa", "Trujillo")
                .gather(Gatherers.mapConcurrent(2, GatherersIntegrados::consultar))
                .toList();
        System.out.println("orden de salida = " + ciudades);
    }

    private static String consultar(String ciudad) {
        try {
            Thread.sleep(duracion(ciudad));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("  terminó " + ciudad
                + " virtual=" + Thread.currentThread().isVirtual());
        return ciudad.toUpperCase();
    }

    private static long duracion(String ciudad) {
        return switch (ciudad) {
            case "Lima" -> 300;
            case "Cusco" -> 40;
            case "Arequipa" -> 180;
            default -> 20;
        };
    }
}
