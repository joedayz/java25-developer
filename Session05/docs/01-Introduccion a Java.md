# 01 - Introducción a Java

## ¿Qué se mantiene?

- JVM, JRE y JDK
- compilación con `javac`
- ejecución con `java`
- sintaxis básica de Java
- clases, `main`, paquetes y flujo de ejecución
- la idea de “escribir una vez, ejecutar en cualquier lugar”

## ¿Qué cambia entre Java 21 y Java 25?

Aquí sí hay una novedad grande para la enseñanza: Java 25 finalizó el JEP 512 (Compact Source Files and Instance Main Methods), que cambia cómo se escribe el primer programa en Java.

### Antes de Java 25: el clásico "Hello World"

Para el primer programa, había que explicar `class`, `public`, `static`, `void`, `String[] args`... todo antes de la primera línea útil:

```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}
```

### Ahora en Java 25 (JEP 512)

Un programa puede ser un archivo fuente compacto, sin declarar la clase y con un `main` de instancia mucho más simple:

```java
void main() {
    IO.println("Hola Mundo");
}
```

Puntos clave:

- ya no es obligatorio declarar la clase
- `main` puede ser de instancia, sin `static`, sin `public` y sin `String[] args`
- la nueva clase `java.lang.IO` ofrece `IO.println(...)` y `IO.readln(...)` sin imports
- se ejecuta directo: `java HolaMundo.java`

Esto NO reemplaza la forma clásica: el `main` tradicional sigue funcionando igual y sigue siendo necesario entenderlo. Pero cambia cómo puedes introducir Java a un principiante.

### También desde Java 22: ejecutar programas de varios archivos sin compilar

El JEP 458 permite ejecutar programas de varios archivos fuente directamente:

```bash
java Main.java
```

sin necesidad de compilar antes con `javac` (el compilador se invoca internamente). Útil para prototipos y para enseñar sin hablar de `javac` el primer día.

### Y en Java 25: imports de módulos (JEP 511)

```java
import module java.base;

void main() {
    List<String> nombres = List.of("Ana", "José");
    IO.println(nombres);
}
```

`import module java.base;` importa de golpe todos los paquetes exportados por ese módulo (List, Map, Stream, etc.), sin escribir un import por clase. En archivos fuente compactos, `java.base` se importa implícitamente.

## Frase para alumnos

“En Java 25 el ‘Hello World’ por fin es corto: `void main()` y `IO.println()`. La forma clásica sigue existiendo y hay que conocerla, pero ya no es la única puerta de entrada.”

## Citas oficiales

- JDK 25: https://openjdk.org/projects/jdk/25/
- JEP 512: Compact Source Files and Instance Main Methods — https://openjdk.org/jeps/512
- JEP 511: Module Import Declarations — https://openjdk.org/jeps/511
- JEP 458: Launch Multi-File Source-Code Programs — https://openjdk.org/jeps/458

## Conclusión

Los conceptos base (JVM, JDK, compilar, ejecutar) siguen iguales, pero esta unidad sí tiene un cambio real que vale la pena enseñar: el JEP 512 simplifica el primer programa en Java 25. Recomendación didáctica: empezar con `void main()` + `IO.println()`, y luego presentar la forma clásica completa como “lo que hay detrás”.
