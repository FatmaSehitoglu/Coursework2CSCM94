public class Customer extends User {
    String address;
    int custId;
    Order[] orderHistory;

    public Customer(String firstName, String lastName, String address, int custId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.custId = custId;
    }

    //public void createNewEvent(){} (not implemented)
    //public void viewEvents(){} (not implemented)
    //public void joinEvent() {} (not implemented)

    public void requestBooking() {
        //add code here
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
