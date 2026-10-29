#!/usr/bin/env bash
# Ejecuta todos los ejemplos en orden y guarda la salida en salida-completa.txt
cd "$(dirname "$0")"
for d in 0*/; do
    echo "################ ${d%/}"
    "./${d}run.sh" || { echo "FALLÓ: ${d%/}"; exit 1; }
done 2>&1 | tee salida-completa.txt
