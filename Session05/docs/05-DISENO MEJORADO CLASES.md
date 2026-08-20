# 05 - Diseño de Clases Mejorado

## ¿Qué se mantiene?

- encapsulación
- validación de datos
- sobrecarga y sobreescritura
- diseño orientado a objetos
- uso de enums para tipos cerrados

## ¿Qué cambia entre Java 21 y Java 25?

Se mantiene la parte conceptual de diseño. El cambio real es que Java moderno ofrece herramientas más expresivas para modelar jerarquías y datos.

### Cambios relevantes

- `record`: reduce boilerplate para objetos inmutables de datos
- `sealed`: limita qué clases pueden heredar o implementar una abstracción
- `pattern matching`: hace más legible la comprobación de tipos y el manejo de objetos

## Antes vs ahora

### Antes

Cuando queríamos comprobar varios tipos, normalmente escribíamos cadenas largas de `if`/`else if`:

```java
static String formatear(Object valor) {
    if (valor instanceof Integer i) {
        return "entero: " + i;
    } else if (valor instanceof Long l) {
        return "largo: " + l;
    } else if (valor instanceof Double d) {
        return "decimal: " + d;
    } else {
        return "otro tipo";
    }
}
```

### Ahora en Java 25

```java
static String formatear(Object valor) {
    return switch (valor) {
        case Integer i -> "entero: " + i;
        case Long l -> "largo: " + l;
        case Double d -> "decimal: " + d;
        default -> "otro tipo";
    };
}
```

Esto es más claro y más seguro, especialmente cuando hay varios tipos posibles.

### Novedad de Java 25 para validación: JEP 513 (Flexible Constructor Bodies)

Este tema habla de validación de datos en el diseño de clases, y aquí Java 25 sí trae un cambio real: ahora puedes validar argumentos antes de llamar a `super(...)`.

Antes (la validación se hacía después, o con un truco de método estático):

```java
class Empleado extends Persona {
    Empleado(String nombre, int edad) {
        super(nombre, edad);            // trabajo potencialmente innecesario
        if (edad < 18 || edad > 67)
            throw new IllegalArgumentException("Edad inválida");
    }
}
```

Ahora en Java 25 (fail-fast, más natural):

```java
class Empleado extends Persona {
    Empleado(String nombre, int edad) {
        if (edad < 18 || edad > 67)
            throw new IllegalArgumentException("Edad inválida");
        super(nombre, edad);
    }
}
```

Esto mejora el diseño: se falla rápido, sin ejecutar el constructor padre con datos inválidos.

## Citas oficiales

- JEP 395: Records — https://openjdk.org/jeps/395
- JEP 409: Sealed Classes — https://openjdk.org/jeps/409
- JEP 440: Record Patterns — https://openjdk.org/jeps/440
- JEP 441: Pattern Matching for switch — https://openjdk.org/jeps/441
- JEP 513: Flexible Constructor Bodies — https://openjdk.org/jeps/513

## Frase para alumnos

“Java 25 no te obliga a cambiar cómo diseñas clases; te da herramientas más limpias para modelar mejor tus dominios.”

## Conclusión

Este tema sigue siendo esencial, y Java 25 lo hace más expresivo. La base del diseño orientado a objetos no cambia, pero sí el estilo de implementación moderno.
