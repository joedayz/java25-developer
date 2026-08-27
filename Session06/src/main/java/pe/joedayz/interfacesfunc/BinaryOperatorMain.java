package pe.joedayz.interfacesfunc;

import java.util.function.BinaryOperator;

public class BinaryOperatorMain {

    static void main() {

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(5, 3));

        BinaryOperator<String> concat = (a, b) -> a + b;
        System.out.println(concat.apply("Hello", "World"));

    }
}
