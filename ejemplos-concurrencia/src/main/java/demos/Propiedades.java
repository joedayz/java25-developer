package demos;

import java.time.Duration;

/**
 * Propiedades comunes de un hilo: nombre, ID, daemon, prioridad y join.
 */
public class Propiedades {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Thread t = new Thread(r, "Mi Hilo");
        t.setDaemon(true);                // antes de start
        t.setPriority(3);
        t.start();

        long id = t.threadId();           // Java 19+: reemplaza a getId() (obsoleto)
        System.out.println("nombre=" + t.getName() + ", id=" + id
                + ", daemon=" + t.isDaemon() + ", prioridad=" + t.getPriority());

        // setDaemon después de start lanza IllegalThreadStateException
        try {
            t.setDaemon(false);
        } catch (IllegalThreadStateException e) {
            System.out.println("setDaemon tras start -> " + e.getClass().getSimpleName());
        }

        // Java 19+: join con Duration devuelve true si el hilo terminó a tiempo
        boolean termino = t.join(Duration.ofSeconds(1));
        System.out.println("terminó a tiempo: " + termino);

        System.out.println("MIN=" + Thread.MIN_PRIORITY + ", NORM=" + Thread.NORM_PRIORITY
                + ", MAX=" + Thread.MAX_PRIORITY);

        // Los hilos virtuales siempre son daemon y su prioridad es fija (NORM_PRIORITY)
        Thread v = Thread.ofVirtual().unstarted(r);
        v.setPriority(Thread.MAX_PRIORITY);   // se ignora
        System.out.println("virtual: daemon=" + v.isDaemon() + ", prioridad=" + v.getPriority());
        try {
            v.setDaemon(false);
        } catch (IllegalArgumentException e) {
            System.out.println("virtual.setDaemon(false) -> " + e.getClass().getSimpleName());
        }
    }
}
