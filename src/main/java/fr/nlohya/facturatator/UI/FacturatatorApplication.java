package fr.nlohya.facturatator.UI;

import fr.nlohya.facturatator.document.Document;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FacturatatorApplication extends Application {
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        createWindow(root);
        Scene scene = new Scene(root, 255, 50);

        stage.setScene(scene);
        stage.setTitle("Facturatator");
        stage.show();
    }

    public static void createWindow(StackPane root) {

        HBox mainControls = new HBox();
        mainControls.setPadding(new Insets(10, 10, 10, 10));
        mainControls.setSpacing(10);

        Button createInvoiceBtn = new Button("Créer une facture");
        createInvoiceBtn.setOnAction(ActionsHandler.handleCreateInvoice());
        mainControls.getChildren().add(createInvoiceBtn);

        Button listInvoicesBtn = new Button("Lister les factures");
        listInvoicesBtn.setOnAction(ActionsHandler.handleListInvoices());
        mainControls.getChildren().add(listInvoicesBtn);

        root.getChildren().add(mainControls);
    }

    public static void main(String[] args) {
        launch();
    }
}