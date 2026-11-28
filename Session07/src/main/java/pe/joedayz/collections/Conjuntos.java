package pe.joedayz.collections;

import java.util.*;

public class Conjuntos {

    static void main() {
        var menu = new LinkedHashSet<Producto>();
        var cafe = new Producto("Café");


        menu.add(cafe);
        menu.add(new Producto("Té"));
        menu.add(new Producto("Café"));
        IO.println(menu);
        IO.println(menu.add(new Producto("Café")));
        IO.println(menu.remove(new Producto("Té")));
        IO.println(menu.contains(cafe));


        try {
            Set.of("Café", "Café");
        } catch (IllegalArgumentException e) {
            IO.println("of dup " + e.getClass().getSimpleName());
        }


        try {
            Set.of("Café", null);
        } catch (NullPointerException e) {
            IO.println("of null " + e.getClass().getSimpleName());
        }


        var hash = new HashSet<Producto>();
        hash.add(new Producto("Café"));
        hash.add(null);
        IO.println("hash null " + hash.contains(null) + " size " + hash.size());


        var arbol = new TreeSet<String>();
        arbol.add("Té");
        arbol.add("Café");
        arbol.add("Torta");
        IO.println(arbol);

        try {
            arbol.add(null);
        } catch (NullPointerException e) {
            IO.println("tree null " + e.getClass().getSimpleName());
        }


        try {
            var rotos = new TreeSet<Caja>();
            rotos.add(new Caja("A"));
        } catch (ClassCastException e) {
            IO.println(e.getClass().getSimpleName());
        }
    }
}



class Producto implements Comparable<Producto> {
    final String nombre;

    Producto(String nombre) {
        this.nombre = nombre;
    }

    public int compareTo(Producto otro) {
        return nombre.compareTo(otro.nombre);
    }

    public boolean equals(Object o) {
        return o instanceof Producto p && nombre.equals(p.nombre);
    }

    public int hashCode() {
        return Objects.hash(nombre);
    }

    public String toString() {
        return nombre;
    }
}

class Caja {
    final String nombre;
    Caja(String nombre) { this.nombre = nombre; }
}