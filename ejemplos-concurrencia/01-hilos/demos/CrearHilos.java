package demos;

/**
 * Formas de crear un hilo: heredar de Thread, implementar Runnable,
 * usar una expresión lambda y (Java 21+) usar los constructores Thread.Builder.
 */
public class CrearHilos {

    // 1. Heredar de Thread: poco flexible (ya no puedes heredar de otra clase)
    static class LateralThread extends Thread {
        @Override
        public void run() {
            System.out.println("1. extends Thread      -> " + getName());
        }
    }

    // 2. Implementar Runnable: práctica común
    static class LateralRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("2. implements Runnable -> " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LateralThread();
        t1.start();
        t1.join();

        Thread t2 = new Thread(new LateralRunnable());
        t2.start();
        t2.join();

        // 3. Lambda: ideal para pocas acciones
        Runnable r = () -> System.out.println("3. lambda              -> " + Thread.currentThread().getName());
        Thread t3 = new Thread(r);
        t3.start();
        t3.join();

        // 4. Java 21+: Thread.Builder para hilos de plataforma y virtuales
        Thread t4 = Thread.ofPlatform()
                .name("trabajador-", 1)          // nombres trabajador-1, trabajador-2...
                .start(() -> System.out.println("4. ofPlatform()        -> " + Thread.currentThread().getName()));
        t4.join();

        Thread t5 = Thread.ofVirtual()
                .name("virtual-1")
                .start(() -> System.out.println("5. ofVirtual()         -> " + Thread.currentThread()));
        t5.join();

        Thread t6 = Thread.startVirtualThread(
                () -> System.out.println("6. startVirtualThread  -> isVirtual=" + Thread.currentThread().isVirtual()));
        t6.join();
    }
}
