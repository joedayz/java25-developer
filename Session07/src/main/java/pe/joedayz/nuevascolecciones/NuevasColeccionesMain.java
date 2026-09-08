package pe.joedayz.nuevascolecciones;

import java.util.*;

public class NuevasColeccionesMain {

    static void main() {

        SequencedCollection<String> frutas =
                new ArrayList<>();


        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Plátano");

        System.out.println("Frutas: " + frutas);

        System.out.println("Primera fruta: " + frutas.getFirst());

        System.out.println("Ultima fruta: " + frutas.getLast());

        frutas.addFirst("Naranja");
        frutas.addLast("Uva");

        System.out.println("Frutas: " + frutas);

        System.out.println("Frutas al revés: " + frutas.reversed());

        ///////
        SequencedSet<String> setFrutas =
                new LinkedHashSet<>();

        setFrutas.add("Manzana");
        setFrutas.add("Pera");
        setFrutas.add("Plátano");
        setFrutas.add("Plátano");
        System.out.println("Set de frutas: " + setFrutas);

        System.out.println(setFrutas.getFirst());
        // Manzana

        System.out.println(setFrutas.getLast());
        // Plátano

        ///////////
        SequencedMap<Integer, String> personas =
                new LinkedHashMap<>();

        personas.put(1, "Juan");
        personas.put(2, "Pedro");
        personas.put(3, "Ana");

        System.out.println("Personas: " + personas);

        System.out.println("Primera persona: " + personas.firstEntry());

        System.out.println("Ultima persona: " + personas.lastEntry());

        personas.putFirst(4, "Luis");
        personas.putLast(5, "Maria");

        System.out.println("Personas: " + personas);

        System.out.println("Personas al revés: " + personas.reversed());

    }
}