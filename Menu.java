import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu {

    /**
     * <h1>This is the method to display the menu and allow the user to make selections</h1>
     *
     * @return array list
     */
    public static ArrayList<MenuItem> selectFromMenu(){
        ArrayList<MenuItem> selections = new ArrayList<MenuItem>();
        int exit = -1;
        int noOfSpecials= Database.getSpecials().size();
        while(exit == -1) {
            System.out.println("Please enter the code of the item you want to select. Press 0 to finish the order");
            System.out.println("Today's Specials");
            for(int k=0; k<noOfSpecials; k++) {
                System.out.println((k+1000) + "- " + Database.getSpecials().get(k).toString() );
            }
            System.out.println("Menu");
            for(int k=0; k<Database.getActiveMenu().size(); k++) {
                System.out.println(k+1 + "- " + Database.getActiveMenu().get(k).toString() );
            }
            int input = Input.intInput(0,1000+noOfSpecials);
            if(input == 0) {
                exit = 0;
            } else if(input>0 && input<Database.getActiveMenu().size()+2) {
                input = input-1;
                selections.add(Database.getActiveMenu().get(input));
            } else if(input>999 && input<1000+noOfSpecials) { 
                input = input-1000;
                selections.add(Database.getSpecials().get(input));
            } else {
                System.out.println("Please enter a valid input");
            }
        }
        return selections;
    }

    /*
    Scanner in = new Scanner(System.in);
    public void selectFromMenu(){
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
                System.out.println("1. Select more items\n2. Exit");
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
    }
    */
}
