package pe.joedayz.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectSupplierMain {


    static void main() {

        //Quieres convertir un Stream en una List

        List<String> nombres = Stream.of("Ana", "Luis", "Pedro", "Juan")
                .collect(
                        ArrayList::new,  //Supplier
                        List::add,       //Accumulator
                        List::addAll); //Combiner

        System.out.println(nombres);


        List<String> nombres2 = Stream.of("Ana", "Luis", "Pedro", "Juan")
                .collect(Collectors.toList());

        System.out.println(nombres2);

        // joining()
       String nombres3 = Stream.of("Ana", "Luis", "Pedro", "Juan")
                .collect(Collectors.joining(", "));

        System.out.println(nombres3);

        // collectingAndThen

        int cantidad = Stream.of("Ana", "Luis", "Pedro", "Juan")
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        List::size));

        System.out.println(cantidad);

        // Sumar numeros

        int suma = Stream.of(10, 20, 30, 40, 50)
                .collect(
                        () -> new int[]{0},
                        (acumulador, valor) -> acumulador[0] += valor,
                        (acumulador1, acumulador2) -> acumulador1[0] += acumulador2[0])[0];
        System.out.println("Suma de numeros " + suma);


        int suma2 = Stream.of(10, 20, 30, 40, 50)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Suma de numeros2 " + suma2);

        // Comparando reduce y collect

        int suma3 = Stream.of(10, 20, 30, 40, 50)
                .reduce(0, Integer::sum); // usemos reduces cuando quiero obtener UN valor a partir de sus elementos

        System.out.println("Suma de numeros3 " + suma3);

        List<Integer> resultado = Stream.of(10, 20, 30, 40, 50)
                .collect(Collectors.toList()); // Quiero construir/acumular un resultado mas estructurado, osea un contenedor

        System.out.println("Resultado de collect " + resultado);
    }
}
