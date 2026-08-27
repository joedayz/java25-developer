package pe.joedayz.interfacesfunc;

import java.util.function.Supplier;

public class SupplierMain {

    static void main() {
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        Supplier<String> greeting = () -> "Hola mundo";
        System.out.println(greeting.get());
    }
}
