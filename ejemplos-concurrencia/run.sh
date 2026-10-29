#!/usr/bin/env bash
# run.sh — ejecuta los demos "compact source file" de 06-java25 y 07-quiz
# directamente como un único archivo fuente, sin pasar por Maven.
#
# Estos archivos declaran clases sin nombre (JEP 477) y usan features
# preview de Java 25 (Structured Concurrency JEP 505, Scoped Values JEP 506),
# por eso se ejecutan con `java --source 25 --enable-preview <archivo>.java`
# en lugar de compilarse como parte del proyecto Maven.
#
# Uso:
#   ./run.sh 06-java25/ScopedValues.java
#   ./run.sh 07-quiz/Quiz1.java
#   ./run.sh            # ejecuta todos los .java de 06-java25 y 07-quiz, uno tras otro

set -euo pipefail
cd "$(dirname "$0")"

run_one() {
    local archivo="$1"
    echo "=== $archivo ==="
    java --source 25 --enable-preview "$archivo"
    echo
}

if [[ $# -ge 1 ]]; then
    run_one "$1"
else
    for archivo in 06-java25/*.java 07-quiz/*.java; do
        run_one "$archivo"
    done
fi
