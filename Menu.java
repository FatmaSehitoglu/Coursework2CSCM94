import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    public ArrayList<MenuItem> selectFromMenu(){
        int exit = 0;
        int option = 0;
        while (exit != 2) {
            System.out.println("Select an item: ");
            System.out.println("1. " + Database.getMenu().get(0).getName() + "\n" +
                    "2. " + Database.getMenu().get(1).getName() + "\n"
                    + "3. " + Database.getMenu().get(2).getName());
            while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
                System.out.println("1. " + Database.getMenu().get(0).getName() + "\n" +
                        "2. " + Database.getMenu().get(1).getName() + "\n"
                        + "3. " + Database.getMenu().get(2).getName());
                in.nextLine();
            }
            option = in.nextInt();
            in.nextLine();
            while (option < 1 || option > 3) {
                System.out.println("Choose a valid option:");
                option = in.nextInt();
                in.nextLine();
            }
            Database.addToSelections(Database.getMenu().get(option-1));
            System.out.println("1. Select more items\n 2. Exit");
            while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
                System.out.println("1. Select more items\n 2. Exit");
                in.nextLine();
            }
            exit = in.nextInt();
            in.nextLine();
            while (exit < 1 || exit > 2) {
                System.out.println("Choose a valid option:");
                exit = in.nextInt();
                in.nextLine();
            }
        }
        System.out.println("You have chosen:");
        for (MenuItem select: Database.getSelections()){
            System.out.println(select.getName());
        }
        return Database.getSelections();
    }
}
