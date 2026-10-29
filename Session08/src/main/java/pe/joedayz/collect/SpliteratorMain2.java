package pe.joedayz.collect;

import java.util.Random;
import java.util.Spliterator;

public class SpliteratorMain2 {

    static void main() {


        //Este te genera 10 numeros enteros aleatorios entre 0 y 9
        Spliterator<Integer> s1 =
                new Random().ints(10, 0, 10).spliterator();

        String characteristics =
                "Concurrent " +
                        s1.hasCharacteristics(Spliterator.CONCURRENT) + "\n" +

                        "Distinct " +
                        s1.hasCharacteristics(Spliterator.DISTINCT) + "\n" +

                        "Immutable " +
                        s1.hasCharacteristics(Spliterator.IMMUTABLE) + "\n" +

                        "NonNull " +
                        s1.hasCharacteristics(Spliterator.NONNULL) + "\n" +

                        "Ordered " +
                        s1.hasCharacteristics(Spliterator.ORDERED) + "\n" +

                        "Sized " +
                        s1.hasCharacteristics(Spliterator.SIZED) + "\n" +

                        "Sorted " +
                        s1.hasCharacteristics(Spliterator.SORTED) + "\n" +

                        "Subsized " +
                        s1.hasCharacteristics(Spliterator.SUBSIZED);

        System.out.println(characteristics);

        System.out.println("Size " + s1.getExactSizeIfKnown());

        System.out.println("Estimate Size " + s1.estimateSize());

    }
}
