package pe.joedayz.nested;

public class Order {

    public static void createShippingMode(String description){
        new ShippingMode(description);
    }

    private static class ShippingMode {
        private String description;
        public ShippingMode(String description){
            this.description = description;
        }
    }
}

class OrderMain{
    static void main() {

        Order.createShippingMode("Standard");
        Order.createShippingMode("Express");
    }
}
