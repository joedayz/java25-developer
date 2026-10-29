package demos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * La clase Executors crea distintos ExecutorService. Aquí: un pool programado
 * que ejecuta una tarea cada segundo y un executor "congelado".
 */
public class TiposExecutor {

    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println(LocalTime.now().format(HORA) + " tarea en "
                + Thread.currentThread().getName());

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        System.out.println(LocalTime.now().format(HORA) + " programando...");
        // retardo inicial de 2 s y luego cada 1 s (el original usaba 10 s y 5 s)
        ses.scheduleAtFixedRate(task, 2, 1, TimeUnit.SECONDS);

        ExecutorService es = Executors.unconfigurableExecutorService(ses);
        System.out.println("¿se puede reconfigurar? " + (es instanceof ThreadPoolExecutor));

        Thread.sleep(4500);
        ses.shutdown();

        // Otras fábricas
        try (ExecutorService fijo = Executors.newFixedThreadPool(4);
             ExecutorService robo = Executors.newWorkStealingPool();
             ExecutorService unico = Executors.newSingleThreadExecutor();
             ExecutorService cache = Executors.newCachedThreadPool();
             ExecutorService virtual = Executors.newVirtualThreadPerTaskExecutor()) {   // Java 21+
            for (ExecutorService e : new ExecutorService[] {fijo, robo, unico, cache, virtual}) {
                e.submit(() -> System.out.println("hola desde " + Thread.currentThread()));
            }
        }   // Java 19+: close() espera a que terminen las tareas
    }
}
