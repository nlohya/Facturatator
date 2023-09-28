package fr.nlohya.facturatator.product;

public class Product {

    private String name;

    private double price;

    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder product = new StringBuilder();
        product.append("{ ");
        product.append(this.name).append(" ");
        product.append(this.price).append(" ");
        product.append(this.description).append(" ");
        product.append(" }");
        return product.toString();
    }
}
