package pl.SDA.Writer;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.SDA.MyObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

public class PDFFileWriter implements SDAFileWriter {
    @Override
    public void write(List<MyObject> list, String filePath) throws IOException, DocumentException, URISyntaxException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("newPDF.pdf"));


        document.open();

        PdfPTable table = new PdfPTable(list.get(0).getMap().keySet().size());
        addTableHeader(table, list);
        addRows(table, list);
//        addCustomRows(table);

//        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 25, BaseColor.RED);
//        Paragraph fontChunk = new Paragraph(list.get(0).getMap().keySet().toString(), font);
//        Paragraph paragraph = new Paragraph(getStringBuilderValue(list).toString());
//
//        document.add(fontChunk);
//        document.add(paragraph);
        document.add(table);
        document.close();

    }

    private void addCustomRows(PdfPTable table) throws URISyntaxException, IOException, BadElementException {
//        java.nio.file.Path path = java.nio.file.Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
//        Image img = Image.getInstance((path.toAbsolutePath()).toString());
//        img.scalePercent(10);

//        PdfPCell imageCell = new PdfPCell(img);
//        table.addCell(imageCell);

        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);

        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
    }

    private void addRows(PdfPTable table, List<MyObject> list) {
        Set<String> strings = list.get(0).getMap().keySet();

        for (MyObject mo : list) {
            for (String s : strings) {
                table.addCell(mo.getMap().get(s));
            }
        }

//            table.addCell("row 1, col 1");
//            table.addCell("row 1, col 2");
//            table.addCell("row 1, col 3");


    }

    private void addTableHeader(PdfPTable table, List<MyObject> list) {
        Set<String> strings = list.get(0).getMap().keySet();
        for (String s : strings) {
            table.addCell(s);
        }
    }


}
