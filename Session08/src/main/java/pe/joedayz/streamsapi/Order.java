package pe.joedayz.streamsapi;

import pe.joedayz.nested.Product;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private final Customer customer;
    private final LocalDate date;
    private final List<Product> items;

    public Order(Customer customer, LocalDate date, List<Product> items) {
        this.customer = customer;
        this.date = date;
        this.items = List.copyOf(items);
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
