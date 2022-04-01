public class Booking {
    private String date;
    private String time;
    private String customerID;
    private boolean approved;
    private int numOfGuests;
    private int duration;
    
    public Booking(String date, String time, String customerID, int numOfGuests) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = false;
        this.duration = 1;
    }

    public Booking(String date, String time, String customerID, boolean approved, int numOfGuests, int duration) {
        this.setDate(date);
        this.setTime(time);
        this.setCustomerID(customerID);
        this.setApproved(approved);
        this.setNumOfGuests(numOfGuests);
        this.setDuration(duration);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getNumOfGuests() {
        return this.numOfGuests;
    }
    public void setNumOfGuests(int noOfGuests) {
        this.numOfGuests = noOfGuests;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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
        return String.format("%s|%s|%s|%s|%s|%s", date, time, customerID, approved, numOfGuests, duration);
    }

}
