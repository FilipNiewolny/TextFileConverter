package pl.SDA.Writer;

import com.itextpdf.text.DocumentException;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.SDA.MyObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

public class JSONFileWriter implements SDAFileWriter {
    @Override
    public void write(List<MyObject> list, String filePath) throws IOException, DocumentException, URISyntaxException {


        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        JSONArray jsonArray = new JSONArray();
        for (MyObject myObject : list) {
            JSONObject personJSON = new JSONObject();
            Set<String> keys = myObject.getMap().keySet();
            for (String key : keys) {
                personJSON.put(key, myObject.getMap().get(key));

            }
            jsonArray.put(personJSON);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("person", jsonArray);

        bufferedWriter.write(jsonObject.toString());

        bufferedWriter.close();
        fileWriter.close();
    }

}
