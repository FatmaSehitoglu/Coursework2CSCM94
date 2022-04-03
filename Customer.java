//import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.time.LocalDateTime;
public class Customer extends User {

    //FIELDS
    //======
    //private String firstName     (inherited)
    //private String lastName      (inherited)
    //private String id            (inherited)
    private String address;
    //private Order[] orderHistory;

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param id
     */
    //CONSTRUCTOR
    //======
    public Customer(String firstName, String lastName, String address, String id) {
        super(firstName, lastName, id);
        this.address = address;
    }

    //SETTERS
    //=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Database.refreshCustomers();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        Database.refreshCustomers();
    }

    public void setId(String id) {
        this.id = id;
        Database.refreshCustomers();
    }

    public void setAddress(String address) {
        this.address = address;
        Database.refreshCustomers();
    }

    //GETTERS
    //=======
    public String getAddress() {
        return this.address;
    }

    //METHODS
    //=======

    //public void createNewEvent(){} (not implemented)
    //public void viewEvents(){} (not implemented)
    //public void joinEvent() {} (not implemented)

    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Request a new Booking");
            System.out.println("2. Cancel an existing Booking");
            System.out.println("3. Place a delivery order");
            System.out.println("4. Place a takeaway order");
            System.out.println("0. Exit");
            int select = Input.intInput(0,4 );
            switch (select) {
                case 1:
                    requestBooking();

                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:

                    break;
                case 0:
                    cont = false;
                    break;
            //request booking
            //cancel booking
            //place delivery order
            //place takeaway order
            }
        }
    } 

    public void requestBooking() {
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
        System.out.println("Press 1 if you want to keep a 1 hour booking and 2 if you want to change the duration of the booking");
        duration = Input.intInput(1, 2);
        if(duration == 2) {
            System.out.println("How many hours would you like the booking to be?");
            duration = Input.intInput(1, 12);
        }
        Booking booking = new Booking(date, time, this.id, false, noOfguests, duration);
        Database.newBooking(booking);
    }

    public void cancelBooking() {
        //add code here
    }

    public void placeDeliveryOrder() {
        //add code here
    }

    public void placeTakeAwayOrder() {
        System.out.println("Please select items for your Take Away order");
        ArrayList<MenuItem> selection = new ArrayList<MenuItem>();
        selection = Menu.selectFromMenu();
        System.out.println("Please enter the pick up time for your order");
        String time = Input.stringInput();
        Takeaway order = new Takeaway(this.id, selection, false, LocalDateTime.now(), false, true, time);
        Database.newOrder(order);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }

   

    public String toDataString() {
        return this.getFirstName() + "|" + this.getLastName() + "|" + this.getAddress() + "|" + this.getId() + "\r\n";
    }

}
