package pe.joedayz.comparable;

import java.util.Arrays;

record Pedido(String nombre, int precio) implements Comparable<Pedido> {

    public Pedido{
        if(precio<0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        nombre = nombre.strip();
    }




    @Override
    public int compareTo(Pedido otro) {
        int porNombre = this.nombre.compareTo(otro.nombre);
        if(porNombre!=0){
            return porNombre;
        }
        return Integer.compare(this.precio, otro.precio);
    }


    static void main() {


        Pedido[] pedidos = {
            new Pedido("Pizza", 10),
            new Pedido("Hamburguesa", 8),
            new Pedido("Ensalada", 5),
            new Pedido("Pizza", 12)
        };

        Arrays.sort(pedidos);

        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }







        Producto[] productos = {

            new Producto("Coca Cola"),
            new Producto("Pepsi"),
            new Producto("Fanta"),
            new Producto("Sprite")
        };

        Arrays.sort(productos);

        for (Producto producto : productos) {
            System.out.println(producto.getNombre());
        }
    }


}
