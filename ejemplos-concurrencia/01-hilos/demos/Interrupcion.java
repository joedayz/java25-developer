package demos;

/**
 * La lógica de run decide el ciclo de vida: el hilo revisa la señal de interrupción
 * mientras corre y, si está durmiendo, recibe InterruptedException.
 */
public class Interrupcion {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            Thread ct = Thread.currentThread();          // ubica el objeto del hilo actual
            int vuelta = 0;
            while (!ct.isInterrupted()) {                // revisa la señal mientras corre
                System.out.println("trabajando... vuelta " + vuelta++);
                try {
                    Thread.sleep(300);                   // entra a TIMED_WAITING
                } catch (InterruptedException e) {
                    // al lanzar la excepción, la bandera de interrupción se limpia
                    System.out.println("interrumpido mientras dormía; isInterrupted=" + ct.isInterrupted());
                    return;                              // decide terminar
                }
            }
        };                                               // llegar al final de run termina el hilo
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("estado final: " + t.getState());
    }
}
