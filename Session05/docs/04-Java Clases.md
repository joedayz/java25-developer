# 04 - Clases

## ¿Qué se mantiene?

- una clase define una plantilla para objetos
- atributos, métodos y constructores
- instanciación con `new`
- encapsulación y acceso a propiedades
- relación entre objeto y su estado

## ¿Qué cambia entre Java 21 y Java 25?

La idea de clases no cambia. Sigue siendo el concepto más básico de Java.

Lo que sí aparece en Java moderno es que hay herramientas adicionales para modelar datos con menos boilerplate, por ejemplo `record`, pero esto no reemplaza la clase tradicional ni elimina el aprendizaje del diseño de objetos.

## Antes vs ahora

### Antes

Una clase tradicional para un punto con dos datos suele requerir mucho boilerplate:

```java
class Punto {
    private final int x;
    private final int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
```

### Ahora en Java 25

```java
record Punto(int x, int y) {}
```

Esto hace el mismo papel con menos código y sin perder claridad. Es ideal cuando la clase existe para transportar datos.

### Novedad de Java 25 en constructores: JEP 513

Java 25 finalizó el JEP 513 (Flexible Constructor Bodies). Ahora un constructor puede ejecutar instrucciones antes de invocar `this(...)`:

Antes:

```java
class Producto {
    private final String nombre;
    private final double precio;

    Producto(String nombre) {
        this(nombre, 0.0);  // tenía que ser la primera instrucción
    }

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
```

Ahora en Java 25 puedes validar o preparar valores antes:

```java
class Producto {
    private final String nombre;
    private final double precio;

    Producto(String nombre) {
        String limpio = nombre.trim();  // ✅ válido en Java 25
        this(limpio, 0.0);
    }

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
```

Restricción: antes de `this(...)` o `super(...)` no puedes usar `this` para acceder a la instancia, porque el objeto aún no está construido.

## Citas oficiales

- JEP 395: Records — https://openjdk.org/jeps/395
- JEP 409: Sealed Classes — https://openjdk.org/jeps/409
- JEP 440: Record Patterns — https://openjdk.org/jeps/440
- JEP 513: Flexible Constructor Bodies — https://openjdk.org/jeps/513

## Frase para alumnos

“Las clases siguen siendo la base de la orientación a objetos; `record` y `sealed` son mejoras para ciertos casos, no una sustitución del paradigma.”

## Conclusión

La unidad de clases se mantiene casi intacta en Java 25. La evolución llega en el diseño de modelos de datos y en la forma más expresiva y segura de modelar jerarquías y objetos.
