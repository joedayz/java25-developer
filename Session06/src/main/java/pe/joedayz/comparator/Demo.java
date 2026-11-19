package pe.joedayz.comparator;

import java.util.Arrays;
import java.util.Comparator;

class Producto{

    private final String nombre;
    private final int precio;

    Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    String getNombre() {
        return nombre;
    }

    int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " " + precio;
    }

}

class OrderPrecio implements Comparator<Producto>{

    @Override
    public int compare(Producto o1, Producto o2) {
        return Integer.compare(o1.getPrecio(), o2.getPrecio());
    }
}



class OrderNombre implements Comparator<Producto>{

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}


public class Demo{

    static void main() {
        Producto[] productos = {
                new Producto("Té", 3),
                new Producto("Café", 5),
                new Producto("Café", 2),
                new Producto("Torta", 4)
        };
        Arrays.sort(productos, new OrderNombre());
        IO.println(Arrays.toString(productos));

        Arrays.sort(productos, new OrderPrecio());
        IO.println(Arrays.toString(productos));

        Arrays.sort(productos, Comparator.comparing(Producto::getNombre)
                .thenComparing(Producto::getPrecio));
        IO.println(Arrays.toString(productos));
    }

}
