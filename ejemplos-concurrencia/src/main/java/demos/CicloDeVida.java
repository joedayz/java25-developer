package demos;

import java.time.Duration;

/**
 * Recorre los estados de Thread.State: NEW, RUNNABLE, BLOCKED, WAITING,
 * TIMED_WAITING y TERMINATED. Además muestra que un hilo no se puede iniciar dos veces.
 */
public class CicloDeVida {

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();

        // TIMED_WAITING: duerme un tiempo determinado
        Thread dormilon = new Thread(() -> dormir(Duration.ofMillis(500)), "dormilon");
        System.out.println("antes de start:  " + dormilon.getState());   // NEW
        dormilon.start();
        System.out.println("después de start: " + dormilon.getState());  // RUNNABLE (o ya TIMED_WAITING)
        Thread.sleep(100);
        System.out.println("durmiendo:       " + dormilon.getState());   // TIMED_WAITING

        // WAITING: espera indefinidamente una señal (notify)
        Thread esperador = new Thread(() -> {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "esperador");
        esperador.start();
        Thread.sleep(100);
        System.out.println("esperando:       " + esperador.getState());  // WAITING

        // BLOCKED: quiere entrar a un bloque synchronized cuyo candado tiene otro hilo
        Thread bloqueado;
        synchronized (monitor) {
            bloqueado = new Thread(() -> {
                synchronized (monitor) {
                    // nada
                }
            }, "bloqueado");
            bloqueado.start();
            Thread.sleep(100);
            System.out.println("bloqueado:       " + bloqueado.getState()); // BLOCKED
            monitor.notify();                                             // despierta al esperador
        }

        dormilon.join();
        esperador.join();
        bloqueado.join();
        System.out.println("al terminar:     " + dormilon.getState() + ", isAlive=" + dormilon.isAlive());

        // El mismo Runnable puede envolverse en varios Thread...
        Runnable r = () -> { };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        // ...pero la misma instancia de Thread no se puede iniciar dos veces
        try {
            t1.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("t1.start() otra vez -> " + e.getClass().getSimpleName());
        }
    }

    private static void dormir(Duration d) {
        try {
            Thread.sleep(d);   // Java 19+: sleep acepta un Duration
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
