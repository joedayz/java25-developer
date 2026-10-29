package pe.joedayz.gatherers;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class Main {

    static void main() {

        //stream
        //    .filter(...)
        //    .map(...)
        //    .flatMap(...)
        //    .sorted(...)
        //    .distinct(...)
        //    .limit(...)
        //    .collect(...);

        //Reto: "Quiero agrupar los elementos de 3 en 3."
        // 1 2 3 4 5 6 7 8 9

        //1. windowFixed
        // [1 2 3] [4 5 6] [7 8 9]

        var result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(Gatherers.windowFixed(3))
                .toList();

        // En español Gatherers significa "recolectores" o "agrupadores/procesadores"

        System.out.println(result);

        //2. windowSliding

        var result2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(Gatherers.windowSliding(3))
                .toList();

        System.out.println(result2);

        //3. scan()

        var result3 = Stream.of(1, 2, 3, 4)
                .gather(Gatherers.scan( ()->0, Integer::sum))
                .toList();

        System.out.println(result3);


        //4. fold()

        var result4 = Stream.of("Java", " ", "25")
                .gather(Gatherers.fold( StringBuilder::new, StringBuilder::append))
                .toList();

        System.out.println(result4);


        // mapConcurrent()
        Cliente cliente1 = new Cliente(1, "Juan");
        Cliente cliente2 = new Cliente(2, "Pedro");
        Cliente cliente3 = new Cliente(3, "Maria");
        ///
        Cliente cliente10 = new Cliente(10, "Luis");

        //4 = máximo de 4 elementos siendo procesados al mismo tiempo.
        var result5 = Stream.of(cliente1, cliente2, cliente3, cliente10)
                .gather(Gatherers.mapConcurrent(4, cliente -> {
                    return procesarCliente(cliente);
                }))
                .toList();

        System.out.println(result5);



    }

    private static String procesarCliente(Cliente cliente) {
        // Simulando una operación costosa
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cliente.nombre().toUpperCase();
    }
}
