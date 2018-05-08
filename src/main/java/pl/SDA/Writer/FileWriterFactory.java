package pl.SDA.Writer;

public class FileWriterFactory {
    public static SDAFileWriter produce(String path) {
        SDAFileWriter resul = null;
        if (path.toLowerCase().endsWith(".csv")) {
            resul = new CSVFileWriter();
        }
        if (path.toLowerCase().endsWith(".json")) {
            resul = new JSONFileWriter();
        }
        if (path.toLowerCase().endsWith(".xlsx")) {
            resul = new ExcelFileWriter();
        }
        return resul;
    }
}
