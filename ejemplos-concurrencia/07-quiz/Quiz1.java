// Pregunta 1: ¿en qué estado está un hilo que ejecuta Thread.sleep(1000)?
void main() throws InterruptedException {
    Thread t = new Thread(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });
    t.start();
    Thread.sleep(100);
    IO.println(t.getState());   // TIMED_WAITING
}
