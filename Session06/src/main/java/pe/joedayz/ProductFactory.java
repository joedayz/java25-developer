package pe.joedayz;



public class ProductFactory {


    public static Product createProduct(ProductType productType) {
        return switch (productType){
            case FOOD -> new Food();
            case DRINK -> new Drink();
        };
    }
}
