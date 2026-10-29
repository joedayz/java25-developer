#!/usr/bin/env bash
# Servicios: interfaz (api), proveedores (tarjeta, yape) y consumidor (tienda) con ServiceLoader.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target
MAIN=com.joedayz.tienda/com.joedayz.tienda.Tienda

titulo "Compilar los cuatro módulos"
paso javac -d target/mods --module-source-path src $(find src -name '*.java')

titulo "Ejecutar con todos los proveedores en el module path"
paso java -p target/mods -m $MAIN

titulo "Quitar el proveedor yape: la tienda no cambia, solo el module path"
paso java -p target/mods/com.joedayz.pagos.api:target/mods/com.joedayz.tienda:target/mods/com.joedayz.pagos.tarjeta -m $MAIN

titulo "Sin proveedores: el consumidor arranca igual"
paso java -p target/mods/com.joedayz.pagos.api:target/mods/com.joedayz.tienda -m $MAIN

titulo "Descriptores: uses y provides"
paso java -p target/mods --describe-module com.joedayz.tienda
paso java -p target/mods --describe-module com.joedayz.pagos.yape

titulo "Error: consumidor sin la directiva uses (compila, pero falla en ejecución)"
paso javac -d target/errores -p target/mods --module-source-path errores/sin-uses $(find errores/sin-uses -name '*.java')
falla java -p target/mods:target/errores -m com.joedayz.olvido/com.joedayz.olvido.Olvido
