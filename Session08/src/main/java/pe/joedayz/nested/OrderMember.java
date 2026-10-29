package pe.joedayz.nested;

import java.util.HashSet;
import java.util.Set;

public class OrderMember {

    private Set<Item> items = new HashSet<>();

    public void addItem(Product product, int quantity){
        items.add(new Item(product, quantity));
    }


    class Item{
        private Product product;
        private int quantity;
        private Item(Product product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }
    }
}


class MainMember{
    static void main() {
        OrderMember orderMember1 = new OrderMember();
        OrderMember orderMember2 = new OrderMember();

        orderMember1.addItem(new Drink("Tea"), 1);
        orderMember2.addItem(new Food("Cake"), 2);
    }
}

