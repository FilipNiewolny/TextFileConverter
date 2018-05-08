package pl.SDA;

import org.junit.Assert;
import org.junit.Test;
import pl.SDA.Reader.CSVReaderFile;

import java.io.IOException;
import java.util.List;

public class CSVReaderFileTest {


    @Test
    public void CSVReaderFile() {
        //given
        String[] headers = {"name", "lastName", "age", "pesel"};
        String line = "Fil;Niewo;22;654654";
        CSVReaderFile csvReaderFile = new CSVReaderFile();
        //when
        MyObject object = csvReaderFile.myObjectReader(headers, line);
        String name = "Fil";
        String lastName = "Niewo";
        String age = "22";
        String pesel = "654654";
        //then

        Assert.assertEquals(name, object.getMap().get("name"));
        Assert.assertEquals(lastName, object.getMap().get("lastName"));
        Assert.assertEquals(age, object.getMap().get("age"));
        Assert.assertEquals(pesel, object.getMap().get("pesel"));
    }

    @Test
    public void AppTest() throws IOException {
        //given
        CSVReaderFile reader = new CSVReaderFile();
        //when
        List<MyObject> personsList = reader.read("C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\pliki\\csvFile.csv");

        //then
        Assert.assertNotNull(personsList);


    }
}
