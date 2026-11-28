package pe.joedayz.concurrencia;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {

    static void main() {
        var origen = new ArrayList<>(List.of("Café", "Té"));
        origen.add("Chocolate");
        List<String> vista = Collections.unmodifiableList(origen);
        List<String> copia = List.copyOf(origen);
        origen.add("Galleta");
        IO.println("Origen: " + origen);
        IO.println("Vista: " + vista);
        IO.println("Copia: " + copia);

        try {
            copia.add("Agua");
        } catch (UnsupportedOperationException e) {
            IO.println("copia add " + e.getClass().getSimpleName());
        }

        //Crear una lista protegida para que cada operacion individual sea segura cuando varios hilos
        //acceden a ella:
        var sync = Collections.synchronizedList(
                new ArrayList<>(List.of("Café"))
        );
        sync.add("Té");
        IO.println("sync " + sync);

        IO.println("*********");

        var cow = new CopyOnWriteArrayList<>(List.of("Café", "Té"));
        var it = cow.iterator();
        cow.add("Chocolate");
        var vistos = new StringBuilder();
        while(it.hasNext()){
            vistos.append(it.next()).append(" ");
        }
        IO.println("iterador " + vistos);
        IO.println("cow " + cow);

        try {
            cow.iterator().remove();
        } catch (UnsupportedOperationException e) {
            IO.println("cow remove " + e.getClass().getSimpleName());
        }


        var vector = new Vector<String>();
        vector.add("Café");
        var tabla = new Hashtable<String, Integer>();
        tabla.put("Café", 2);
        IO.println(vector.getFirst() + " " + tabla.get("Café"));


        IO.println(vector.getFirst() + " " + tabla.get("Café"));
        try {
            tabla.put(null, 1);
        } catch (NullPointerException e) {
            IO.println("hashtable null " + e.getClass().getSimpleName());
        }


    }
}
