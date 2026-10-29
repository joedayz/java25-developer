#!/usr/bin/env bash
# Directivas de module-info: exports, exports...to, requires transitive, requires static, opens.
cd "$(dirname "$0")" && source ../comun.sh
rm -rf target
MAIN=com.joedayz.cliente/com.joedayz.cliente.Main

titulo "Compilar los cuatro módulos"
paso javac -d target/mods --module-source-path src $(find src -name '*.java')

titulo "Ejecutar: métricas está en el module path, pero requires static NO la resuelve"
paso java -p target/mods -m $MAIN

titulo "Ejecutar agregando el módulo opcional"
paso java -p target/mods --add-modules com.joedayz.metricas -m $MAIN

titulo "Errores de compilación típicos (carpeta errores/)"
for caso in visibilidad sin-requires ciclo paquete-dividido; do
    falla javac -d target/errores -p target/mods --module-source-path errores/$caso $(find errores/$caso -name '*.java')
done
