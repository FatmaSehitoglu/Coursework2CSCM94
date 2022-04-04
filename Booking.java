/**
 * The type Booking.
 * @version 1.0
 * @author Martin and others
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
     * @param date        the date as a String
     * @param time        the time as a String
     * @param customerID  the customer id as a String
     * @param numOfGuests the num of guests as an int
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
     * @param date        the date as a String
     * @param time        the time as a String
     * @param customerID  the customer id as a String
     * @param approved    the approved as a boolean
     * @param numOfGuests the num of guests as an int
     * @param duration    the duration as an int
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
     * @param time the time as a String
     */
    public void setTime(String time) {
        this.time = time;
        Database.refreshBookings();
    }

    /**
     * Sets customer id.
     *
     * @param customerID the customer id as a String
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
        Database.refreshBookings();
    }

    /**
     * Sets num of guests.
     *
     * @param noOfGuests the no of guests as an int
     */
    public void setNumOfGuests(int noOfGuests) {
        this.numOfGuests = noOfGuests;
        Database.refreshBookings();
    }

    /**
     * Sets duration.
     *
     * @param duration the duration as an int
     */
    public void setDuration(int duration) {
        this.duration = duration;
        Database.refreshBookings();
    }

    /**
     * Sets approved.
     *
     * @param approved the approved as a boolean
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
        Database.refreshBookings();
    }

    /**
     * Gets date.
     *
     * @return the date as a String
     */
//GETTERS
    //=======
    public String getDate() {
        return date;
    }

    /**
     * Gets time.
     *
     * @return the time as a String
     */
    public String getTime() {
        return time;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id as a String
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Gets num of guests.
     *
     * @return the num of guests as an int
     */
    public int getNumOfGuests() {
        return this.numOfGuests;
    }

    /**
     * Gets duration.
     *
     * @return the duration as an int
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Is approved boolean.
     *
     * @return the boolean as a boolean
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * This method formats the output to a string
     * @return String outpu
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
