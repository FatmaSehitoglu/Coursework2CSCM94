import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;;

public class FileManager {

    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


    /**
     * @param String filename
     * @param String data
     * @return none
     */
    public static void writeToFile(String filename, String data) {


        try {
            FileWriter writer = new FileWriter(filename, true);
            /*
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(data);
            bw.flush();
            bw.close();
            */
            writer.append(data);
            writer.close();
            //System.out.println("Successfuly wrote " + data + " to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    /**
     * <h1>A method to show the orrder history</h1>
     * @param String filename
     * @param String customerID
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
     * <h2>A method that loads the data from the save fail(database)</h2>
     * @param filename
     * @param n
     * @return
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

        for (int i = 0; i < list.size(); i++) {
            //System.out.println("Line read: " + list.get(i));
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
     * <h3>A method to change the database</h3>
     * @param filename
     */
    public static void clearFile(String filename) {
        try {    
            FileWriter writer = new FileWriter(filename, true);
            writer.write("");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static String LocalDateTimeToString(LocalDateTime ldt) {
        return ldt.format(formatter);
    }

    public static LocalDateTime StringToLocalDateTime(String str) {
        return LocalDateTime.parse(str, formatter);
    }

    public static String getItemIds(ArrayList<MenuItem> items) {
        String s = String.format("%d", items.get(0).getID());
        for (int i = 1; i < items.size(); i++) {
            s += String.format(",%d", items.get(i).getID());
        }
        return s;
    }

    public static ArrayList<MenuItem> getItemsFromIds(String str) {
        ArrayList<MenuItem> items = new ArrayList<>();
        String[] ids = str.split(",");
        for (int i = 0; i < ids.length; i++) {
            items.add(Database.getItem(Integer.parseInt(ids[i])));
        }
        return items;
    }



}
