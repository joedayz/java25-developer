package pe.joedayz.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NullsMain {

    static void main() {
        List<String> nombres = Arrays.asList(
                "Carlos",
                null,
                "Ana",
                "Pedro",
                null
        );

        nombres.sort(
                Comparator.nullsFirst(Comparator.naturalOrder())
        );

        System.out.println(nombres);

        nombres.sort(
                Comparator.nullsLast(Comparator.naturalOrder())
        );

        System.out.println(nombres);
    }
}
