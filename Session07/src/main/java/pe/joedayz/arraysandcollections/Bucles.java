package pe.joedayz.arraysandcollections;

import java.util.Arrays;

public class Bucles {

    static void main() {
        int i = 0;
        while (i < 3) {
            IO.print(i);
            i++;
        }
        IO.println();



        int j = 5;
        do {
            IO.println("do " + j);
            j++;
        } while (j < 3);


        int[] valores = {1, 2, 3};
        for (int v : valores) {
            v = v * 10;
        }
        IO.println(Arrays.toString(valores));
        valores[0] = 10;
        IO.println(Arrays.toString(valores));

        int n = 0;
        for (var _ : valores) {
            n++;
        }
        IO.println("cuenta " + n);


        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int suma = 0;
        for (int k = 0; k < nums.length; suma += nums[k++]) {
        }
        IO.println("suma " + suma);

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        var diagonal = new StringBuilder();
        for (int f = 0, c = 2; f < 3 && c >= 0; f++, c--) {
            diagonal.append(matriz[f][c]).append(' ');
        }
        IO.println(diagonal);





        char[][] letras = {
                {'A', 'B', 'C', 'D', 'E'},
                {'F', 'G', 'H', 'I', 'K'},
                {'L', 'M', 'N', 'O', 'P'},
                {'Q', 'R', 'S', 'T', 'U'},
                {'V', 'W', 'X', 'Y', 'Z'}
        };
        var txt = new StringBuilder();
        EXTERIOR:
        for (char[] fila : letras) {
            for (char valor : fila) {
                if (valor == 'C') {
                    continue;
                }
                if (valor == 'H') {
                    continue EXTERIOR;
                }
                if (valor == 'N') {
                    break;
                }
                if (valor == 'S') {
                    break EXTERIOR;
                }
                txt.append(valor);
            }
            txt.append('\n');
        }
        IO.println("---");
        IO.println(txt);

        String[] names = {"Mary", "Jane", "Ann", "Tom"};
        int p = 0;
        String name = null;
        while (names.length > p) {
            ++p;
            if (names[p].length() == 3)
                if (names[p].indexOf("a") == -1) {
                    break;
                }
            name = names[p];
            continue;
        }
        IO.println("quiz " + name);
        IO.println("Ann a=" + "Ann".indexOf("a") + " A=" + "Ann".indexOf("A"));

        String[] orden = {"Mary", "Jane", "Elizabeth", "Jo"};
        Arrays.sort(orden, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        IO.println(Arrays.toString(orden));
    }
}
