package demos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;

/**
 * Java 24+ (JEP 491): un hilo virtual que se bloquea dentro de synchronized ya NO
 * queda "anclado" (pinned) a su carrier: lo libera para que otros hilos virtuales avancen.
 *
 * Ejecuta este programa con JDK 21 y con JDK 25 y compara los tiempos:
 *   JDK 21 -> cada carrier queda ocupado durante el sleep: ~ 100 tareas x 100 ms / 2 carriers
 *   JDK 25 -> el carrier se libera: ~ 100 ms en total
 */
public class SinPinning {

    public static void main(String[] args) {
        // Solo 2 carriers para que el efecto sea evidente (debe fijarse antes de crear hilos virtuales)
        System.setProperty("jdk.virtualThreadScheduler.parallelism", "2");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "2");

        Instant inicio = Instant.now();
        try (var es = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100; i++) {
                Object lock = new Object();            // un candado por tarea: no hay competencia
                es.submit(() -> {
                    synchronized (lock) {
                        Thread.sleep(Duration.ofMillis(100));   // se bloquea dentro de synchronized
                    }
                    return null;
                });
            }
        }
        System.out.println("Java " + Runtime.version().feature() + ": 100 tareas en "
                + Duration.between(inicio, Instant.now()).toMillis() + " ms");
    }
}
