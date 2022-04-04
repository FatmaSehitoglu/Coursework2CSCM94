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
            }
        }   
    }

    /**
     * View active orders.
     */
    public void viewActiveOrders() {
        String change;
        Lo:
        for (Order order : Database.delivery(Database.getOrderHistory())){
            Delivery delivery = (Delivery)order;
            if (delivery.isDriveComplete()){
                System.out.println(delivery.toString());
                lo:
                while (true) {
                    System.out.println("Have you completed this order? (yes or no)");
                    change = Input.stringInput();
                    if (change.equalsIgnoreCase("yes")) {
                        completeDelivery(delivery, true);
                        break Lo;
                    } else if (change.equalsIgnoreCase("no")) {
                        continue Lo;
                    } else {
                        System.out.println("Incorrect input. Please try again");
                        continue lo;
                    }
                }
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
