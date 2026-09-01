package pe.joedayz.arraysandcollections;

import java.util.Arrays;

public class CopyArrays {

    static void main() {
        char[] a1 = {'a', 'c', 'm', 'e'};

        // Array destino
        char[] a2 = {'t', 'o', ' ', ' ', ' '};

        // Copiar desde a1 hacia a2
        System.arraycopy(a1, 2, a2, 3, 2);


        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));


        //

        char[] b1 = {'a', 'c', 'm', 'e'};

        // Crear un nuevo array de tamaño 5
        char[] b2 = Arrays.copyOf(b1, 5);

        System.out.println(Arrays.toString(b2));

        // Range

        char[] c1 = {'a', 'c', 'm', 'e'};
        char[] c2 = Arrays.copyOfRange(c1, 1, 3);
        System.out.println(Arrays.toString(c2));

        // java 25 - getChars() de CharSequence
        CharSequence text = "Hola Mundo";

        char[] destination = new char[10];

        text.getChars(0, 4, destination, 0);

        System.out.println(destination);


    }
}
