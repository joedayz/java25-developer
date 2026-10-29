// Archivo compacto (Java 25). Structured Concurrency es PREVIEW (JEP 505, quinta preview):
//   java --enable-preview ConcurrenciaEstructurada.java
// Las subtareas forman un grupo con un alcance (scope): si una falla, las demás se
// cancelan, y el scope no termina hasta que todas sus subtareas terminan.

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.StructuredTaskScope.Subtask;

record Pedido(String usuario, int cantidad) { }

static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

void main() throws InterruptedException {
    // 1. Todas deben terminar bien (Joiner por defecto de open())
    try (var scope = StructuredTaskScope.open()) {
        Subtask<String> usuario = scope.fork(() -> buscarUsuario());
        Subtask<Integer> cantidad = scope.fork(() -> contarPedidos());
        scope.join();                                    // espera a ambas subtareas
        IO.println("1. " + new Pedido(usuario.get(), cantidad.get()));
    }

    // 2. Si una falla, join() lanza FailedException y la otra se cancela
    try (var scope = StructuredTaskScope.open()) {
        Subtask<String> usuario = scope.fork(() -> buscarUsuario());
        Subtask<Integer> falla = scope.fork(() -> { throw new IllegalStateException("BD caída"); });
        scope.join();
    } catch (StructuredTaskScope.FailedException e) {
        IO.println("2. falló: " + e.getCause());
    }

    // 3. Gana la primera que termine bien; las demás se cancelan
    try (var scope = StructuredTaskScope.open(Joiner.<String>anySuccessfulResultOrThrow())) {
        scope.fork(() -> espejo("lima", 300));
        scope.fork(() -> espejo("miami", 100));
        scope.fork(() -> espejo("madrid", 200));
        IO.println("3. respondió primero: " + scope.join());
    }

    // 4. Las subtareas corren en hilos virtuales y heredan los Scoped Values
    ScopedValue.where(REQUEST_ID, "req-42").run(() -> {
        try (var scope = StructuredTaskScope.open()) {
            Subtask<String> s = scope.fork(() -> REQUEST_ID.get() + " en virtual=" + Thread.currentThread().isVirtual());
            scope.join();
            IO.println("4. " + s.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });
}

String buscarUsuario() throws InterruptedException {
    Thread.sleep(200);
    return "ana";
}

int contarPedidos() throws InterruptedException {
    Thread.sleep(100);
    return 3;
}

String espejo(String nombre, long ms) throws InterruptedException {
    Thread.sleep(ms);
    return nombre;
}
