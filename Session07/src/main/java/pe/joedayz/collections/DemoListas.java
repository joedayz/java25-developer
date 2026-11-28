package pe.joedayz.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoListas {

    static void main() {

        var menu = new ArrayList<String>();
        menu.add("Café");
        menu.add("Té");
        menu.add(1, "Torta");
        menu.set(0, "Agua");

        IO.println(menu);
        IO.println(menu.remove("Té"));
        IO.println(menu.contains("Torta") + " " + menu.indexOf("Torta") + " " + menu.get(0));


        try {
            menu.add(9, "X");
        } catch (IndexOutOfBoundsException e) {
            IO.println(e.getClass().getSimpleName());
        }

        String[] base = {"Café", "Té"};
        List<String> vista = Arrays.asList(base);
        vista.set(0, "Torta");
        IO.println(Arrays.toString(base));
        try {
            vista.add("Agua");
        } catch (UnsupportedOperationException e) {
            IO.println("asList add " + e.getClass().getSimpleName());
        }

        List<String> fija = List.of("Café", "Té");
        try {
            fija.set(0, "Agua");
        } catch (UnsupportedOperationException e) {
            IO.println("of set " + e.getClass().getSimpleName());
        }
        try {
            List.of("Café", null);
        } catch (NullPointerException e) {
            IO.println("of null " + e.getClass().getSimpleName());
        }


        var mutable = new ArrayList<>(List.of("Café"));
        var copia = List.copyOf(mutable);

        var soloLectura = Collections.unmodifiableList(mutable);
        mutable.add("Té");
        IO.println("copia "+ copia);
        IO.println("vista "+ soloLectura);

        try {
            menu.getFirst();
            var vacia = new ArrayList<String>();
            vacia.getFirst();
        } catch (java.util.NoSuchElementException e) {
            IO.println(e.getClass().getSimpleName());
        }
        menu.addFirst("Primero");
        menu.addLast("Último");
        IO.println(menu.getFirst() + " " + menu.getLast());

    }
}
