import java.util.Scanner;

public class Input {

    /**
     *<h1>This method checks whether the input is a number</h1>
     * @param min
     * @param max
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
     * <h2>This method creates an input scanner for a String</h2>
     * @return String input
     */
    public static String stringInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
