package pe.joedayz.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMain {

    static void main() {

        Product p1 = new Food("Cake");
        Product p2 = new Drink("Tea");
        Product p3 = new Drink("Cookie");

        Deque<Product> menu = new ArrayDeque<>();

        menu.offerFirst(p1);
        menu.offerFirst(p2);

        System.out.println("Menu: " + menu);


        Product tea = menu.pollFirst();
        Product cake1 = menu.peekFirst();

        System.out.println("Menu after polling: " + menu);  // Cake

        menu.offerLast(p3);
        menu.offerLast(p1);

        System.out.println("Menu after adding Cookie and Cake: " + menu);  // Cake, Cookie, Cake2

        Product cake2 = menu.pollLast();
        Product cookie = menu.peekLast();

        System.out.println("Menu after polling last: " + menu);  // Cake, Cookie

        //menu.offerFirst(null); ArrayDeque no permite elementos null;

    }
}
