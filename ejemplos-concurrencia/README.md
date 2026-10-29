# Ejemplos de concurrencia (Java 25)

Ejemplos organizados por tema, pensados para recorrerse en orden: de hilos básicos
a las novedades de Java 25 (Structured Concurrency, Scoped Values).

## Cómo ejecutarlos

El repo mezcla dos tipos de archivo, y cada uno se ejecuta distinto:

| Carpeta | Tipo de archivo | Cómo correrlo |
|---|---|---|
| `01-hilos` → `05-seguridad` | Clases normales (`package demos;`) | Módulo Maven (`pom.xml`); cada carpeta numerada queda como *source root* |
| `06-java25`, `07-quiz` | *Compact source files* (sin clase, `void main()`) | Script `./run.sh` (lanzamiento de archivo único) |

Las carpetas numeradas (`01-hilos`, `02-monitores`...) se mantienen tal cual para
conservar el orden de los temas al navegar el proyecto; `pom.xml` usa
`build-helper-maven-plugin` para registrarlas como *source roots* de Maven, en
vez de mover los archivos a `src/main/java`.

### 01-hilos → 05-seguridad (Maven)

```bash
mvn compile
java -cp target/classes demos.CrearHilos   # o la clase que quieras probar
```

O ábrelo en tu IDE como proyecto Maven (`pom.xml` en la raíz) y corre cada clase con el botón ▶.

### 06-java25 y 07-quiz (run.sh)

```bash
./run.sh 06-java25/ScopedValues.java          # un archivo puntual
./run.sh                                      # todos los de 06-java25 y 07-quiz, en orden
```

`run.sh` ejecuta cada archivo con `java --source 25 --enable-preview <archivo>.java`.
Solo **`ConcurrenciaEstructurada.java`** necesita realmente `--enable-preview`
(usa `StructuredTaskScope`, JEP 505, aún en preview); el resto de `06-java25` y
`07-quiz` ya corre sin esa bandera en Java 25, pero se deja por uniformidad.

## Orden sugerido de los ejemplos

### 01-hilos — Fundamentos de hilos
| # | Archivo | Qué muestra |
|---|---|---|
| 1 | `Conceptos.java` | Qué es un hilo: varios ejecutan la misma tarea mientras `main` sigue con lo suyo. |
| 2 | `CrearHilos.java` | Formas de crear un hilo: `extends Thread`, `Runnable`, lambda, `Thread.Builder` (plataforma y virtual). |
| 3 | `CicloDeVida.java` | Estados de `Thread.State`: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED. |
| 4 | `Propiedades.java` | Propiedades comunes de un hilo: nombre, ID, daemon, prioridad, `join`. |
| 5 | `Interrupcion.java` | Cómo interrumpir un hilo y cómo debe reaccionar `run()` a la señal. |

### 02-monitores — Sincronización
| # | Archivo | Qué muestra |
|---|---|---|
| 6 | `Sincronizacion.java` | `synchronized` evita condiciones de carrera al incrementar un contador compartido. |
| 7 | `WaitNotify.java` | `wait`/`notify` dentro de un monitor; `IllegalMonitorStateException` si no se usan dentro de `synchronized`. |

### 03-executors — Pools de hilos
| # | Archivo | Qué muestra |
|---|---|---|
| 8 | `TiposExecutor.java` | Tipos de `ExecutorService` que crea `Executors` (programado, fijo...). |
| 9 | `TareasCallable.java` | Tareas `Callable` que devuelven un valor envuelto en `Future`. |
| 10 | `CicloExecutor.java` | Ciclo de vida de un `ExecutorService`: enviar tareas, `shutdown`, esperar, forzar parada. |

### 04-virtuales — Hilos virtuales (Java 21+)
| # | Archivo | Qué muestra |
|---|---|---|
| 11 | `HilosVirtuales.java` | Hilos virtuales: ligeros, montados sobre pocos hilos de plataforma ("carriers"). |
| 12 | `SinPinning.java` | Java 24+ (JEP 491): un hilo virtual bloqueado en `synchronized` ya no fija ("pin") su carrier. |

### 05-seguridad — Concurrencia segura
| # | Archivo | Qué muestra |
|---|---|---|
| 13 | `Volatile.java` | `volatile` garantiza visibilidad entre hilos (sin él, el bucle puede no terminar). |
| 14 | `Atomicos.java` | `java.util.concurrent.atomic`: operaciones CAS sin candados. |
| 15 | `Locks.java` | `java.util.concurrent.locks`: `tryLock`, timeout, interrupción, `ReadWriteLock`. |
| 16 | `Colecciones.java` | Colecciones concurrentes seguras para varios hilos sin sincronizar a mano. |
| 17 | `Deadlock.java` | Deadlock por tomar dos candados en orden inverso; solución: orden consistente o `tryLock` con timeout. |

### 06-java25 — Novedades de Java 25
| # | Archivo | Qué muestra |
|---|---|---|
| 18 | `ScopedValues.java` | Scoped Values (JEP 506, final en Java 25): comparten datos inmutables con hilos hijos sin pasarlos como parámetro. |
| 19 | `ConcurrenciaEstructurada.java` | Structured Concurrency (JEP 505, preview): agrupa subtareas en un scope que se cancela/espera como unidad. |

### 07-quiz — Autoevaluación
| # | Archivo | Pregunta |
|---|---|---|
| 20 | `Quiz1.java` | ¿En qué estado está un hilo que ejecuta `Thread.sleep(1000)`? |
| 21 | `Quiz2.java` | ¿Qué ocurre al iniciar dos veces el mismo `Thread`? |
| 22 | `Quiz3.java` | ¿Qué pasa con `wait`/`notify` fuera de un bloque `synchronized`? |
| 23 | `Quiz4.java` | ¿Qué ocurre al enviar una tarea después de `shutdown()`? |
| 24 | `Quiz5.java` | ¿Qué propiedades de los hilos virtuales son distintas a las de plataforma? |
| 25 | `Quiz6.java` | ¿Por qué `volatile` no hace atómico a `count++`? |
| 26 | `Quiz7.java` | Scoped Values: comportamiento final en Java 25 (no necesita `--enable-preview`). |
