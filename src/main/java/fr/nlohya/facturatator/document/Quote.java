package fr.nlohya.facturatator.document;

public class Quote extends Document {

    private boolean isSigned;

    public Quote(String name, String description, double price) {
        super(name, description, price);
        this.isSigned = false;
    }
}
