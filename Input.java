import java.util.Scanner;

/**
 * <h2>Input class</h2>
 * Provides methods to accept user input
 * @version 1.0
 * @author Martin Dimitrov
 */
public class Input {

    //METHODS
    //=======

    /**
     * Accepts integer input from a user
     * @param min   the minimum value as an int
     * @param max   the maximum value as an int
     * @return      the user-entered value as an int
     */
    public static int intInput(int min, int max) {
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
     * Accepts String input from a user
     * @return String input as a String
     */
    public static String stringInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
