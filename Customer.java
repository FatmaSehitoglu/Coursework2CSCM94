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

    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            //request booking
            //cancel booking
            //place delivery order
            //place takeaway order
        }
    } 

    public void requestBooking(String date, String time, int noOfGuests) {
        /**
         * @params String date
         * @params String time
         * @params int noOfGuests
         * @return none
         */
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

    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }

   

    public String toDataString() {
        return this.getFirstName() + "|" + this.getLastName() + "|" + this.getAddress() + "|" + this.getId() + "\r\n";
    }

}
