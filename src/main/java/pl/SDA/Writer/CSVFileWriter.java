package pl.SDA.Writer;

import org.apache.commons.lang3.StringUtils;
import pl.SDA.MyObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter implements SDAFileWriter {
    @Override
    public void write(List<MyObject> list, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = getStringBuilder3(list);
            bufferedWriter.write(stringBuilder.toString());
            StringBuilder sb = getStringBuilderValue(list);

            bufferedWriter.write(sb.toString());

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder getStringBuilder3(List<MyObject> list) {
        String str = list.get(0).getMap().keySet().toString();
        return getStringBuilderHeader(str);
    }

    private StringBuilder getStringBuilderValue(List<MyObject> list) {
        StringBuilder sb = new StringBuilder();
        for (MyObject obj : list) {
            String tmp = obj.toString();
            sb.append("\n").append(getStringBuilderHeader(tmp));
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    private StringBuilder getStringBuilderHeader(String str) {
        String[] split = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();

        for (String st : split) {
            String tmp = "";
            tmp = StringUtils.remove(st, "[");
            tmp = StringUtils.trim(tmp);
            tmp = StringUtils.remove(tmp, "]");
            stringBuilder.append(tmp).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder;
    }
}
