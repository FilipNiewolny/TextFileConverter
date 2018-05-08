package pl.SDA.Reader;

import pl.SDA.MyObject;

import java.io.IOException;
import java.util.List;

public interface SDAFileReader {
    List<MyObject> read(String filePath) throws IOException;

}
