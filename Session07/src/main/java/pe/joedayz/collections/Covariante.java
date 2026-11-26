package pe.joedayz.collections;

public class Covariante {

    static void main() {
        Food[] comidas = { new Food("Torta")};
        Product[] productos = comidas; // Covarianza

        productos[0] = new Drink("Coca Cola"); // ArrayStoreException
    }
}
