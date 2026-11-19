package pe.joedayz.cloneable;

public class Producto implements Cloneable {

    String nombre;
    int[] nums;

    Producto(String nombre, int[] nums) {
        this.nombre = nombre;
        this.nums = nums;
    }

    @Override
    public Producto clone() throws CloneNotSupportedException {
        return (Producto) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Producto p1 = new Producto("Té", new int[] {7});
        Producto p2 = p1.clone();

        IO.println(p1 != p2);


        p2.nombre = "Café";
        p2.nums[0] = 9;
        IO.println(p1.nombre + " " + p1.nums[0]);
        IO.println(p2.nombre + " " + p2.nums[0]);
    }


}

