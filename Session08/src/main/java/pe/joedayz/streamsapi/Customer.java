package pe.joedayz.streamsapi;

import java.util.Objects;

public class Customer {

    private final String name;

    public Customer(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Customer customer
                && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
