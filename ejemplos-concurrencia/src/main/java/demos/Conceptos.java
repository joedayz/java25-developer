package demos;

/**
 * Un hilo es un camino de ejecución. Cuatro hilos ejecutan la misma tarea (Lateral)
 * mientras el hilo main sigue con su propio trabajo: el orden de la salida cambia
 * en cada ejecución porque lo decide el planificador de hilos.
 */
public class Conceptos {

    public static void main(String[] args) {
        Lateral la = new Lateral();
        new Thread(la).start();
        new Thread(la).start();
        new Thread(la).start();
        new Thread(la).start();
        // acciones del hilo main
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " -> paso " + i);
        }
    }
}

class Lateral implements Runnable {

    @Override
    public void run() {
        // acciones del hilo
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " -> paso " + i);
        }
    }
}
