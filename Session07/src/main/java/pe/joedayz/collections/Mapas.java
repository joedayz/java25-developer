package pe.joedayz.collections;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mapas {

    static void main() {
        var cola = new ArrayDeque<String>();
        IO.println("poll vacio " + cola.pollFirst());
        cola.offerLast("Café");
        cola.offerLast("Té");
        cola.offerFirst("Torta");

        IO.println(cola);
        IO.println("peek " + cola.peekFirst());
        IO.println("poll " + cola.pollFirst());
        IO.println("ultimo " + cola.pollLast());
        IO.println(cola);

        try {
            cola.offerLast(null);
        } catch (NullPointerException e) {
            IO.println("deque null " + e.getClass().getSimpleName());
        }
        try {
            new ArrayDeque<String>().getFirst();
        } catch (java.util.NoSuchElementException e) {
            IO.println("get vacio " + e.getClass().getSimpleName());
        }


        System.out.println("----------");

        var stock = new HashMap<String, Integer>();
        IO.println("put nuevo " + stock.put("Café", 2));
        stock.put("Té", 3);
        IO.println("put viejo " + stock.put("Café", 5));
        IO.println("remove " + stock.remove("Té"));
        IO.println(stock.containsKey("Té") + " " + stock.containsValue(5) + " " + stock.get("Café"));
        IO.println("ausente " + stock.get("Agua"));
        stock.put(null, 1);
        stock.put("Agua", null);
        IO.println("null key " + stock.get(null) + " null val " + stock.containsKey("Agua"));



        var fijo = Map.of("Café", 2, "Té", 3);
        IO.println(fijo.get("Té"));
        try {
            Map.of("Café", 2, "Café", 5);
        } catch (IllegalArgumentException e) {
            IO.println("map dup " + e.getClass().getSimpleName());
        }
        try {
            Map.of("Café", null);
        } catch (NullPointerException e) {
            IO.println("map null " + e.getClass().getSimpleName());
        }
        try {
            new TreeMap<String, Integer>().put(null, 1);
        } catch (NullPointerException e) {
            IO.println("treemap null " + e.getClass().getSimpleName());
        }
    }
}
