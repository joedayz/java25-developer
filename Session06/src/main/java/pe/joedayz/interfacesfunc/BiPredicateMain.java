package pe.joedayz.interfacesfunc;

import java.util.function.BiPredicate;

public class BiPredicateMain {

    static void main() {

        BiPredicate<String, String> sameLength =
                (a, b) -> a.length() == b.length();

        System.out.println(sameLength.test("Hola", "Mundo")); // true
        System.out.println(sameLength.test("Hola", "Mund")); // false

    }
}
