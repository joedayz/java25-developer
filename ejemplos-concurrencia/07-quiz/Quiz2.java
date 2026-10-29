// Pregunta 2: ¿qué ocurre al iniciar dos veces el mismo Thread?
void main() {
    Thread t = new Thread(() -> IO.println("corriendo"));
    t.start();
    t.start();                  // IllegalThreadStateException en tiempo de ejecución
}
