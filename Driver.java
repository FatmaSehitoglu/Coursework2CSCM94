/**
 * The type Driver.
 */
public class Driver extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    

    /**
     * Instantiates a new Driver.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param id        the id
     */
//CONSTRUCTOR
    //===========
    public Driver(String firstName, String lastName, String id) {
        super(firstName, lastName, id);
    }

    //METHODS
    //=======

    /**
     * <h1>This method displays menu interface</h1>
     * @param none
     * @return none
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
        for (Order order : Database.delivery(Database.orderHistory)){
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
     * @param delivery the delivery
     * @param finish   the finish
     */
    public void completeDelivery(Delivery delivery, boolean finish) {
        delivery.setDriveComplete(finish);
        System.out.println("successful!");
    }


    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Driver");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s\n", this.getFirstName(), this.getLastName(), this.getId(), "Driver");
    }
   

}
