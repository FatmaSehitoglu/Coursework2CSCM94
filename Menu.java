import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    public MenuItem selectFromMenu(){
        System.out.println("Select an item: ");

        System.out.println("1. " + Database.getMenu().get(0).getName() + "\n" +
                "2. " + Database.getMenu().get(1).getName() + "\n"
        + "3. " + Database.getMenu().get(2).getName());
        while (!in.hasNextInt()){   //checks whether the input is Int so program doesnt crash
            System.out.println("1. " + Database.getMenu().get(0).getName() + "\n" +
                    "2. " + Database.getMenu().get(1).getName() + "\n"
                    + "3. " + Database.getMenu().get(2).getName());
            in.nextLine();
        }
        int option = in.nextInt();
        in.nextLine();
        while (option < 1 || option > 3){
            System.out.println("Choose a valid option:");
            option = in.nextInt();
            in.nextLine();
        }
        System.out.println("You have chosen " + Database.getMenu().get(option-1).getName());
        return Database.getMenu().get(option-1);
    }
}
