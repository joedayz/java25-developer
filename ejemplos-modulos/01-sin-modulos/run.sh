#!/usr/bin/env bash
# Aplicación tradicional (sin module-info): classpath y JAR no modular.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target

titulo "Compilar y ejecutar con el classpath"
paso javac -d target/classes src/com/joedayz/legado/*.java src/com/joedayz/legado/interno/*.java
paso java -cp target/classes com.joedayz.legado.Principal

titulo "Empaquetar un JAR no modular (ejecutable)"
paso jar --create --file target/legado.jar --main-class com.joedayz.legado.Principal -C target/classes .
paso jar --list --file target/legado.jar
paso java -jar target/legado.jar
