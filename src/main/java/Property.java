import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static void main(String[] args) throws IOException {

        String congigPath = "C:\\My_Own_Projects\\Java_Maven_Project\\src\\main\\resources\\application.properties";

        FileReader fileReader = new FileReader(congigPath);

        Properties properties = new Properties();
        properties.load(fileReader);

        String metadata_url = properties.getProperty("metadata_url");

        System.out.println(metadata_url);
    }
}
