package demos;

/**
 * Monitores: synchronized garantiza acceso exclusivo. Sin él, dos hilos que
 * incrementan el mismo contador pierden actualizaciones (condición de carrera).
 */
public class Sincronizacion {

    static class Some {
        private int contador;

        // monitor: el objeto actual (this)
        public synchronized void a() {
            contador++;
        }

        // monitor: Some.class
        public static synchronized void b() {
            // acceso exclusivo a nivel de clase
        }

        // sin sincronizar
        public void c() {
            contador++;
        }

        int contador() {
            return contador;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("sin synchronized:   " + contar(false));
        System.out.println("con synchronized:   " + contar(true));
    }

    static int contar(boolean sincronizado) throws InterruptedException {
        Some s = new Some();
        Runnable r = () -> {
            for (int i = 0; i < 100_000; i++) {
                if (sincronizado) {
                    s.a();
                    Some.b();
                    synchronized (s) {     // monitor: el objeto s
                        s.c();
                    }
                } else {
                    s.c();
                    s.c();
                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return s.contador();   // se esperan 400000
    }
}
