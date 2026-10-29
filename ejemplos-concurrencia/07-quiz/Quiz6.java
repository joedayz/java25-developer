// Pregunta 6: volatile no hace atómico a count++
static volatile int count;

void main() throws InterruptedException {
    Runnable r = () -> {
        for (int i = 0; i < 100_000; i++) count++;
    };
    Thread a = new Thread(r), b = new Thread(r);
    a.start(); b.start();
    a.join(); b.join();
    IO.println(count);          // 200000 o menos (casi siempre menos)
}
