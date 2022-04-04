import java.util.ArrayList;

/**
 * <h2>Driver class</h2>
 * A subclass of Staff
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @author Niu Zhaoye
 * @version 1.0
 */
public class Driver extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    

    //CONSTRUCTORS
    //============
    
    /**
     * Constructor for new Driver.
     * @param firstName as a String
     * @param lastName  as a String
     * @param id        as a String
     */
    public Driver(
        String firstName, 
        String lastName, 
        String id
    ) {
        super(firstName, lastName, id);
    }

    //METHODS
    //=======

    /**
     * Displays main menu for Driver
     */
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {  
            System.out.println("1. View Active Orders");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 1);

            switch (select) {
                case 1:
                    viewActiveOrders();
                    break;
                case 0:
                    cont = false;
                    break;
                default:
                    break;
            }
        }   
    }

    /**
     * View active delivery orders.
     */
    public void viewActiveOrders() {
        boolean cont = true;
        while (cont) {
            ArrayList<Order> activeDeliveries = Database.activeDelivery();
            for (int i = 0; i < activeDeliveries.size(); i++) {
                System.out.println((i + 1) + ". " + activeDeliveries.get(i).toString());
            }
            System.out.println("1. Complete a delivery");
            System.out.println("0. Back");

            int select = Input.intInput(0, 1);
            if (select == 0) {
                cont = false;
            } else {
                System.out.println("Enter delivery to complete:");
                select = Input.intInput(1, activeDeliveries.size() + 1);
                Delivery x = (Delivery)activeDeliveries.get(select - 1);
                x.setDriveComplete(true);
            }
        }
        
    }

    /**
     * Complete delivery.
     *
     * @param delivery as a Delivery
     * @param finish   as a boolean
     */
    public void completeDelivery(Delivery delivery, boolean finish) {
        delivery.setDriveComplete(finish);
        System.out.println("successful!");
    }


    /**
     * toString method for Driver (for menu displays)
     * @return Driver as a String
     */
    @Override
    public String toString() {
        return String.format(
            "%s %s, %s", 
            this.getFirstName(), 
            this.getLastName(), 
            "Driver"
        );
    }

    /**
     * Converts Driver to data String (for database storage)
     * @return Driver as data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%s|%s\n", 
            this.getFirstName(), 
            this.getLastName(), 
            this.getId(), 
            "Driver"
        );
    }
   
}
