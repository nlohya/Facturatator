module com.example.facturatator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires itextpdf;

    opens fr.nlohya.facturatator.UI to javafx.fxml;
    exports fr.nlohya.facturatator.UI;
}