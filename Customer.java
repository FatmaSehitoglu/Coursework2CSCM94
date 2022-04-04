import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * <h2>Customer class</h2>
 * A subclass of User
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @version 1.0
 */
public class Customer extends User {

    //FIELDS
    //======
    //private String firstName     (inherited)
    //private String lastName      (inherited)
    //private String id            (inherited)
    private String address;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for Customer class
     * @param firstName as a String
     * @param lastName  as a String
     * @param address   as a String
     * @param id        as a String
     */
    public Customer(
        String firstName, 
        String lastName, 
        String address, 
        String id
    ) {
        super(firstName, lastName, id);
        this.address = address;
    }

    //SETTERS
    //=======

    /**
     * Sets firstName
     * @param firstName as a String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Database.refreshCustomers();
    }

    /**
     * Sets lastName
     * @param lastName as a String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
        Database.refreshCustomers();
    }

    /**
     * Sets id
     * @param id as a String
     */
    public void setId(String id) {
        this.id = id;
        Database.refreshCustomers();
    }

    /**
     * Sets address
     * @param address as a String
     */
    public void setAddress(String address) {
        this.address = address;
        Database.refreshCustomers();
    }

    //GETTERS
    //=======

    /**
     * Gets address
     * @return address as a String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets id
     * @return id as a String
     */
    public String getID() {
        return this.id;
    }

    //METHODS
    //=======

    //public void createNewEvent(){}    (not implemented)
    //public void viewEvents(){}        (not implemented)
    //public void joinEvent() {}        (not implemented)

    /**
     * Main menu display for Customer after login
     */
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Request a new Booking");
            System.out.println("2. Cancel an existing Booking");
            System.out.println("3. Place a delivery order");
            System.out.println("4. Place a takeaway order");
            System.out.println("5. See order history");
            System.out.println("0. Exit");
            int select = Input.intInput(0, 5);
            switch (select) {
                case 1:
                    requestBooking();
                    break;
                case 2:
                    cancelBooking();
                    break;
                case 3:
                    placeDeliveryOrder();
                    break;
                case 4:
                    placeTakeAwayOrder();
                    break;
                case 5:
                    orderHistory();
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
     * Request booking menu for Customer
     */
    private void requestBooking() {
        String date;
        String time;
        int noOfguests;
        int duration;
        System.out.println("Please enter the date of your booking");
        date = Input.stringInput();
        System.out.println("Please enter the time of your booking");
        time = Input.stringInput();
        System.out.println("Please enter the number of guests");
        noOfguests = Input.intInput(1, 100);
        System.out.println("Press 1 if you want to keep a 1 hour booking and 2 "
                + "if you want to change the duration of the booking");
        duration = Input.intInput(1, 2);
        if (duration == 2) {
            System.out.println("How many hours would you like the booking to be?");
            duration = Input.intInput(1, 12);
        }
        Booking booking = new Booking(date, time, this.id, false, noOfguests, duration);
        Database.newBooking(booking);
    }

    /**
     * Cancel booking menu for Customer
     */
    private void cancelBooking() {
        boolean cont = true;
        while (cont) {
            ArrayList<Booking> bookings = Database.getBookings(this.id);
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i + 1) + ". " + bookings.get(i).toString());
            }
            System.out.println("0. Back");
            int select = Input.intInput(0, bookings.size());
            if (select == 0) {
                cont = false;
            } else {
                System.out.println("Are you sure you want to delete this booking?");
                System.out.println("1. YES");
                System.out.println("0. NO");
                select = Input.intInput(0, 1);
                if (select == 1) {
                    Database.removeBooking(bookings.get(select - 1));
                }
            }
        }
    }

    /**
     * Place delivery order menu for Customer
     */
    private void placeDeliveryOrder() {
        System.out.println("Please select items for your Delivery order");
        ArrayList<MenuItem> selection = new ArrayList<MenuItem>();
        selection = Menu.selectFromMenu();
        System.out.println(this.getAddress() + "\n");
        System.out.println("1. Use this address");
        System.out.println("2. Input different address");
        int select = Input.intInput(1, 2);
        String address = "";
        if (select == 1) {
            address = this.address;
        } else {
            System.out.println("Enter delivery address: ");
            address = Input.stringInput();
        }
        Database.newOrder(new Delivery(this.id, selection, false, address, ""));
    }

    /**
     * Place take away order menu for Customer
     */
    private void placeTakeAwayOrder() {
        System.out.println("Please select items for your Take Away order");
        ArrayList<MenuItem> selection = new ArrayList<MenuItem>();
        selection = Menu.selectFromMenu();
        System.out.println("Please enter the pick up time for your order");
        String time = Input.stringInput();
        Takeaway order = new Takeaway(this.id, selection, false, LocalDateTime.now(),
                false, true, time);
        Database.newOrder(order);
    }

    /**
     * Prints Customer's Order History
     */
    public void orderHistory() {
        for (int i=0; i<Database.getOrderHistory().size(); i++) {
            String checkingID = Database.getOrderHistory().get(i).getCustomID();
            if (checkingID.equals(this.id)) {
                System.out.println(i + "- " 
                + Database.getOrderHistory().get(i).toString());
            }
        }
    }

    /**
     * toString method for Customer (for menu displays)
     * @return Customer as a String
     */
    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }


    /**
     * Converts Customer to a data String for writing to Database
     * @return Customer as a data String
     */
    public String toDataString() {
        return this.getFirstName() + "|" + this.getLastName() + "|" + this.getAddress() + "|" + this.getId() + "\n";
    }

}
