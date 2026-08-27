package pe.joedayz.interfacesfunc;

import java.util.function.Function;

public class FunctionMain {

    static void main() {

        Function<String, Integer> length = text -> text.length();
        System.out.println(length.apply("Hola mundo"));

        Function<String, String> upper = text -> text.toUpperCase();
        System.out.println(upper.apply("Hola mundo"));
    }
}
