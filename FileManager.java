import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;;

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

    
    public static String[][] readFromFile(String filename, int n) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File myObj = new File(filename);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        String[][] output = new String[list.size()][n]; 
        String[] temp = new String[n];
        for (int i = 0; i < list.size(); i++){
            temp = list.get(i).split("|");
            for (int j = 0; j < n; j++){
                output[i][j] = temp[j];
            }
        }
        return output;
    }
    

}
