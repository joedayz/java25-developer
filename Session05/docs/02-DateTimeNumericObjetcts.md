# 02 - Text, Date, Time y objetos numéricos

## ¿Qué se mantiene?

- `LocalDate`, `LocalDateTime`, `LocalTime`
- `Period`, `Duration`
- `BigDecimal` y `BigInteger`
- manejo de fechas, horas y cálculos numéricos
- uso de tipos adecuados según el problema

## ¿Qué cambia entre Java 21 y Java 25?

La base no cambia. En Java 21 y Java 25, la recomendación sigue siendo usar `java.time` en vez de `Date`/`Calendar`, porque es más clara, más segura y más expresiva.

Lo que sí cambia es la forma de hablar del tema: no se presentan como “novedades”, sino como la API estándar y moderna para trabajar con fechas, horas y números grandes.

## Antes vs ahora

### Antes

```java
import java.util.Date;

Date hoy = new Date();
System.out.println(hoy);
```

Este estilo era muy común, pero tenía varios problemas: mutabilidad, mala claridad y más complejidad al manejar zonas horarias o cálculos de tiempo.

### Ahora en Java 25

```java
import java.time.LocalDate;
import java.time.LocalDateTime;

LocalDate hoy = LocalDate.now();
LocalDateTime ahora = LocalDateTime.now();

System.out.println(hoy);
System.out.println(ahora);
```

Esto es más claro, más seguro y más expresivo. La API recomendada sigue siendo `java.time`.

## Frase para alumnos

“Lo importante no es que Java 25 haya reinventado las fechas o los números grandes; lo importante es que la API moderna sigue siendo la recomendada.”

## Cita oficial

- JDK 25: https://openjdk.org/projects/jdk/25/
- `java.time` sigue siendo la API estándar de fecha y hora en la plataforma Java moderna.

## Conclusión

Este tema sigue siendo totalmente válido para Java 25. No es un cambio conceptual; es un refinamiento del estilo y de la práctica recomendada.
