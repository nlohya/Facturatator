package fr.nlohya.facturatator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfCreator {

    private final Document document;

    private final String path;

    public static final Font FONT = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);

    public PdfCreator(String path) throws DocumentException, FileNotFoundException {
        this.document = new Document();
        this.path = path;
        this.create();
    }

    private void create() throws FileNotFoundException, DocumentException {
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
    }

    public PdfCreator addChunk(String content) throws DocumentException {
        this.document.add(new Paragraph(content, FONT));
        this.document.add(Chunk.NEWLINE);
        return this;
    }

    public PdfCreator close() {
        this.document.close();
        return this;
    }
}
