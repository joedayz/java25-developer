package demos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hilos virtuales (Java 21+): hilos ligeros que la JVM monta sobre unos pocos
 * hilos de plataforma ("carriers"). Ideales para tareas que pasan el tiempo esperando (E/S).
 */
public class HilosVirtuales {

    public static void main(String[] args) throws InterruptedException {
        int tareas = 10_000;
        System.out.println("plataforma (pool de 200): " + medir(Executors.newFixedThreadPool(200), tareas) + " ms");
        System.out.println("virtuales (uno por tarea): " + medir(Executors.newVirtualThreadPerTaskExecutor(), tareas) + " ms");

        // ¿Cuántos hilos de plataforma (carriers) se usaron?
        var carriers = java.util.concurrent.ConcurrentHashMap.<String>newKeySet();
        try (var es = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < tareas; i++) {
                es.submit(() -> {
                    String s = Thread.currentThread().toString();     // VirtualThread[#id]/runnable@ForkJoinPool-1-worker-N
                    carriers.add(s.substring(s.indexOf('@') + 1));
                });
            }
        }
        System.out.println(tareas + " hilos virtuales sobre " + carriers.size() + " carriers"
                + " (núcleos: " + Runtime.getRuntime().availableProcessors() + ")");

        // Crear hilos virtuales sin executor
        Thread v = Thread.ofVirtual().name("mi-virtual").start(() -> { });
        v.join();
        System.out.println(v.getName() + ": isVirtual=" + v.isVirtual() + ", isDaemon=" + v.isDaemon());
    }

    // Cada tarea "espera" 100 ms, como una llamada a una base de datos o a un servicio REST
    static long medir(ExecutorService executor, int tareas) {
        AtomicInteger hechas = new AtomicInteger();
        Instant inicio = Instant.now();
        try (executor) {                       // Java 9+: recurso efectivamente final en try
            for (int i = 0; i < tareas; i++) {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofMillis(100));
                    return hechas.incrementAndGet();
                });
            }
        }
        return Duration.between(inicio, Instant.now()).toMillis();
    }
}
