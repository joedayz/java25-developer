package pe.joedayz.collections;

import java.util.ArrayList;
import java.util.List;

public class ManageListContents {

    static void main() {
        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");

        List<Product> menu = new ArrayList<>();

        menu.add(p1);       // insert first element
        menu.add(p2);       // insert next element
        menu.add(2, null);  // insert null
        menu.add(3, p1);    // insert element
        menu.add(2, p1);    // insert element
        menu.set(2, p2);    // update element
        menu.remove(0);     // remove element
        menu.remove(p2);    // remove element

        boolean hasTea = menu.contains(p2);
        int index = menu.indexOf(p1);

        menu.get(index).setName("Cookie");

        //menu.add(4, p2);    // throws exception

        System.out.println("Menu: " + menu);
    }
}
