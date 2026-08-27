package pe.joedayz.interfacesfunc;

import java.util.function.*;

public class FuncionesPrimitivoAPrimitivo {

    static void main() {

        //Conversión entre primitivos
        //IntToLongFunction
        //IntToDoubleFunction
        //
        //LongToIntFunction
        //LongToDoubleFunction
        //
        //DoubleToIntFunction
        //DoubleToLongFunction



        IntToLongFunction f1 = n -> n * 1000L;
        System.out.printf("IntToLongFunction: %d%n", f1.applyAsLong(5));

        IntToDoubleFunction f2 = n -> n / 2.0;
        System.out.println("IntToDoubleFunction: " + f2.applyAsDouble(5));


        LongToIntFunction f3 = n -> (int) n;
        System.out.println("LongToIntFunction: " + f3.applyAsInt(5));

        DoubleToIntFunction f4 = n -> (int) n;
        System.out.println("DoubleToIntFunction: " + f4.applyAsInt(5));

        DoubleToLongFunction f5 = n -> (long) n;
        System.out.println("DoubleToLongFunction: " + f5.applyAsLong(5));


        //       ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T>

      ToIntFunction<String> length =
              String::length;

      //ToIntBiFunction, ToDoubleBiFunction, ToLongBiFunction

        ToIntBiFunction<String, String> concatLength =
                (s1, s2) -> s1.length() + s2.length();

      // En total hay 43 interfaces funcionales en java.util.function

        // En java 25 no ha cambiado. Son las mismas interfaces que en java 8
        

    }
}
