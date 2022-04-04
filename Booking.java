/**
 * <h2>The type Booking.</h2>
 * @version 1.0
 * @author Martin Dimitrov
 * @author Chris Litting
 */
public class Booking {
    private String date;
    private String time;
    private String customerID;
    private boolean approved;
    private int numOfGuests;
    private int duration;

    /**
     * Constructor for new Booking
     *
     * @param date        the date as a String
     * @param time        the time as a String
     * @param customerID  the customer id as a String
     * @param numOfGuests the num of guests as an int
     */
    public Booking(
        String date, 
        String time, 
        String customerID, 
        int numOfGuests
    ) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = false;
        this.duration = 1;
    }

    /**
     * Constructor for Bookings read from Database
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

    /**
     * Sets date
     * @param date as a String
     */
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

    //GETTERS
    //=======

    /**
     * Gets date.
     *
     * @return the date as a String
     */

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
     * Converts Booking to a String (for menu display)
     * @return Booking as a String
     */
    @Override
    public String toString() {
        String status1 = approved ? "Approved" : "Awaiting approval";
        return String.format(
            "Customer ID: %s, Date: %s, Time: %s, Guests: %d, Duration: %d, Status: %s",
            customerID,
            date,
            time,
            numOfGuests,
            duration,
            status1
        );
    }

    /**
     * Convert Booking to a data String (for database storage)
     * @return Booking as a data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%s|%b|%d|%d\n", 
            date, 
            time, 
            customerID, 
            approved, 
            numOfGuests, 
            duration
        );
    }

}
