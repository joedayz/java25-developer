package pe.joedayz.interfacesfunc;

import java.util.function.UnaryOperator;

public class UnaryOperatorMain {

    static void main() {

        UnaryOperator<Integer> doubleValue = n -> n * 2;
        System.out.println(doubleValue.apply(5));
    }
}
