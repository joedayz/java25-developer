// Pregunta 3: wait/notify fuera de un bloque synchronized
void main() throws InterruptedException {
    Object obj = new Object();
    obj.wait();                 // IllegalMonitorStateException: current thread is not owner
}
