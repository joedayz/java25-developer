package pe.joedayz.arraysandcollections;

import java.util.Arrays;

public class ArraysSamples {

    static void main() {
        // Ejemplo 1: llenar un array

        String[] values = new String[5];

        Arrays.fill(values, 2, 4, "aaa");

        System.out.println(Arrays.toString(values));

        // Ejemplo 2: búsqueda binaria
        int x = Arrays.binarySearch(values, "aaa");
        System.out.println("Posición encontrada: " + x);

        // Ejemplo 3: comparar arrays
        String[] names1 = {"Mary", "Ann", "John", "Tom"};
        String[] names2 = {"Miryan", "Ann", "Jane", "Tom"};

        boolean isTheSame = Arrays.equals(names1, names2);

        System.out.println("¿Son iguales? " + isTheSame);

        // Ejemplo 4: ordenar usando Comparable
        Arrays.sort(names2);

        System.out.println("Orden alfabético:");
        System.out.println(Arrays.toString(names2));

        // Ejemplo 5: ordenar usando Comparator
        Arrays.sort(names2, new LengthCompare());
        System.out.println("Orden por longitud:");
        System.out.println(Arrays.toString(names2));

        int[] valuesNum  = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        for (int i = 0; i < valuesNum.length; sum += i++);
        System.out.println("Sumatoria: " + sum);

    }
}


class LengthCompare implements java.util.Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}