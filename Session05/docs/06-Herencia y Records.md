# 06 - Herencia y Records

## ¿Qué se mantiene?

- herencia
- superclase y subclase
- polimorfismo
- reutilización de comportamiento
- jerarquías de clases e interfaces

## ¿Qué cambia entre Java 21 y Java 25?

La herencia sigue siendo un concepto central de Java. No desaparece ni se reemplaza.

Lo nuevo es que Java 25 ofrece herramientas para modelar mejor ciertos escenarios:

- `record` para representar datos inmutables de forma concisa
- `sealed` para cerrar jerarquías y controlar qué tipos pueden extenderlas
- `pattern matching` para manejar mejor tipos y estructuras

Importante: un `record` no sustituye la herencia; es una alternativa para datos transparentes y concretos.

## Antes vs ahora

### Antes

La herencia se usaba para modelar jerarquías abiertas:

```java
class Animal {
}

class Perro extends Animal {
}

class Gato extends Animal {
}
```

Esto permitía extender la jerarquía sin restricciones.

### Ahora en Java 25

```java
sealed interface Animal permits Perro, Gato {}

final class Perro implements Animal {}
final class Gato implements Animal {}
```

Aquí la jerarquía queda cerrada y controlada. Eso mejora seguridad del diseño y permite manejar casos específicos de forma más clara.

También puedes descomponer un `record` con patrones:

```java
record Persona(String nombre, int edad) {}

static void mostrar(Persona p) {
    if (p instanceof Persona(String nombre, int edad)) {
        System.out.println(nombre + " tiene " + edad + " años");
    }
}
```

## ¿Ha cambiado `this` y `super` en Java 25?

No. El significado de `this` y `super` no cambió.

- `this` sigue apuntando a la instancia actual.
- `super` sigue apuntando a la clase padre.
- `this.nombre` y `super.nombre` siguen teniendo el mismo concepto que antes.

Lo que sí cambió en Java 25 es una regla de constructores: ahora puedes ejecutar ciertas instrucciones antes de llamar a `super(...)` o `this(...)` en un constructor.

### Antes de Java 25

En un constructor, `super(...)` o `this(...)` tenía que ser la primera instrucción:

```java
class Employee extends Person {
    Employee(String name) {
        super(name); // tenía que ir primero
        System.out.println("Employee created");
    }
}
```

Esto no era válido:

```java
class Employee extends Person {
    Employee(String name) {
        validate(name); // ❌ antes de Java 25
        super(name);
    }
}
```

### Ahora en Java 25 (JEP 513)

La novedad es el JEP 513: Flexible Constructor Bodies.

```java
class Employee extends Person {
    Employee(String name) {
        String validated = validate(name);
        super(validated);
        System.out.println("Employee created");
    }
}
```

Esto permite validar argumentos y preparar valores antes de invocar al constructor de la superclase.

### Importante: todavía no puedes usar `this` antes de `super(...)`

Esto sigue prohibido, porque el objeto todavía no está completamente construido:

```java
class Employee extends Person {
    private String name;

    Employee(String name) {
        this.name = name; // ❌ NO
        super(name);
    }
}
```

Esto no es un cambio en el significado de `this`, sino una regla de inicialización del objeto.

La misma regla se aplica a `super`: no puedes acceder a la instancia completa antes de que la superclase haya terminado su construcción.

## Citas oficiales

- JEP 395: Records — https://openjdk.org/jeps/395
- JEP 409: Sealed Classes — https://openjdk.org/jeps/409
- JEP 440: Record Patterns — https://openjdk.org/jeps/440
- JEP 441: Pattern Matching for switch — https://openjdk.org/jeps/441
- JEP 513: Flexible Constructor Bodies — https://openjdk.org/jeps/513

## Frase para alumnos

“El significado de `this` y `super` no cambió; lo que cambió en Java 25 es la flexibilidad de cuándo puedes ejecutar código antes de invocar al constructor de la superclase.”

## Conclusión

Este tema sigue siendo clave en Java 25, pero ahora se puede explicar con un enfoque más moderno: la herencia y el polimorfismo siguen siendo bases del lenguaje, y las novedades más relevantes son `record`, `sealed`, `pattern matching` y la mayor flexibilidad en los constructores con JEP 513.
