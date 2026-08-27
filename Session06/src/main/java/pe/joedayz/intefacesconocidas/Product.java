package pe.joedayz.intefacesconocidas;

public class Product implements Comparable<Product> {

    String name;
    Double price;

    public Product(String name) {

        this.name = name;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
