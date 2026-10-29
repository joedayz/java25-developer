package demos;

import java.lang.management.ManagementFactory;

/**
 * Deadlock: dos hilos toman dos candados en orden inverso y se esperan para siempre.
 * La solución: adquirir los candados siempre en el mismo orden (o usar tryLock con timeout).
 */
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();

        Thread t1 = new Thread(() -> tomar(a, b), "t1");   // a -> b
        Thread t2 = new Thread(() -> tomar(b, a), "t2");   // b -> a (orden inverso)
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        Thread.sleep(500);

        System.out.println("t1=" + t1.getState() + ", t2=" + t2.getState());
        long[] ids = ManagementFactory.getThreadMXBean().findDeadlockedThreads();
        System.out.println("hilos en deadlock detectados: " + (ids == null ? 0 : ids.length));
    }

    static void tomar(Object primero, Object segundo) {
        synchronized (primero) {
            dormir();
            synchronized (segundo) {
                System.out.println(Thread.currentThread().getName() + " obtuvo ambos candados");
            }
        }
    }

    static void dormir() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
