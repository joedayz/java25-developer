// JEP 512 (final en Java 25): archivo compacto con método main de instancia.
// Sin declaración de clase, sin public static, sin String[] args, sin imports de java.base.
String saludo = "Hola";

void main() {
    var cursos = new ArrayList<>(List.of("Módulos", "Concurrencia", "IO"));
    Collections.sort(cursos);
    IO.println(saludo + ", cursos: " + cursos);
    IO.println("clase implícita: " + getClass().getName() + ", módulo: " + getClass().getModule());
}
