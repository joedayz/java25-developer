package demos;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * Acciones atómicas (java.util.concurrent.atomic): operaciones de leer-modificar-escribir
 * sin candados, usando instrucciones CAS (compare-and-set) del procesador.
 */
public class Atomicos {

    public static void main(String[] args) {
        AtomicInteger contador = new AtomicInteger();
        LongAdder sumador = new LongAdder();          // más rápido con mucha contención
        AtomicReference<String> ultimo = new AtomicReference<>("ninguno");

        try (var es = Executors.newFixedThreadPool(4)) {
            for (int t = 0; t < 4; t++) {
                int id = t;
                es.submit(() -> {
                    for (int i = 0; i < 50_000; i++) {
                        contador.incrementAndGet();
                        sumador.increment();
                    }
                    ultimo.set("hilo-" + id);
                });
            }
        }
        System.out.println("AtomicInteger: " + contador.get());
        System.out.println("LongAdder:     " + sumador.sum());
        System.out.println("último:        " + ultimo.get());

        // Otras operaciones atómicas
        AtomicInteger x = new AtomicInteger(10);
        System.out.println("getAndAdd(5) = " + x.getAndAdd(5) + " -> " + x.get());
        System.out.println("compareAndSet(15, 100) = " + x.compareAndSet(15, 100) + " -> " + x.get());
        System.out.println("compareAndSet(15, 200) = " + x.compareAndSet(15, 200) + " -> " + x.get());
        System.out.println("updateAndGet(v -> v * 2) = " + x.updateAndGet(v -> v * 2));
        System.out.println("accumulateAndGet(3, Math::max) = " + x.accumulateAndGet(3, Math::max));
    }
}
