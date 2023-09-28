package fr.nlohya.facturatator.document;

public class Invoice extends Document {

    private boolean isPaid;
    public Invoice(String name, String description, double price) {
        super(name, description, price);
        this.isPaid = false;
    }
}
