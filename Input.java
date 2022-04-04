import java.util.Scanner;

/**
 * <h2>The type Input.</h2>
 * @version 1.0
 * @author Martin
 */
public class Input {

    /**
     * This method checks whether the input is a number
     *
     * @param min the min as an int
     * @param max the max as an int
     * @return int inputInt
     */
    public static int intInput(int min, int max){
        Scanner in = new Scanner(System.in);
        int inputInt = 0;
        while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
            System.out.println("Please enter a valid input in range " + min + " to " + max);
            in.nextLine();
        }
        inputInt = in.nextInt();
        in.nextLine();
        while (inputInt < min || inputInt > max) {
            System.out.println("Choose a valid option:");
            inputInt = in.nextInt();
            in.nextLine();
        }
        return inputInt;
    }

    /**
     * This method creates an input scanner for a String
     *
     * @return String input as a String
     */
    public static String stringInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
