// JEP 511 (final en Java 25): import module importa todos los paquetes exportados por un módulo
// y por los módulos que este requiere de forma transitiva.
import module java.sql;              // java.sql, javax.sql + (transitivo) java.xml, java.logging...

import java.sql.Date;                // desambigua: java.util.Date (java.base) vs java.sql.Date

void main() throws Exception {
    // java.base se importa implícitamente en un archivo compacto
    List<String> nombres = List.of("ana", "luis");

    // java.sql
    Date fecha = Date.valueOf("2026-10-19");

    // java.xml y java.logging llegan por "requires transitive" de java.sql
    var fabrica = DocumentBuilderFactory.newInstance();
    Logger log = Logger.getLogger("demo");

    IO.println(nombres + " " + fecha + " " + fabrica.getClass().getModule().getName() + " " + log.getName());
}
