package pl.SDA.Reader;

public class FileReaderFactory {
    public static SDAFileReader produce(String filePath) {
        SDAFileReader result = null;
        if (filePath.toLowerCase().endsWith(".csv")) {
            result = new CSVReaderFile();
        }
        if (filePath.toLowerCase().endsWith(".json")) {
            result = new JSONFileReader();
        }
        if (filePath.toLowerCase().endsWith(".xlsx")) {
            result = new ExcelFileReader();
        }
        return result;
    }
}
