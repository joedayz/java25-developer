# 03 - Tipos primitivos, operadores y sentencias de control de flujo

## ¿Qué se mantiene?

- tipos primitivos: `int`, `double`, `boolean`, `char`, etc.
- operadores aritméticos, relacionales y lógicos
- conversiones y casting
- `if`, `else`, `switch`, bucles `for`, `while`, `do-while`
- la lógica de control del programa

## ¿Qué cambia entre Java 21 y Java 25?

En este tema, casi no cambia nada a nivel semántico.

- Los tipos primitivos siguen siendo los mismos: `int`, `double`, `boolean`, `char`, etc.
- Los operadores siguen siendo los mismos.
- `if`, `else`, `for`, `while`, `switch` clásico siguen funcionando igual.
- La lógica de control de flujo no cambia.

Lo único relevante para Java 25 es una evolución moderna del `switch`: `pattern matching`.

Esto no cambia cómo se enseña el flujo básico, pero sí ofrece una forma más expresiva de decidir según el tipo de valor o según varios casos.

### No cambia en este PDF

- `int`, `double`, `boolean`, `char`
- operadores aritméticos, relacionales y lógicos
- casting
- bucles y condiciones clásicas
- la base del control de flujo

### Sí cambia modernamente

El JEP 441 permite usar `switch` con patrones, no solo con valores constantes.

Esto es una mejora de estilo y expresividad, no un cambio de la lógica fundamental.

### Ejemplo de Java 25: `switch` con pattern matching

Antes, si queríamos evaluar un objeto y actuar según su tipo, normalmente hacíamos cadenas largas de `if`/`else if`:

```java
static String formatear(Object valor) {
    if (valor instanceof Integer i) {
        return "entero: " + i;
    } else if (valor instanceof Long l) {
        return "largo: " + l;
    } else if (valor instanceof Double d) {
        return "decimal: " + d;
    } else if (valor instanceof String s) {
        return "texto: " + s;
    } else {
        return "tipo desconocido";
    }
}
```

Con `switch` + pattern matching del JEP 441, el mismo caso puede expresarse de forma más clara:

```java
static String formatear(Object valor) {
    return switch (valor) {
        case Integer i -> "entero: " + i;
        case Long l -> "largo: " + l;
        case Double d -> "decimal: " + d;
        case String s -> "texto: " + s;
        default -> "tipo desconocido";
    };
}
```

### Ejemplo con números

```java
static String analizarNumero(Number n) {
    return switch (n) {
        case Integer i -> "Es un entero: " + i;
        case Double d -> "Es un decimal: " + d;
        case Float f -> "Es un float: " + f;
        default -> "Otro tipo numérico";
    };
}
```

### Ejemplo con `enum`

```java
enum Dia { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES }

static String diaInfo(Dia dia) {
    return switch (dia) {
        case LUNES -> "Inicio de semana";
        case VIERNES -> "Fin de semana laboral";
        case MARTES, MIERCOLES, JUEVES -> "Día laborable";
    };
}
```

## JEPs relevantes

### Otra novedad que aplica aquí: variables sin nombre (JEP 456, desde Java 22)

Cuando una variable es obligatoria por sintaxis pero no la vas a usar, ahora puedes usar `_`:

Antes:

```java
int contador = 0;
for (String elemento : lista) {   // "elemento" no se usa
    contador++;
}
```

Ahora en Java 25:

```java
int contador = 0;
for (String _ : lista) {
    contador++;
}
```

También en `catch` y en patrones:

```java
try {
    int numero = Integer.parseInt(texto);
} catch (NumberFormatException _) {   // no necesitamos la excepción
    IO.println("No es un número");
}
```

```java
switch (obj) {
    case Punto(int x, int _) -> IO.println("x = " + x);  // ignoramos y
    default -> IO.println("otro");
}
```

### Nota: primitivos en patrones (preview en Java 25)

El JEP 507 (tercera preview en 25) permitirá usar tipos primitivos en `instanceof` y `switch` con patrones, por ejemplo `case int i ->`. Aún es preview, así que menciónalo solo como "lo que viene", no como material del examen.

## JEPs relevantes

- JEP 441: Pattern Matching for switch — https://openjdk.org/jeps/441
- JEP 394: Pattern Matching for instanceof — https://openjdk.org/jeps/394
- JEP 456: Unnamed Variables & Patterns — https://openjdk.org/jeps/456
- JEP 507: Primitive Types in Patterns (preview) — https://openjdk.org/jeps/507

## Frase para alumnos

“En este tema, los tipos primitivos y el control de flujo no cambian; lo que sí aparece en Java moderno es el `switch` con patrones y las variables sin nombre `_` para código más limpio.”

## Conclusión

Para el PDF 03, la conclusión es clara: no hay un cambio estructural en tipos primitivos ni en el control de flujo. Las novedades reales son `pattern matching` para `switch` (JEP 441) y las variables sin nombre `_` (JEP 456), que mejoran la expresividad sin cambiar la base que los alumnos deben aprender primero.
