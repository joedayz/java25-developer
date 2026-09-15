package pe.joedayz.streams;

public class Product {
	private String name;
	private double price;
    private double discount;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.discount = 0.0;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
