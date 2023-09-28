package fr.nlohya.facturatator.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CreateInvoiceActionsHandler {

    public static EventHandler<ActionEvent> handleCancelCreate(Stage stage) {
        return actionEvent -> {
            stage.close();
        };
    }

}
