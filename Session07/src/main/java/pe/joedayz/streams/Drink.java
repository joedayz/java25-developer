package pe.joedayz.streams;

public class Drink extends Product {
    public Drink() {
        super("Drink", 0.0);
    }
    public Drink(String name, double price) {
        super(name, price);
    }

    public void setPrice(double price) {
        super.setPrice(price);
    }
}
