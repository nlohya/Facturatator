package fr.nlohya.facturatator.UI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import fr.nlohya.facturatator.PdfCreator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class CreateInvoiceActionsHandler {

    public static EventHandler<ActionEvent> handleCancelCreate(Stage stage) {
        return actionEvent -> {
            stage.close();
        };
    }

}
