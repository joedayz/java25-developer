package pe.joedayz.interfacesfunc;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {
    static void main() {
        Consumer<String> printer = text -> System.out.println(text);
        printer.accept("Hola mundo");


        List<String> names = List.of("Juan", "Pedro", "Maria");
        names.forEach(name -> System.out.print(name + " "));

    }
}
