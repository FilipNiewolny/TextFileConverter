package pl.SDA;

import com.itextpdf.text.DocumentException;
import pl.SDA.Reader.FileReaderFactory;
import pl.SDA.Reader.SDAFileReader;
import pl.SDA.Writer.FileWriterFactory;
import pl.SDA.Writer.SDAFileWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, URISyntaxException, DocumentException {
        String originFilePath = "C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\validator\\src\\test\\resources\\xmlReader.xlsx";
        String destinationFilePath = "C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\validator\\src\\test\\resources\\excel.xlsx";


        SDAFileReader reader = FileReaderFactory.produce(originFilePath);
        SDAFileWriter writer = FileWriterFactory.produce(destinationFilePath);

        List<MyObject> read = reader.read(originFilePath);

        System.out.println(read);

        writer.write(read, destinationFilePath);


//        SDAFileReader reader = FileReaderFactory.produce(originFilePath);
//        SDAFileWriter writer = FileWriterFactory.produce(destinationFilePath);
//
//        List<MyObject> read = reader.read(originFilePath);
//        writer.write(read , destinationFilePath);


//        CSVReaderFile reader = new CSVReaderFile();
//
//        try {
//            List<MyObject> personList = reader.read("C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\pliki\\csvFile.csv");
//            System.out.println(personList.toArray());
//            personList.forEach(e -> System.out.println(e.toString()));
//
//
//            CSVFileWriter csvFileWriter = new CSVFileWriter();
//            csvFileWriter.write(personList, "C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\validator\\src\\main\\moje.csv");
//
//            PDFFileWriter pdfFileWriter = new PDFFileWriter();
//            pdfFileWriter.write(personList ,"C:\\Users\\Filip\\Desktop\\SDA\\Projekty\\validator\\src\\main\\moje2.pdf" );
//        } catch (IOException e) {
//            System.out.println("Wystąpił błąd");
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

    }
}
