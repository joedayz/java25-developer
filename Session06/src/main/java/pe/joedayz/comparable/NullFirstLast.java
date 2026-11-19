package pe.joedayz.comparable;

import java.util.Arrays;
import java.util.Comparator;

class MyProducto {

    private String nombre;
    private double precio;

    public MyProducto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "MyProducto{nombre='" + nombre + "'}";
    }
}

public class NullFirstLast {

    static void main() {


        MyProducto[] productos = {
                new MyProducto("Laptop", 3000),
                new MyProducto(null, 1000),
                new MyProducto("Celular", 1500),
                new MyProducto("Audifonos", 200),
                new MyProducto(null, 500)
        };

        Comparator<MyProducto> porNombre =
                Comparator.comparing(
                        MyProducto::getNombre,
                        Comparator.nullsLast(Comparator.naturalOrder())
                );

        Arrays.sort(productos, porNombre);

        for (MyProducto producto : productos) {
            System.out.println(producto);
        }


    }
}
