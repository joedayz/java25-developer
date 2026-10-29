import java.lang.reflect.Field;
import sun.misc.Unsafe;

// JEP 471/498: los métodos de acceso a memoria de sun.misc.Unsafe están obsoletos para eliminación.
// Desde Java 24 su primer uso imprime una advertencia. Alternativa: VarHandle y la API FFM (MemorySegment).
@SuppressWarnings("removal")   // oculta los avisos de javac; el aviso en ejecución sigue apareciendo
void main() throws Exception {
    Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    Unsafe u = (Unsafe) f.get(null);
    long dir = u.allocateMemory(8);
    u.putLong(dir, 25L);
    IO.println("leído: " + u.getLong(dir));
    u.freeMemory(dir);
}
