package pl.SDA.Reader;

import pl.SDA.MyObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderFile implements SDAFileReader {

    @Override
    public List<MyObject> read(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        List<MyObject> list = new ArrayList<>();
        String line;
        String[] header = null;
        int i = 0;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                header = line.split(";");
                i++;
            } else {
                MyObject myObject = myObjectReader(header, line);
                list.add(myObject);
            }
        }
//        System.out.println(list.);
        return list;

    }

    public MyObject myObjectReader(String[] header, String line) {
        MyObject myObject = new MyObject();

        String[] value = line.split(";");
        int i = 0;
        for (String parameter : value) {
            myObject.setKey(header[i], parameter);
            i++;
        }

        return myObject;
    }


}

