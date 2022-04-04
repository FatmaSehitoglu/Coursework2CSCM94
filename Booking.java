/**
 * The type Booking.
 */
public class Booking {
    private String date;
    private String time;
    private String customerID;
    private boolean approved;
    private int numOfGuests;
    private int duration;

    /**
     * <h1>This class is to make the bookings</h1>
     *
     * @param date        the date
     * @param time        the time
     * @param customerID  the customer id
     * @param numOfGuests the num of guests
     */
    public Booking(String date, String time, String customerID, int numOfGuests) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = false;
        this.duration = 1;
    }


    /**
     * Instantiates a new Booking.
     *
     * @param date        the date
     * @param time        the time
     * @param customerID  the customer id
     * @param approved    the approved
     * @param numOfGuests the num of guests
     * @param duration    the duration
     */
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

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
        Database.refreshBookings();
    }

    /**
     * Sets customer id.
     *
     * @param customerID the customer id
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        Database.refreshBookings();
    }

    /**
     * Sets num of guests.
     *
     * @param noOfGuests the no of guests
     */
    public void setNumOfGuests(int noOfGuests) {
        this.numOfGuests = noOfGuests;
        Database.refreshBookings();
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
        Database.refreshBookings();
    }

    /**
     * Sets approved.
     *
     * @param approved the approved
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
        Database.refreshBookings();
    }

    /**
     * Gets date.
     *
     * @return the date
     */
//GETTERS
    //=======
    public String getDate() {
        return date;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Gets num of guests.
     *
     * @return the num of guests
     */
    public int getNumOfGuests() {
        return this.numOfGuests;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Is approved boolean.
     *
     * @return the boolean
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * This method formats the output to a string
     * @return
     */
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

    /**
     * This method formats the output
     *
     * @return String formatted
     */
    public String toDataString() {
        /**
         * @param none
         * @return String This formats the output to a String
         */
        return String.format("%s|%s|%s|%b|%d|%d\n", date, time, customerID, approved, numOfGuests, duration);
    }

}
