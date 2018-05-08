package pl.SDA.Reader;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.SDA.MyObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JSONFileReader implements SDAFileReader {

    @Override
    public List<MyObject> read(String filePath) throws IOException {

        List<MyObject> result = new ArrayList<>();
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);
        String rootKey = jsonObject.keySet().iterator().next();
        JSONArray jsonArray = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValues : jsonArray) {
            JSONObject value = new JSONObject(rawValues.toString());
            Set<String> setKey = value.keySet();
            MyObject myObject = new MyObject();
            for (String key : setKey) {

                myObject.setKey(key, value.get(key).toString());
            }

            result.add(myObject);
        }

        return result;
    }
}
