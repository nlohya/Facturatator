package fr.nlohya.facturatator.document;

import fr.nlohya.facturatator.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {

    private String name;

    private String description;

    private List<Product> productList;

    private double price;

    public Document(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder document = new StringBuilder();
        document.append("{ ");
        document.append(this.name).append(", ");
        document.append(this.description).append(", ");
        document.append(this.price).append(", ");

        document.append("[ ");
        for (Product product : this.productList) {
            document.append(product.toString()).append(" ");
        }
        document.append(" ]");
        document.append(" }");

        return document.toString();
    }
}
