
import java.util.Scanner;
import java.util.ArrayList;

public class Waiter extends Staff {
    
    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTOR
    //===========
    public Waiter(String firstName, String lastName, String id) {
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

    public void newEatInOrder() {
        Scanner in = new Scanner(System.in);
        int tableId = -1;

        System.out.println("Enter table number: ");
        tableId = in.nextInt();
        String waiterId = this.getId();

        //select items from menu
        //this method doesn't exist yet
        //Menu.selectFromMenu();


        //Order order = new Eat_in(tableId, waiterId, items);
        //Database.addToOrderHistory(order);
    }

    public void cancelOrder() {
        //add code here
    }

    public void approveBooking() {
        //add code here
    }

    public void approveDelivery() {
        //add code here
    }

    public void displayMainMenu() {}

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Waiter");
    }

}
