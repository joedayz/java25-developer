// Pregunta 4: enviar una tarea después de shutdown()
import java.util.concurrent.*;

void main() {
    ExecutorService es = Executors.newFixedThreadPool(2);
    es.submit(() -> IO.println("A"));
    es.shutdown();
    es.submit(() -> IO.println("B"));   // RejectedExecutionException
}
