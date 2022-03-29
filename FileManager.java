import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void writeToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(data);
            writer.close();
            System.out.println("Successfuly wrote " + data + " to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }


}
