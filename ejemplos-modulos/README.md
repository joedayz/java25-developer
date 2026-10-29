# Módulos y despliegue: ejemplos para Java 25

Cada carpeta tiene un `run.sh` que compila y ejecuta el ejemplo. El script muestra cada comando
(`$ ...`) antes de ejecutarlo, así que la salida sirve como guion de la demo.

| Carpeta | Tema | Diapositivas |
|---|---|---|
| `01-sin-modulos` | Classpath, JAR no modular, módulo sin nombre | 04 |
| `02-primer-modulo` | `module-info`, `--module-source-path`, `-p`/`-m`, JAR modular, `--describe-module` | 08–10 |
| `03-directivas` | `exports`, `exports ... to`, `requires transitive`, `requires static`, `opens`; carpeta `errores/` | 12–17 |
| `04-servicios` | `uses`, `provides ... with`, `ServiceLoader`, método `provider()` | 18–20 |
| `05-migracion` | Módulos automáticos, `Automatic-Module-Name`, módulo sin nombre, `jdeps` | 21–25 |
| `06-despliegue` | `jlink`, `jpackage`, caché AOT | 27–30 |
| `07-java25` | `import module`, archivos compactos, lanzador multiarchivo, `--add-opens`, `Unsafe` | 26, 31–32 |
| `08-quiz` | Verificación de las 7 preguntas del quiz | 35–41 |

## Requisitos

- JDK 25. Si `java -version` no muestra 25, define la ruta antes de ejecutar:

  ```bash
  export JAVA25_HOME=/Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home
  ```

- macOS o Linux con `bash`. En Windows usa Git Bash o WSL.

## Ejecutar

```bash
./02-primer-modulo/run.sh      # un ejemplo
./ejecutar-todo.sh             # todos, en orden (poco más de 1 minuto)
```

Cada script borra y regenera su carpeta `target/`.

## Notas para la clase

- Los errores de compilación y ejecución que se muestran en clase salen de `falla ...` en los scripts:
  el error es intencional y el script continúa.
- `06-despliegue` crea la app de `jpackage` en la carpeta temporal del sistema: dentro de iCloud Drive la firma
  de macOS falla por los atributos extendidos de los archivos.
- Los tiempos del caché AOT dependen de la máquina; en la prueba (Intel i9, Temurin 25.0.4.1) bajaron de ~1,0 s a
  ~0,63 s por arranque.
- `08-quiz` reutiliza los módulos de 03, 04 y 05 (los compila si no existen).
