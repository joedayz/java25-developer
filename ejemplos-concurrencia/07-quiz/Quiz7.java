// Pregunta 7: Scoped Values (final en Java 25, no necesita --enable-preview)
static final ScopedValue<String> U = ScopedValue.newInstance();

void main() {
    ScopedValue.where(U, "ana").run(() -> IO.print(U.get() + " "));
    IO.println(U.orElse("nadie"));   // ana nadie
}
