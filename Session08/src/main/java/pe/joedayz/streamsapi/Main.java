package pe.joedayz.streamsapi;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {

    static void main() {
        String[] values = {"RED", "GREEN", "BLUE"};

        long v1 = Arrays.stream(values)
                .filter(s -> s.indexOf('R') != -1)
                .count(); // 2

        System.out.println("Count de values que no inicien con R = " + v1);

        int v2 = Arrays.stream(values)
                .mapToInt(String::length)
                .sum(); // 12

        System.out.println("Sum de lengths de values = " + v2);

        OptionalDouble v3 = Arrays.stream(values)
                .mapToInt(String::length)
                .average();

        System.out.println("Average de lengths de values = " + v3.orElse(0.0));

        Optional<String> v4 = Arrays.stream(values)
                .max(String::compareTo);

        Optional<String> v5 = Arrays.stream(values)
                .min(String::compareTo);

        System.out.println("Max value = " + v4.orElse("No values"));
        System.out.println("Min value = " + v5.orElse("No values"));
    }
}
