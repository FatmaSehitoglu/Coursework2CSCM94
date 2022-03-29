import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void writeToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }


}
