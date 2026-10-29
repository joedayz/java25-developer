# Funciones comunes para los scripts run.sh de esta lección.
# Uso: source ../comun.sh   (cada run.sh lo hace automáticamente)
# Si tu "java" por defecto no es la versión 25, define JAVA25_HOME:
#   export JAVA25_HOME=/ruta/al/jdk-25
set -euo pipefail
if [[ -n "${JAVA25_HOME:-}" ]]; then
    export JAVA_HOME="$JAVA25_HOME"
    export PATH="$JAVA25_HOME/bin:$PATH"
fi
version=$(java -XshowSettings:properties -version 2>&1 | awk -F'= ' '/java.specification.version/ {print $2}')
if [[ "$version" != "25" ]]; then
    echo "Se necesita JDK 25 (se encontró: ${version:-ninguno}). Define JAVA25_HOME." >&2
    exit 1
fi

# Muestra el comando y lo ejecuta
paso() { echo; echo "\$ $*"; "$@"; }
# Muestra el comando, lo ejecuta y espera que falle (no detiene el script)
falla() { echo; echo "\$ $*    # se espera un error"; if "$@" 2>&1; then echo "(¡no falló!)"; fi; }
titulo() { echo; echo "=== $* ==="; }
