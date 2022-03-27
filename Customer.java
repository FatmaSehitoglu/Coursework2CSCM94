// import java.util.ArrayList;
public class Customer extends User {

    //FIELDS
    //======
    //private String firstName     (inherited)
    //private String lastName      (inherited)
    //private String id            (inherited)
    private String address;
    //private Order[] orderHistory;

    //CONSTRUCTOR
    //======
    public Customer(String firstName, String lastName, String address, String id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setId(id);
    }

    //SETTERS
    //=======
    public void setAddress(String address) {
        this.address = address;
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

    public void requestBooking(String date, String time, int noOfGuests) {
        String id = this.getId();
        Booking newBooking = new Booking(date, time, id, noOfGuests);
        Database.addToBookingHistory(newBooking);
        
    }

    public void cancelBooking() {
        //add code here
    }

    public void placeDeliveryOrder() {
        //add code here
    }

    public void placeTakeAwayOrder() {
        //add code here
    }

    public void displayMainMenu() {}

}
