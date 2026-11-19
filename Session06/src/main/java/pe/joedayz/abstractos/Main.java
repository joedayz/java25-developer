package pe.joedayz.abstractos;

public class Main {

    public static void main(String[] args) {
        //new Product();
        Product product = new Food();
        product.server();

        Product product2 = new Drink();
        product2.server();
    }
}
