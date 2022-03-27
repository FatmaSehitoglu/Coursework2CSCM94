import java.util.Scanner;

public class Input {
    Scanner in = new Scanner(System.in);
    int inputInt = 0;
    public int intInput(int min, int max){
        while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
            System.out.println("Please enter a valid input in range: ");
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
}
