package pe.joedayz.comparable;

public class Producto implements Comparable<Producto> {

    private final String nombre;


    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Producto o) {
      return this.nombre.compareTo(o.getNombre());
    }
}
