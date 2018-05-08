package pl.SDA.Writer;

import com.itextpdf.text.DocumentException;
import pl.SDA.MyObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface SDAFileWriter {
    void write(List<MyObject> list, String filePath) throws IOException, DocumentException, URISyntaxException;
}
