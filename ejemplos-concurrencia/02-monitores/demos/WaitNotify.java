package demos;

/**
 * wait/notify: un hilo espera indefinidamente sobre un monitor hasta que otro
 * hilo lo despierta. Ambos métodos deben llamarse dentro de synchronized sobre
 * el mismo monitor; si no, se lanza IllegalMonitorStateException.
 */
public class WaitNotify {

    private static boolean listo = false;   // condición protegida por obj

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Runnable r = () -> {
            String nombre = Thread.currentThread().getName();
            try {
                synchronized (obj) {
                    while (!listo) {             // siempre en un bucle: evita despertares espurios
                        System.out.println(nombre + " espera");
                        obj.wait();
                    }
                }
                System.out.println(nombre + " continúa");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Thread t1 = new Thread(r, "hilo-1");
        Thread t2 = new Thread(r, "hilo-2");
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println("estados: " + t1.getState() + ", " + t2.getState());
        synchronized (obj) {
            listo = true;
            obj.notifyAll();                    // notify() despertaría solo a uno (al azar)
        }
        t1.join();
        t2.join();

        try {
            obj.notify();                       // fuera de synchronized
        } catch (IllegalMonitorStateException e) {
            System.out.println("notify sin synchronized -> " + e.getClass().getSimpleName());
        }
    }
}
