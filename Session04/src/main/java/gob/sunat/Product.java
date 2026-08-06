package gob.sunat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {

    //variables de instancia
    private int id;  // 0
    private String name;  // null
    private BigDecimal price;  // null
    private LocalDate bestBefore = LocalDate.now().plusDays(3);

    //constructores
    //Dummy d = new Dummy();  NO SE PUEDE USAR CLASES SIN PAQUETE EN OTRAS CLASES.

    //methods
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public void play() {}
}
