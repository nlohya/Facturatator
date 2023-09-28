package fr.nlohya.facturatator.UI;

import com.itextpdf.text.DocumentException;
import fr.nlohya.facturatator.PdfCreator;
import fr.nlohya.facturatator.product.Product;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateInvoice {

    public static void createWindow() {
        Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.setTitle("Création de facture");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(5);

        VBox nameBox = new VBox();
        nameBox.setAlignment(Pos.CENTER_LEFT);
        Label nameLabel = new Label("Nom :");
        TextField nameField = new TextField();
        nameBox.getChildren().addAll(nameLabel, nameField);

        VBox numBox = new VBox();
        numBox.setAlignment(Pos.CENTER_LEFT);
        Label numLabel = new Label("Numéro :");
        TextField numField = new TextField();
        numBox.getChildren().addAll(numLabel, numField);

        VBox destinataireBox = new VBox();
        destinataireBox.setAlignment(Pos.CENTER_LEFT);
        Label destinataireLabel = new Label("Destinataire :");
        TextField destinataireField = new TextField();
        destinataireBox.getChildren().addAll(destinataireLabel, destinataireField);

        VBox descBox = new VBox();
        descBox.setAlignment(Pos.CENTER_LEFT);
        Label descLabel = new Label("Description :");
        TextArea descField = new TextArea();
        descField.setMaxHeight(50);
        descBox.getChildren().addAll(descLabel, descField);

        VBox dateBox = new VBox();
        dateBox.setAlignment(Pos.CENTER_LEFT);
        Label dateLabel = new Label("Date :");
        DatePicker dateField = new DatePicker();
        dateField.setMaxHeight(50);
        dateBox.getChildren().addAll(dateLabel, dateField);

        VBox productBox = new VBox();
        productBox.setAlignment(Pos.CENTER_LEFT);
        Label productLabel = new Label("Produits :");
        ListView<Product> productField = new ListView<>(FXCollections.observableList(
                List.of(
                        new Product("Prestation a", 180, "Test"),
                        new Product("Prestation b", 190, "Test"),
                        new Product("Prestation c", 240, "Test"),
                        new Product("Prestation d", 350, "Test")
                )
        ));
        productField.setMaxHeight(150);
        productField.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        productBox.getChildren().addAll(productLabel, productField);


        VBox addCostBox = new VBox();
        addCostBox.setAlignment(Pos.CENTER_LEFT);
        Label addCostLabel = new Label("Coûts additionnels :");
        Spinner<Integer> addCostField = new Spinner<>(0, 1000, 0, 1);
        addCostBox.getChildren().addAll(addCostLabel, addCostField);

        HBox controlsBox = new HBox();
        controlsBox.setAlignment(Pos.CENTER);
        Button createButton = new Button("Créer");
        Button cancelButton = new Button("Annuler");
        controlsBox.getChildren().addAll(createButton, cancelButton);
        controlsBox.setSpacing(20);
        controlsBox.setPadding(new Insets(30, 0, 0, 0));

        createButton.setOnAction(actionEvent -> {
            try {
                StringBuilder productList = new StringBuilder();
                double totalCost = addCostField.getValue();
                productList.append("\n -- \n");
                for (Product selectedItem : productField.getSelectionModel().getSelectedItems()) {
                    totalCost += selectedItem.getPrice();
                    productList.append(selectedItem.getName())
                            .append(" - ")
                            .append(selectedItem.getPrice())
                            .append(" euros")
                            .append(" - ")
                            .append(selectedItem.getDescription())
                            .append("\n -- \n");
                }

                new PdfCreator("facturatator_" + nameField.getText() + ".pdf")
                        .addChunk(nameField.getText())
                        .addChunk("Numéro : " + numField.getText())
                        .addChunk("Destinataire : " + destinataireField.getText())
                        .addChunk("Description : \n" + descField.getText())
                        .addChunk("Date : " + dateField.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                        .addChunk("Produits : " + productList)
                        .addChunk("Coûts additionnels : " + addCostField.getValue().toString() + " euros")
                        .addChunk("Prix total : " + totalCost + " euros")
                        .close();
            } catch (DocumentException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        cancelButton.setOnAction(CreateInvoiceActionsHandler.handleCancelCreate(stage));

        vBox.getChildren().addAll(nameBox, numBox, destinataireBox, descBox, dateBox, productBox, addCostBox, controlsBox);

        root.getChildren().addAll(vBox);
        stage.setScene(new Scene(root, 300, 550));
        stage.show();
    }

}
