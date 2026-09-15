package pe.joedayz.streams;

public class Food extends Product {
    public Food() {
        super("Food", 0.0);
    }

    public Food(String name, double price) {
        super(name, price);
    }

    public void setPrice(double price) {
        super.setPrice(price);
    }
}
