// Pregunta 5: propiedades de los hilos virtuales
void main() {
    Thread v = Thread.ofVirtual().unstarted(() -> { });
    v.setPriority(Thread.MAX_PRIORITY);
    IO.println("prioridad: " + v.getPriority());   // 5: se ignora
    IO.println("daemon: " + v.isDaemon());          // true
    v.setDaemon(false);                             // IllegalArgumentException
}
