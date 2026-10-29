package demos;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/**
 * Colecciones concurrentes: seguras para varios hilos sin sincronizar a mano.
 */
public class Colecciones {

    public static void main(String[] args) throws InterruptedException {
        // ConcurrentHashMap: operaciones atómicas como merge, compute, putIfAbsent
        Map<String, Integer> votos = new ConcurrentHashMap<>();
        try (var es = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                String lenguaje = i % 3 == 0 ? "Java" : (i % 3 == 1 ? "Kotlin" : "Scala");
                es.submit(() -> votos.merge(lenguaje, 1, Integer::sum));
            }
        }
        System.out.println("votos: " + new java.util.TreeMap<>(votos));

        // ArrayList: modificarla mientras se recorre lanza ConcurrentModificationException
        List<String> normal = new ArrayList<>(List.of("a", "b", "c"));
        try {
            for (String s : normal) {
                normal.add(s + "!");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ArrayList -> ConcurrentModificationException");
        }

        // CopyOnWriteArrayList: el iterador recorre una copia (snapshot)
        List<String> cow = new CopyOnWriteArrayList<>(List.of("a", "b", "c"));
        for (String s : cow) {
            cow.add(s + "!");
        }
        System.out.println("CopyOnWriteArrayList -> " + cow);

        // BlockingQueue: productor/consumidor sin wait/notify
        BlockingQueue<Integer> cola = new ArrayBlockingQueue<>(2);
        Thread productor = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    cola.put(i);                      // se bloquea si la cola está llena
                }
                cola.put(-1);                         // marca de fin
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        StringBuilder recibidos = new StringBuilder();
        for (int n; (n = cola.take()) != -1; ) {      // se bloquea si la cola está vacía
            recibidos.append(n).append(' ');
        }
        productor.join();
        System.out.println("BlockingQueue -> " + recibidos.toString().trim());
    }
}
