#!/usr/bin/env bash
# Novedades de Java 22-25 relacionadas con módulos y con la forma de ejecutar programas.
cd "$(dirname "$0")" && source ../comun.sh

titulo "JEP 511: import module (final en Java 25)"
paso java ImportarModulos.java
falla java ErrorAmbiguo.java

titulo "JEP 512: archivos compactos y main de instancia (final en Java 25)"
paso java Compacto.java

titulo "JEP 458: programas de varios archivos desde el código fuente (Java 22)"
paso java multi-archivo/Principal.java

titulo "Encapsulación fuerte del JDK y --add-opens"
paso java EncapsulacionJdk.java
paso java --add-opens java.base/java.lang=ALL-UNNAMED EncapsulacionJdk.java

titulo "sun.misc.Unsafe: advertencia en ejecución desde Java 24 (JEP 498)"
paso java UnsafeAviso.java
paso java --sun-misc-unsafe-memory-access=allow UnsafeAviso.java
