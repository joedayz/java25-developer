package demos;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Locks (java.util.concurrent.locks): más flexibles que synchronized.
 * Permiten intentar adquirir el candado (tryLock), esperar con timeout,
 * ser interrumpidos y separar lectores de escritores.
 */
public class Locks {

    static class Cuenta {
        private final Lock lock = new ReentrantLock();
        private int saldo = 100;

        boolean retirar(int monto) throws InterruptedException {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {   // espera como máximo 1 s
                try {
                    if (saldo >= monto) {
                        Thread.sleep(10);              // simula trabajo
                        saldo -= monto;
                        return true;
                    }
                    return false;
                } finally {
                    lock.unlock();                     // siempre en finally
                }
            }
            return false;                              // no obtuvo el candado
        }
    }

    static class Cache {
        private final ReadWriteLock rw = new ReentrantReadWriteLock();
        private final Map<String, String> datos = new HashMap<>();

        String leer(String k) {
            rw.readLock().lock();                      // varios lectores a la vez
            try {
                return datos.get(k);
            } finally {
                rw.readLock().unlock();
            }
        }

        void escribir(String k, String v) {
            rw.writeLock().lock();                     // un solo escritor, sin lectores
            try {
                datos.put(k, v);
            } finally {
                rw.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        var exitos = new java.util.concurrent.atomic.AtomicInteger();
        try (var es = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 5; i++) {
                es.submit(() -> {
                    if (cuenta.retirar(30)) {
                        exitos.incrementAndGet();
                    }
                    return null;
                });
            }
        }
        System.out.println("retiros de 30 con saldo 100: " + exitos.get() + " exitosos, saldo final " + cuenta.saldo);

        Cache cache = new Cache();
        cache.escribir("java", "25");
        System.out.println("cache: java=" + cache.leer("java"));

        // ReentrantLock es reentrante: el mismo hilo puede adquirirlo varias veces
        ReentrantLock r = new ReentrantLock();
        r.lock();
        r.lock();
        System.out.println("getHoldCount = " + r.getHoldCount());
        r.unlock();
        r.unlock();
    }
}
