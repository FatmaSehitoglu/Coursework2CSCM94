import java.util.ArrayList;

/**
 * <h2>Waiter class</h2>
 * A subclass of Staff
 * @author Fatma Sehitoglu
 */
public class Waiter extends Staff {
    
    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Waiter
     * @param firstName as a String
     * @param lastName  as a String
     * @param staffId   as a String
     */
    public Waiter(
        String firstName, 
        String lastName, 
        String staffId
    ) {
        super(firstName, lastName, staffId);
    }

    //METHODS
    //=======

    /**
     * Displays main menu for Waiter
     */
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("Profile : " + toDataString());  
            System.out.println("1. New Eat In Order");
            System.out.println("2. View Active Orders");
            System.out.println("3. View Booking");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 3);

            switch (select) {
                case 1:
                    newEatInOrder();
                    break;
                case 2:
                    viewActiveOrders();
                    break;
                case 3:
                    viewBookings();
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
     * A method to create a new Eat In Order
     */
    public void newEatInOrder() {
        int tableId = -1;
        System.out.println("Enter customer id:");
        String cID = Input.stringInput();
        ArrayList<MenuItem> selection = new ArrayList<MenuItem>();
        selection = Menu.selectFromMenu();
        EatIn order = new EatIn(cID, selection, true, tableId, this.id);
        Database.addToOrderHistory(order);
    }

    /**
     * A method to view the active orders
     */
    public void viewActiveOrders() {
        int con = -1;
        while (!(con==0)) {
            for (int i=0; i<Database.getOrderHistory().size(); i++) {
                if (!Database.getOrderHistory().get(i).isOrderComplete()) {
                    System.out.println((i+1) + "- " + Database.getOrderHistory().get(i).toString());
                } 
            }
            System.out.println("1. Approve a delivery");
            System.out.println("2. Cancel an order ");
            System.out.println("0. Back");
            int select = Input.intInput(0, 2);
            switch (select) {
                case 1:
                    System.out.println("Select a delivery to approve");
                    int app = Input.intInput(1, Database.getOrderHistory().size() + 1);
                    Database.getOrderHistory().get(app - 1).setApproval(true);
                    System.out.println("Choose a driver to this delivery");
                    for(int i = 0; i< Database.getStaffCount(); i++) {
                        if(Database.getStaffList().get(i).getClass() == Waiter.class) {
                            System.out.println(i + "- " + 
                            Database.getStaffList().get(i).toString());
                        }
                    }
                    int driver = Input.intInput(0, Database.getStaffCount());
                    Delivery delivery = (Delivery)Database.getOrderHistory().get(app - 1);
                    delivery.setDriveID(Database.getStaffList().get(driver).getId());
                    break;
                case 2:
                    System.out.println("Select an order to cancel");
                    int cancel = Input.intInput(1, Database.getOrderHistory().size() + 1);
                    cancelOrder(Database.getOrderHistory().get(cancel-1));
                    break;
                case 0:
                    con = 0;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * This method is used to view all bookings
     */
    public void viewBookings() {
        int bookingToApprove = -1;
        while (!(bookingToApprove==0)) {
            System.out.println("Select a Booking to Approve");
            for (int i = 0; i<Database.getBookingHistory().size(); i++) {
                System.out.println(i+1 + " : " + Database.getBookingHistory().get(i).toString());
            }
            System.out.println("Select a Booking to Approve or press 0 to go back");
            bookingToApprove = Input.intInput(0, Database.getBookingHistory().size()+1);
            if (!(bookingToApprove == 0)) {
                Database.getBookingHistory().get(bookingToApprove-1).setApproved(true);
            }else {
                break;
            }    
        }               
    }

    /**
     * This method cancels an order
     * @param order as an Order
     */
    public void cancelOrder(Order order) {
        for (int i=0; i<Database.getOrderHistory().size(); i++) {
            if (order.equals(Database.getOrderHistory().get(i))) {
                Database.getOrderHistory().remove(i);
            }
        }
    }

    /**
     * Approves an existing Booking
     * @param booking as a Booking
     */
    public void approveBooking(Booking booking) {
        booking.setApproved(true);
    }

    /**
     * Approves an existing Delivery
     * @param delivery as a Delivery
     */
    public void approveDelivery(Delivery delivery) {
        delivery.setApproval(true);
    }

    /**
     * toString method for Waiter (for menu displays)
     * @return Waiter as a String
     */
    @Override
    public String toString() {
        return String.format(
            "%s %s, %s", 
            this.getFirstName(), 
            this.getLastName(), 
            "Waiter"
        );
    }

    /**
     * Converts Waiter to a data String (for database storage)
     * @return Waiter as a data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%s|%s\n", 
            this.getFirstName(), 
            this.getLastName(), 
            this.getId(), 
            "Waiter"
        );
    }

}
