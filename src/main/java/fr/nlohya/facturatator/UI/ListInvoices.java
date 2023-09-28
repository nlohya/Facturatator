package fr.nlohya.facturatator.UI;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListInvoices {

    public static void createWindow() throws IOException {
        Stage stage = new Stage();
        StackPane root = new StackPane();
        stage.setTitle("Vos factures");

        List<String> factures = new ArrayList<>();
        for (String s : Objects.requireNonNull(new File("./").list())) {
            if (s.endsWith(".pdf") && s.contains("facturatator_")) {
                factures.add(s);
            }
        }

        ListView<String> listView = new ListView<>(FXCollections.observableList(factures));

        listView.setOnMouseClicked(mouseEvent -> {
            try {
                // MacOS open finder
                Runtime.getRuntime().exec("open -R ./" + listView.getSelectionModel().getSelectedItem());

                // Linux open explorer
                Runtime.getRuntime().exec("xdg-open ./" + listView.getSelectionModel().getSelectedItem());

                // Windows open explorer
                Runtime.getRuntime().exec("explorer /select, ./" + listView.getSelectionModel().getSelectedItem());
            } catch (IOException ignore) {

            }
        });


        root.getChildren().add(listView);

        stage.setScene(new Scene(root, 300, 550));
        stage.show();
    }
}
