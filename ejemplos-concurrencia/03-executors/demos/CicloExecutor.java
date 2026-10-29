package demos;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Ciclo de vida de un ExecutorService: iniciar tareas, dejar de aceptar nuevas,
 * esperar a que terminen y detener las que siguen corriendo.
 */
public class CicloExecutor {

    public static void main(String[] args) {
        // pool de 3 hilos
        ExecutorService es = Executors.newFixedThreadPool(3);
        // lanza 10 tareas Runnable, con 3 corriendo como máximo a la vez
        for (int i = 0; i < 10; i++) {
            int n = i;
            es.execute(() -> {
                // acciones concurrentes que revisan la interrupción
                try {
                    Thread.sleep(400);
                    System.out.println("tarea " + n + " en " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("tarea " + n + " cancelada");
                }
            });
        }
        es.shutdown();                                     // deja de aceptar tareas nuevas
        try {
            es.execute(() -> { });
        } catch (RejectedExecutionException e) {
            System.out.println("después de shutdown -> RejectedExecutionException");
        }
        try {
            // espera a que terminen (aquí 1 s, para provocar la cancelación)
            if (!es.awaitTermination(1, TimeUnit.SECONDS)) {
                List<Runnable> pendientes = es.shutdownNow();  // pide cancelar las que siguen
                System.out.println("shutdownNow: " + pendientes.size() + " tareas nunca empezaron");
            }
        } catch (InterruptedException e) {
            es.shutdownNow();                              // el hilo lanzador fue interrumpido
            Thread.currentThread().interrupt();            // conserva la señal de interrupción
        }
        System.out.println("isShutdown=" + es.isShutdown() + ", isTerminated=" + es.isTerminated());

        // Java 19+: ExecutorService es AutoCloseable. close() = shutdown + esperar
        try (ExecutorService pool = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 3; i++) {
                int n = i;
                pool.submit(() -> System.out.println("try-with-resources: tarea " + n));
            }
        }
        System.out.println("todas las tareas del try terminaron");
    }
}
