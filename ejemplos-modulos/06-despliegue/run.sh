#!/usr/bin/env bash
# Despliegue: jdeps --print-module-deps, jlink (imagen a medida), jpackage y caché AOT.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target
JDK_HOME=$(java -XshowSettings:properties -version 2>&1 | awk -F'= ' '/java.home/ {print $2}')

titulo "Compilar y empaquetar el módulo"
paso javac -d target/mods --module-source-path src $(find src -name '*.java')
mkdir -p target/jars
paso jar --create --file target/jars/hola.jar --main-class com.joedayz.hola.Main -C target/mods/com.joedayz.hola .

titulo "¿Qué módulos del JDK necesita?"
paso jdeps --print-module-deps target/jars/hola.jar

titulo "jlink: crear una imagen de ejecución a medida, con lanzador"
paso jlink --module-path target/jars --add-modules com.joedayz.hola \
    --launcher hola=com.joedayz.hola \
    --strip-debug --no-header-files --no-man-pages --compress zip-9 \
    --output target/imagen
paso target/imagen/bin/hola
paso target/imagen/bin/java --list-modules
echo; echo "\$ du -sh target/imagen <JDK completo>"
du -sh target/imagen "$JDK_HOME"

titulo "Límites de jlink"
falla jlink --module-path ../05-migracion/target/libs --add-modules texto.utils --output target/no-automaticos
if [[ ! -d "$JDK_HOME/jmods" ]]; then
    echo; echo "(Este JDK no trae la carpeta jmods/: jlink enlaza desde la imagen en ejecución, JEP 493)"
    falla jlink --add-modules jdk.jlink --output target/no-jlink
fi

titulo "jpackage: aplicación nativa a partir de la imagen de jlink"
# En iCloud Drive la firma de macOS falla por atributos extendidos: se genera en una carpeta temporal.
DEST="${TMPDIR:-/tmp}/joedayz-paquete"
rm -rf "$DEST"
paso jpackage --type app-image --name Hola --runtime-image target/imagen \
    --module com.joedayz.hola/com.joedayz.hola.Main --dest "$DEST"
ls "$DEST"

titulo "Caché AOT (Java 24+): arranque más rápido"
paso javac -d target/aot/clases aot/com/joedayz/arranque/Arranque.java
paso jar --create --file target/aot/arranque.jar --main-class com.joedayz.arranque.Arranque -C target/aot/clases .
paso java -jar target/aot/arranque.jar
# Java 25 (JEP 514): un solo paso entrena y crea el caché
paso java -XX:AOTCacheOutput=target/aot/app.aot -jar target/aot/arranque.jar
TIMEFORMAT='%R s'
echo; echo "5 arranques sin caché:"
time (for i in 1 2 3 4 5; do java -jar target/aot/arranque.jar > /dev/null; done)
echo "5 arranques con -XX:AOTCache:"
time (for i in 1 2 3 4 5; do java -XX:AOTCache=target/aot/app.aot -jar target/aot/arranque.jar > /dev/null; done)
