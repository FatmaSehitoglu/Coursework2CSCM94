import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;;

/**
 * <h2>FileManager class</h2>
 * Contains methods for writing to and reading from database
 * @author  Chris Litting
 * @version 1.0
 */
public class FileManager {

    //FIELDS
    //======

    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    //METHODS
    //=======

    /**
     * Writes data to a text file
     * @param filename the filename as a String
     * @param data     the data as a String
     */
    public static void writeToFile(String filename, String data) {
        try {
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.append(data);
            }
            System.out.println("Written " + data + " to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    /**
     * Shows the order history (deprecated)
     * @param filename      the filename as a String
     * @param customerID    the customer id as a String
     * @throws IOException  if file not found
     * @see IOException
     */
    public static void readOrderHistory(String filename, String customerID) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Scanner reader = new Scanner(br);
        while (reader.hasNextLine()) {
            list.add(reader.nextLine());
        }
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
            if (split[1].equals(customerID)){
                System.out.println(split[3]);
                System.out.println(split[8]);
            }
        }
    }

    /**
     * Reads data from a text file (data must be delimited by pipe ("|") characters )
     * @param filename  the filename as a String
     * @param n         n, the number of data points for the object type being read
     * @return          the object data as a 2D String array
     */
    public static String[][] readFromFile(String filename, int n) {
        ArrayList<String> list = new ArrayList<>();
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
        //String[] temp = new String[n];
        for (int i = 0; i < list.size(); i++){
            String[] temp = list.get(i).split("\\|");
            for (int j = 0; j < n; j++){
                //System.out.println(temp[j]);
                output[i][j] = temp[j];
            }
        }
        return output;
    }

    /**
     * Erases the contents of a text file
     * @param filename the filename as a String
     */
    public static void clearFile(String filename) {
        try {    
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.write("");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Converts a LocalDateTime to a String (for writing to file)
     * @param ldt   as a LocalDateTime
     * @return      the LocalDateTime value as a String
     */
    public static String localDateTimeToString(LocalDateTime ldt) {
        return ldt.format(formatter);
    }

    /**
     * Converts a String to a LocalDateTime (for reading from file)
     * @param str   the LocalDateTime as a String
     * @return      the LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String str) {
        return LocalDateTime.parse(str, formatter);
    }

    /**
     * Converts an ArrayList of MenuItems to a String containing only the IDs (for writing to file)
     * @param items as a MenuItem ArrayList
     * @return      the MenuItem IDs as a String, delimited by commas
     */
    public static String getItemIds(ArrayList<MenuItem> items) {
        if (items.size() > 0) {
            String s = String.format("%d", items.get(0).getId());
            for (int i = 1; i < items.size(); i++) {
                s += String.format(",%d", items.get(i).getId());
            }
            return s;
        } else {
            return "";
        }
    }   

    /**
     * Converts a list of MenuItem IDs into a MenuItem ArrayList (for reading from file)
     * @param str   the IDs as a String, delimited by commas
     * @return      the MenuItems as a MenuItem ArrayList
     */
    public static ArrayList<MenuItem> getItemsFromIds(String str) {
        ArrayList<MenuItem> items = new ArrayList<>();
        String[] ids = str.split(",");
        if (!ids[0].equals("")){
            for (int i = 0; i < ids.length; i++) {
                items.add(Database.getItem(Integer.parseInt(ids[i])));
            }
        }
        return items;
    }

}
