package pe.joedayz.arraysandcollections;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        int[] primos = new int[3];
        String[] nombres = new String[3];
        boolean[] flags = new boolean[2];

        IO.println(primos[0] + " " + nombres[0] + " " + flags[0] + " len=" + primos.length);

        int[] valores = {2, 3, 5};
        int[] copia = Arrays.copyOf(valores, 5);
        int[] rango = Arrays.copyOfRange(valores, 1, 3);
        int[] destino = new int[3];
        System.arraycopy(valores, 0, destino, 1, 2);
        IO.println(Arrays.toString(copia));
        IO.println(Arrays.toString(rango));
        IO.println(Arrays.toString(destino));

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] irregular = {{1, 2}, {3}, {4, 5, 6}};
        IO.println(matriz.length + "x" + matriz[0].length + " " + irregular[1].length);

        String[] a = {"Mary", "Ann", "Jane", "Tom"};
        String[] b = {"Mary", "Ann", "John", "Tom"};
        IO.println(Arrays.equals(a, b));
        String[] natural = b.clone();
        Arrays.sort(natural);
        IO.println(Arrays.toString(natural));
        String[] porLargo = b.clone();
        Arrays.sort(porLargo, new LengthComparator());
        IO.println(Arrays.toString(porLargo));

        int[] ordenados = {2, 3, 5, 7};
        IO.println(Arrays.binarySearch(ordenados, 5));
        IO.println(Arrays.binarySearch(ordenados, 4));

        String[] huecos = new String[5];
        Arrays.fill(huecos, 2, 4, "aaa");
        IO.println(Arrays.toString(huecos));
        IO.println(Arrays.binarySearch(huecos, 2, 4 , "aaa"));


        IO.println(Arrays.compare(new int[] {1, 2}, new int[] {1, 3}));
        IO.println(Arrays.mismatch(new int[] {1, 2, 3}, new int[] {1, 9, 3}));
        IO.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1, 2}));


        Comida[] comidas = {new Comida("Torta")};
        Producto[] productos = comidas;
        try {
            productos[0] = new Bebida("Té");
            IO.println("no lanzo");
        } catch (ArrayStoreException e) {
            IO.println(e.getClass().getSimpleName());
        }

        record Resena(int estrellas) { }
        Resena[] resenas = {new Resena(5), new Resena(3), new Resena(4)};
        int suma = 0;
        for (var r : resenas) {
            suma += r.estrellas();
        }
        IO.println((double) suma / resenas.length);


    }
}

class LengthComparator implements java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}


class Producto {
    final String nombre;
    Producto(String nombre) { this.nombre = nombre; }
}

class Comida extends Producto {
    Comida(String nombre) { super(nombre); }
}

class Bebida extends Producto {
    Bebida(String nombre) { super(nombre); }
}