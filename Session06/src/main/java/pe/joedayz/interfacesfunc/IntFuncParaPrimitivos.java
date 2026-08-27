package pe.joedayz.interfacesfunc;

import java.util.function.*;

public class IntFuncParaPrimitivos {


    static void main() {
        //IntPredicate
        //IntConsumer
        //IntFunction
        //IntSupplier
        //IntUnaryOperator
        //IntBinaryOperator

        IntPredicate isEven =
                n -> n % 2 == 0;

        System.out.println(isEven.test(4));

        IntConsumer c = n -> System.out.println(n);

        c.accept(10);

        IntFunction<String> f = n -> "Number: " + n;

        f.apply(10);

        IntSupplier s = () -> 42;

        s.getAsInt();


        IntUnaryOperator op = n -> n * 2;

        op.applyAsInt(10);

        IntBinaryOperator biOp = (a, b) -> a + b;

        biOp.applyAsInt(10, 20);


        //LongConsumer
        //LongPredicate
        //LongFunction<R>
        //LongSupplier
        //LongUnaryOperator
        //LongBinaryOperator

        LongPredicate positive = n -> n > 0;

        LongUnaryOperator doubleValue = n -> n * 2;

        LongSupplier current = () -> System.currentTimeMillis();

        LongConsumer l = n -> System.out.println(n);

        l.accept(10);

        //DoubleConsumer
        //DoublePredicate
        //DoubleFunction<R>
        //DoubleSupplier
        //DoubleUnaryOperator
        //DoubleBinaryOperator

        DoublePredicate positive2 = n -> n > 0.0;

        DoubleUnaryOperator square = n -> n * n;

        DoubleSupplier random = Math::random;


    }
}
