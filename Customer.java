import java.util.ArrayList;
public class Customer extends User {

    public int getCustID() {
		return this.custId;
	}
    //FIELDS
    //======
    private String address;
    private int custId;
    //private Order[] orderHistory;

    //CONSTRUCTOR
    //======
    public Customer(String firstName, String lastName, String address, int custId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.custId = custId;
    }

    //SETTERS
    //=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;   
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //GETTERS
    //=======
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public int getCustId() {
        return this.custId;
    }

    //METHODS
    //=======

    //public void createNewEvent(){} (not implemented)
    //public void viewEvents(){} (not implemented)
    //public void joinEvent() {} (not implemented)

    public void requestBooking(String date, String time, int noOfGuests) {
        int id = this.custId;
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

}
