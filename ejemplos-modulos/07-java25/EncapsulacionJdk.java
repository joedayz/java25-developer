import java.lang.reflect.Field;

// Encapsulación fuerte del JDK (JEP 403, Java 17): java.base no abre java.lang.
// Solución explícita en la línea de comandos: --add-opens java.base/java.lang=ALL-UNNAMED
void main() throws Exception {
    Field valor = String.class.getDeclaredField("value");
    try {
        valor.setAccessible(true);
        IO.println("acceso concedido: " + ((byte[]) valor.get("hola")).length + " bytes");
    } catch (InaccessibleObjectException e) {
        IO.println(e.getMessage());
    }
}
