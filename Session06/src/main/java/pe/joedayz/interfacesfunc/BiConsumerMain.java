package pe.joedayz.interfacesfunc;

import java.util.function.BiConsumer;

public class BiConsumerMain {

    static void main() {


        BiConsumer<String, Integer> print =
                (name, age) ->
                        System.out.println(name + ": " + age);

        print.accept("John", 30);
    }
}
