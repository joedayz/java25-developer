#!/usr/bin/env bash
# Primer módulo: compilar, ejecutar, empaquetar JAR modulares y consultarlos.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target

titulo "Compilar los dos módulos de una vez (--module-source-path)"
paso javac -d target/mods --module-source-path src -m com.joedayz.app
paso find target/mods -name '*.class'

titulo "Ejecutar desde el module path (-p) indicando módulo/clase (-m)"
paso java -p target/mods -m com.joedayz.app/com.joedayz.app.Main

titulo "Empaquetar JAR modulares"
mkdir -p target/jars
paso jar --create --file target/jars/com.joedayz.saludos.jar -C target/mods/com.joedayz.saludos .
paso jar --create --file target/jars/com.joedayz.app.jar --main-class com.joedayz.app.Main -C target/mods/com.joedayz.app .

titulo "Ejecutar el JAR: la clase principal está en el descriptor del módulo"
paso java -p target/jars -m com.joedayz.app

titulo "Consultar los descriptores"
paso jar --describe-module --file target/jars/com.joedayz.app.jar
paso java -p target/jars --describe-module com.joedayz.saludos
echo; echo "\$ java -p target/jars --show-module-resolution --dry-run -m com.joedayz.app | grep joedayz"
java -p target/jars --show-module-resolution --dry-run -m com.joedayz.app | grep joedayz
