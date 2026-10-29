package demos;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Tareas Callable: devuelven un valor envuelto en un Future.
 */
public class TareasCallable {

    public static void main(String[] args) throws InterruptedException {
        // Callable como lambda (el original usaba una clase anónima)
        Callable<String> t = () -> {
            Thread.sleep(300);           // call() puede lanzar excepciones comprobadas
            return "algún valor";
        };

        try (ExecutorService es = Executors.newFixedThreadPool(10)) {
            Future<String> result = es.submit(t);      // se devuelve de inmediato
            System.out.println("isDone recién enviado: " + result.isDone());
            try {
                String value = result.get(10, TimeUnit.SECONDS);   // bloquea hasta el valor o el timeout
                System.out.println("get: " + value);
            } catch (ExecutionException e) {           // call() lanzó una excepción
                System.out.println("falló: " + e.getCause());
            } catch (TimeoutException e) {             // el valor no llegó a tiempo
                result.cancel(true);
            }

            // Una tarea que falla: get envuelve la excepción en ExecutionException
            Future<Integer> falla = es.submit(() -> Integer.parseInt("diez"));
            try {
                falla.get();
            } catch (ExecutionException e) {
                System.out.println("ExecutionException, causa: " + e.getCause());
            }

            // Java 19+: state(), resultNow() y exceptionNow()
            System.out.println("state: " + result.state() + " -> resultNow: " + result.resultNow());
            System.out.println("state: " + falla.state() + " -> exceptionNow: " + falla.exceptionNow());

            // invokeAll espera todas; invokeAny devuelve el resultado de la primera que termine bien
            List<Callable<Integer>> tareas = List.of(() -> 1, () -> 2, () -> 3);
            int suma = 0;
            for (Future<Integer> f : es.invokeAll(tareas)) {
                suma += f.resultNow();
            }
            System.out.println("invokeAll suma: " + suma);
            System.out.println("invokeAny: " + es.invokeAny(List.of(() -> "rápida", () -> {
                Thread.sleep(1000);
                return "lenta";
            })));
        } catch (ExecutionException e) {
            System.out.println("invokeAny: ninguna terminó bien");
        }
    }
}
