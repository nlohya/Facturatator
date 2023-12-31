package fr.nlohya.facturatator.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

public class ActionsHandler {

    public static EventHandler<ActionEvent> handleCreateInvoice() {
        return actionEvent -> CreateInvoice.createWindow();
    }

    public static EventHandler<ActionEvent> handleListInvoices() {
        return actionEvent -> {
            try {
                ListInvoices.createWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
