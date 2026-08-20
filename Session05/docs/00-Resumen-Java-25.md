# Resumen de cambios: Java 21 a Java 25

## Idea clave

Para un curso de fundamentos, Java 25 no rompe los conceptos básicos de Java 21. Lo que cambia no es la programación orientada a objetos ni el flujo de aprendizaje, sino la forma más moderna de escribir y modelar soluciones.

## En resumen

- Se mantiene casi todo lo que enseñas en este curso.
- La base de clases, herencia, tipos primitivos, fechas y numerics sigue igual.
- Java 25 es una versión LTS que consolida avances que ya venían desde Java 16–21.

## Novedades reales de lenguaje entre Java 21 y Java 25 (verificadas en OpenJDK)

Estos son los únicos JEPs de lenguaje finalizados entre 21 y 25, y dónde aplican en el curso:

| JEP | Novedad | Versión | Aplica al PDF |
|-----|---------|---------|---------------|
| JEP 512 | Compact Source Files e Instance Main Methods (`void main()`, `IO.println`) | 25 | 01 |
| JEP 513 | Flexible Constructor Bodies (código antes de `super()`/`this()`) | 25 | 04, 05, 06 |
| JEP 511 | Module Import Declarations (`import module java.base;`) | 25 | 01 |
| JEP 456 | Unnamed Variables & Patterns (`_`) | 22 | 03 |
| JEP 458 | Launch Multi-File Source-Code Programs | 22 | 01 |

Y en preview (mencionar como "lo que viene", no material de examen):

- JEP 507: Primitive Types in Patterns, instanceof, and switch (3rd preview, 25) → PDF 03

Consolidado desde Java 16–21 (ya estable, estilo moderno):

- `record` (JEP 395), `sealed` (JEP 409), record patterns (JEP 440), pattern matching for switch (JEP 441), pattern matching for instanceof (JEP 394)

## Fuentes oficiales

- JDK 25: https://openjdk.org/projects/jdk/25/
- JEPs desde JDK 21: https://openjdk.org/projects/jdk/25/jeps-since-jdk-21
- JEP 512: https://openjdk.org/jeps/512
- JEP 513: https://openjdk.org/jeps/513
- JEP 511: https://openjdk.org/jeps/511
- JEP 456: https://openjdk.org/jeps/456
- JEP 458: https://openjdk.org/jeps/458
- JEP 394: https://openjdk.org/jeps/394
- JEP 395: https://openjdk.org/jeps/395
- JEP 409: https://openjdk.org/jeps/409
- JEP 440: https://openjdk.org/jeps/440
- JEP 441: https://openjdk.org/jeps/441

## Frase para decir en clase

“Java 25 no cambia la base del lenguaje que estamos enseñando; consolida herramientas modernas que hacen el código más expresivo, seguro y limpio.”

## Siguientes documentos

- [01-Introduccion a Java.md](./01-Introduccion%20a%20Java.md)
- [02-DateTimeNumericObjetcts.md](./02-DateTimeNumericObjetcts.md)
- [03-TiposPrimitivos.md](./03-TiposPrimitivos.md)
- [04-Java Clases.md](./04-Java%20Clases.md)
- [05-DISENO MEJORADO CLASES.md](./05-DISENO%20MEJORADO%20CLASES.md)
- [06-Herencia y Records.md](./06-Herencia%20y%20Records.md)
