package pl.SDA.Writer;

import com.itextpdf.text.DocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.SDA.MyObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExcelFileWriter implements SDAFileWriter {
    @Override
    public void write(List<MyObject> list, String filePath) throws IOException, DocumentException, URISyntaxException {
        Workbook workbook = new XSSFWorkbook();
        int cellCount = 0;
        int rowCount = 0;
        Sheet sheet = workbook.createSheet();
        Row rowFirst = sheet.createRow(rowCount++);

        Set<String> strings = list.get(0).getMap().keySet();
        for (String s : strings) {
            Cell cell = rowFirst.createCell(cellCount++);
            cell.setCellValue(s);
        }
        for (MyObject myObject : list) {
            Row row = sheet.createRow(rowCount++);
            Map<String, String> map = myObject.getMap();
            cellCount = 0;
            for (String s : map.keySet()) {
                Cell cell = row.createCell(cellCount++);
                cell.setCellValue(map.get(s));
            }

        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
