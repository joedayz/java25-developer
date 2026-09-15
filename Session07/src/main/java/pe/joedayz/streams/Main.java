package pe.joedayz.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.00));
        products.add(new Product("Smartphone", 800.00));
        products.add(new Product("Tablet", 400.00));

        //Loop 
        for (Product product : products) {
            if (product.getPrice() > 500) {
                System.out.println(product.getName() + " is expensive.");
            }
        }

        //Using Streams
        products.stream().parallel()
                .filter(product -> product.getPrice() > 500)
                .forEach(product ->product.setDiscount(10.0));

        System.out.println(Runtime.getRuntime().availableProcessors());

        int paralelismo = Runtime.getRuntime().availableProcessors() - 1;

        System.out.println("Paralelismo con un # de workers igual a : " + paralelismo);

        // si tuvieramos 1000 productos 
        // ForkJoinPool
        // Worker 1 ... Worker 14, Worker 15 ... main
        // 1000     500  250  125 125 250     500  250 250

        int sum = IntStream.generate(() -> (int) (Math.random() * 10))
                           .peek(n -> System.out.println("Generated: " + n))
                           .takeWhile(n -> n != 3)
                           .sum();
        System.out.println("Sum: " + sum);
        
    }
}
