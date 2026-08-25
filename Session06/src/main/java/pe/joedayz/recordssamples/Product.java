package pe.joedayz.recordssamples;

import java.time.LocalDateTime;

public record Product(String name, double price) {
    //constructor conventional
//    public Product(String name, double price) {
//        this.name = name.toUpperCase();
//        this.price = price;
//    }

    //constructor compacto
    public Product {
        //realiza conversiones, transformaciones
        name = name.toUpperCase();
        price = price * 2;
    }
}
record Delivery (Product product, LocalDateTime time){}

record Person(String name, int age) {}


class Test{
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000.0);
        Product p2 = new Product("Laptop", 1000.0);
        System.out.println(p1.name()); //accesors
        System.out.println(p1.price());


        boolean same = p1.equals(p2);

        int hashcode = p2.hashCode();

        System.out.println("Are p1 and p2 the same? " + same);
        System.out.println("Hashcode of p1: " + hashcode);

        Delivery obj = new Delivery(p1, LocalDateTime.now());

        if (obj instanceof Delivery(Product (String name, double price), var time)){
            System.out.println("Product name: " + name + " price: " + price + " time: " + time);
        }


        String result = switch (obj){
          case null -> "No data";
          case Delivery d when d.time().isBefore(LocalDateTime.now()) -> "Delivered";
          case Delivery d -> "Pending delivery";

        };

        Object obj2 = new Person("Jose", 52);
        String result2 = switch (obj2){
            case Person p -> "Person";
            case null -> "No data";
            default -> "Unknown";
        };

    }
}