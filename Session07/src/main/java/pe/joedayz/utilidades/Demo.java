package pe.joedayz.utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

    static void main() {
        var menu = new ArrayList<>(List.of("Café", "Té", "Torta"));
        Collections.fill(menu, "Agua");
        IO.println("fill " + menu + " size " + menu.size());


        menu = new ArrayList<>(List.of("Té", "Café", "Torta"));
        Collections.sort(menu);
        IO.println("sort " + menu);

        IO.println("busca Torta " + Collections.binarySearch(menu, "Torta"));
        IO.println("busca Agua " + Collections.binarySearch(menu, "Agua"));

        var desorden = new ArrayList<>(List.of("Té", "Café", "Torta"));
        IO.println("sin orden " + Collections.binarySearch(desorden, "Café"));

        Collections.reverse(menu);
        IO.println("reverse " + menu);


        try {
            Collections.reverse(List.of("Café", "Té"));
        } catch (UnsupportedOperationException e) {
            IO.println("reverse of " + e.getClass().getSimpleName());
        }


    }
}
