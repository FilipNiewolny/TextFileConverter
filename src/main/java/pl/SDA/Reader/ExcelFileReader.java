package pl.SDA.Reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.SDA.MyObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader implements SDAFileReader {
    @Override
    public List<MyObject> read(String filePath) throws IOException {
        List<MyObject> list = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        List<String> headers = new ArrayList<>();
        Row headerRow = rowIterator.next();
        Iterator<Cell> headerCellIterator = headerRow.iterator();
        while (headerCellIterator.hasNext()) {
            Cell cell = headerCellIterator.next();
            headers.add(cell.getStringCellValue());
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            MyObject myObject = new MyObject();
            int i = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellTypeEnum();
                String value = CellType.NUMERIC.equals(cellType) ? String.valueOf(Double.valueOf(cell.getNumericCellValue()).intValue()) : cell.getStringCellValue();
                myObject.setKey(headers.get(i), value);
                i++;
            }
            list.add(myObject);
        }


        return list;
    }

}
