// Archivo compacto (Java 25). Ejecutar con: java ScopedValues.java
// Scoped Values (JEP 506, final en Java 25): comparten datos inmutables con los
// métodos que se llaman, y con los hilos hijos, sin pasarlos como parámetro.
// Son la alternativa moderna a ThreadLocal, pensada para hilos virtuales.

static final ScopedValue<String> USUARIO = ScopedValue.newInstance();

void main() throws Exception {
    IO.println("fuera del alcance: isBound=" + USUARIO.isBound());

    // where(...).run(...): el valor solo existe mientras se ejecuta el lambda
    ScopedValue.where(USUARIO, "ana").run(() -> procesarPedido());

    // where(...).call(...): igual, pero devuelve un resultado
    String saludo = ScopedValue.where(USUARIO, "luis").call(() -> "hola " + USUARIO.get());
    IO.println(saludo);

    // Enlace anidado (rebinding): el valor interno oculta al externo solo dentro de su alcance
    ScopedValue.where(USUARIO, "ana").run(() -> {
        IO.println("externo: " + USUARIO.get());
        ScopedValue.where(USUARIO, "admin").run(() -> IO.println("anidado: " + USUARIO.get()));
        IO.println("externo otra vez: " + USUARIO.get());
    });

    // Fuera del alcance, get() lanza NoSuchElementException
    try {
        USUARIO.get();
    } catch (NoSuchElementException e) {
        IO.println("get() fuera del alcance -> NoSuchElementException");
    }
    IO.println("orElse: " + USUARIO.orElse("anónimo"));
}

void procesarPedido() {
    // no recibe el usuario como parámetro: lo lee del ScopedValue
    IO.println("procesando pedido de " + USUARIO.get() + " en " + Thread.currentThread().getName());
}
