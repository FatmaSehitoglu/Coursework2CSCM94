public class Booking {
    private String date;
    private String time;
    private String customerID;
    private boolean approved;
    private int numOfGuests;
    private int duration;

    /**
     * <h1>This class is to make the bookings</h1>
     * @param date
     * @param time
     * @param customerID
     * @param numOfGuests
     * @param duration
     * @param approved
     */
    
    public Booking(String date, String time, String customerID, int numOfGuests) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = false;
        this.duration = 1;
    }

    public Booking(String date, String time, String customerID, boolean approved, int numOfGuests, int duration) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = approved;
        this.duration = duration;
    }

    //SETTERS
    //=======
    public void setDate(String date) {
        this.date = date;
        Database.refreshBookings();
    }

    public void setTime(String time) {
        this.time = time;
        Database.refreshBookings();
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        Database.refreshBookings();
    }

    public void setNumOfGuests(int noOfGuests) {
        this.numOfGuests = noOfGuests;
        Database.refreshBookings();
    }

    public void setDuration(int duration) {
        this.duration = duration;
        Database.refreshBookings();
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
        Database.refreshBookings();
    }

    //GETTERS
    //=======
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getNumOfGuests() {
        return this.numOfGuests;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public boolean isApproved() {
        return approved;
    }
   
    @Override
    public String toString() {
        return "Booking{" +
        "customerID=" + customerID +
        ", date=" + date +
        ", time=" + time +
        ", Guest No=" + numOfGuests +
        ", duration=" + duration +
        ", Order Approved=" + approved +
        '}';
    }

    public String toDataString() {
        /**
         * @param none
         * @return String This formats the output to a String
         */
        return String.format("%s|%s|%s|%b|%d|%d", date, time, customerID, approved, numOfGuests, duration);
    }

}
