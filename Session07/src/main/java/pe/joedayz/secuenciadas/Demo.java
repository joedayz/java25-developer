package pe.joedayz.secuenciadas;

import java.util.*;

public class Demo {

    static void main() {
        var lista = new ArrayList<>(List.of("Café", "Té", "Torta"));
        lista.addFirst("Agua");
        lista.addLast("Jugo");
        IO.println(lista.getFirst() + " " + lista.getLast());
        IO.println(lista.reversed());
        lista.reversed().set(0, "Zumo");
        IO.println(lista);



        var set = new LinkedHashSet<String>();
        set.add("Uno");
        set.add("Dos");
        set.addFirst("Cero");
        IO.println(set);
        set.removeLast();
        IO.println(set);



        var map = new LinkedHashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.putFirst("C", 3);
        IO.println(map);
        IO.println(map.reversed());
        map.reversed().putFirst("D", 4);
        IO.println(map);


        var arbol = new TreeSet<>(List.of("Café", "Té", "Torta"));
        IO.println(arbol);
        IO.println(arbol.reversed());

        try {
            arbol.addFirst("Agua");
        } catch (UnsupportedOperationException e) {
            IO.println("tree addFirst " + e.getClass().getSimpleName());
        }


        IO.println("hash set sequenced " + (new HashSet<String>() instanceof java.util.SequencedSet));
        IO.println("hash map sequenced " + (new HashMap<String, String>() instanceof java.util.SequencedMap));
        IO.println("array list sequenced " + (lista instanceof java.util.SequencedCollection));
    }
}
