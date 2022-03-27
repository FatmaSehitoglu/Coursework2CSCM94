// import java.util.ArrayList;
public class Customer extends User {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    private String address;
    private String custId;
    //private Order[] orderHistory;

    //CONSTRUCTOR
    //======
    public Customer(String firstName, String lastName, String address, String custId) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setCustId(custId);
    }

    //SETTERS
    //=======
    public void setAddress(String address) {
        this.address = address;
    }

    private void setCustId(String custId) {
        this.custId = custId;
    }

    //GETTERS
    //=======
    public String getAddress() {
        return this.address;
    }

    public String getCustId() {
        return this.custId;
    }

    //METHODS
    //=======

    //public void createNewEvent(){} (not implemented)
    //public void viewEvents(){} (not implemented)
    //public void joinEvent() {} (not implemented)

    public void requestBooking(String date, String time, int noOfGuests) {
        String id = this.custId;
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
