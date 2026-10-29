#!/usr/bin/env bash
# Verificación de las respuestas del quiz. Reutiliza los módulos de los ejemplos 03, 04 y 05.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target
for ej in 03-directivas 04-servicios 05-migracion; do
    [[ -d ../$ej/target ]] || ../$ej/run.sh > /dev/null 2>&1
done

titulo "Pregunta 1: un JAR heredado en el module path es un módulo AUTOMÁTICO"
paso javac -d target/q1 q1/com/acme/vieja/Vieja.java
mkdir -p target/libs
paso jar --create --file target/libs/vieja-lib.jar -C target/q1 .
paso java -p target/libs --describe-module vieja.lib

titulo "Pregunta 2: consumidor y proveedor solo requieren el módulo del servicio"
paso java -p ../04-servicios/target/mods --describe-module com.joedayz.tienda
paso java -p ../04-servicios/target/mods --describe-module com.joedayz.pagos.tarjeta

titulo "Pregunta 3: un paquete no puede repartirse entre dos módulos; lo no exportado queda oculto"
falla javac -d target/q3 --module-source-path ../03-directivas/errores/paquete-dividido $(find ../03-directivas/errores/paquete-dividido -name '*.java')
falla javac -d target/q3 -p ../03-directivas/target/mods --module-source-path ../03-directivas/errores/visibilidad $(find ../03-directivas/errores/visibilidad -name '*.java')

titulo "Pregunta 4 y 5: opens permite reflexión; requires static no resuelve el módulo"
paso java -p ../03-directivas/target/mods -m com.joedayz.cliente/com.joedayz.cliente.Main

titulo "Pregunta 6: import module con nombres simples repetidos"
falla java Quiz6.java

titulo "Pregunta 7: jlink no acepta módulos automáticos"
falla jlink --module-path ../05-migracion/target/libs:../05-migracion/target/mods --add-modules com.joedayz.reportes --output target/q7
