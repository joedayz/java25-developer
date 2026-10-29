package pe.joedayz.collect;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorMain {

    static void main() {

        List<String> names =
                List.of("Ana", "Luis", "Pedro", "Juan");

        Spliterator<String> spliterator = names.spliterator();


        Spliterator<String> parte1 = spliterator.trySplit();  // primero divido

        System.out.println("Parte 1");


        parte1.forEachRemaining(System.out::println);

        System.out.println("Parte 2");
        spliterator.forEachRemaining(System.out::println);

    }
}
