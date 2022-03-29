
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
    public Waiter(String firstName, String lastName, String staffId) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(staffId);
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
        // Menu.selectFromMenu();


        //Order order = new Eat_in(tableId, waiterId, items);
        //Database.addToOrderHistory(order);
    }

    public void cancelOrder(Order order) {
        for(int i=0; i<Database.orderHistory.size(); i++) {
            if(order.equals(Database.orderHistory.get(i))) {
                Database.orderHistory.remove(i);
            }
        }
    }

    public void approveBooking(Booking booking) {
        booking.setApproved(true);
    }

    public void approveDelivery(Delivery delivery) {
        delivery.setApproval(true);
    }

    public void displayMainMenu() {}

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Waiter");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s", this.getFirstName(), this.getLastName(), this.getId(), "Waiter");
    }

}
