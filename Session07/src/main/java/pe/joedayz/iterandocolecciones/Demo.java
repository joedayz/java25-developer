package pe.joedayz.iterandocolecciones;

import java.util.*;

public class Demo {

    static void main() {
        var menu = new ArrayList<>(List.of("Café", "Té", "Torta", "Chocolate", "Galleta"));
        for (String item : menu) {
            IO.print(item + " ");
        }
        IO.println();

        try {
            for (String item : menu) {
                if (item.equals("Té")) {
                    menu.remove(item);
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            IO.println(e.getClass().getSimpleName());
        }

        menu.forEach(item -> IO.println(item + " ")); // Café Torta

        menu.removeIf(item -> item.equals("Té")); // This will not throw ConcurrentModificationException




        menu = new ArrayList<>(List.of("Café", "Té", "Torta", "Chocolate", "Galleta"));

        Iterator<String> it = menu.iterator();
        while (it.hasNext()) {
            if (it.next().equals("Té")) {
                it.remove();
            }
        }
        IO.println(menu);



        var letras = new ArrayList<>(List.of("A", "B", "C"));
        ListIterator<String> lit = letras.listIterator();
        lit.next();
        lit.add("Z");
        lit.next();
        lit.set("Y");
        IO.println(letras);

        var stock = new LinkedHashMap<String, Integer>();
        stock.put("Café", 2);
        stock.put("Té", 3);
        stock.forEach((p, c) -> IO.println(p + "-" + c));
        stock.keySet().remove("Té");
        IO.println(stock);



        String[] chico = new String[1];
        String[] amplio = menu.toArray(chico);
        IO.println(Arrays.toString(amplio) + " mismo=" + (chico == amplio));


    }
}
