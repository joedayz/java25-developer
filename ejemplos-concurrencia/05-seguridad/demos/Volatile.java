package demos;

/**
 * volatile garantiza visibilidad: cuando un hilo escribe la variable, los demás
 * hilos ven el nuevo valor. Sin volatile, el JIT puede "cachear" la lectura y el
 * bucle no termina nunca.
 */
public class Volatile {

    private static volatile boolean activo = true;   // prueba quitando volatile

    public static void main(String[] args) throws InterruptedException {
        Thread trabajador = new Thread(() -> {
            long vueltas = 0;
            while (activo) {
                vueltas++;
            }
            System.out.println("trabajador se detuvo tras " + (vueltas > 0 ? "muchas" : "0") + " vueltas");
        });
        trabajador.setDaemon(true);   // si el bucle no termina, no impide que la JVM salga
        trabajador.start();

        Thread.sleep(500);
        activo = false;               // la escritura es visible para el trabajador
        trabajador.join(2000);
        System.out.println("¿sigue vivo? " + trabajador.isAlive());

        // volatile NO hace atómico a count++ (leer, sumar y escribir son 3 pasos)
        System.out.println("volatile count++ con 2 hilos: " + ContadorVolatile.contar() + " (se esperaban 200000)");
    }

    static class ContadorVolatile {
        static volatile int count;

        static int contar() throws InterruptedException {
            Runnable r = () -> {
                for (int i = 0; i < 100_000; i++) {
                    count++;
                }
            };
            Thread a = new Thread(r);
            Thread b = new Thread(r);
            a.start();
            b.start();
            a.join();
            b.join();
            return count;
        }
    }
}
