package pe.joedayz.interfacesfunc;

import java.util.function.Predicate;

public class MainPredicate {

    static void main() {

        // I = lambda

        Predicate<Integer> isAdult = age -> age >= 18;

        System.out.println(isAdult.test(18));


        System.out.println(isAdult.test(13));

        Predicate<String> isLong = text -> text.length() > 10;

        System.out.println(isLong.test("Hola mundo"));

    }
}
