import java.util.Scanner;

public class Chef extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    
    
    //CONSTRUCTOR
    //===========
    public Chef(String firstName, String lastName, String id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
    }

    //SETTERS
    //=======
   
    //GETTERS
    //=======
   
    //METHODS
    //=======
    public void completeOrder() {
        //add code here
    }

    public void addtoMenu(){
        Scanner in = new Scanner(System.in);
        int id;
        String description;
        String name;
        System.out.println("Enter ID of item you want to add:");

        while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
            System.out.println("Enter ID of item you want to add:");
            in.nextLine();
        }
        id = in.nextInt();
        in.nextLine();
        System.out.println("Describe the item you are adding: ");
        description = in.nextLine();
        System.out.println("Now give it a name: ");
        name = in.nextLine();
        Database.addToMenu(new MenuItem(id, description, name));
    }

    public void updateDailySpecial() {
        //add code here
    }

    public void displayMainMenu() {}

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Chef");
    }

}
