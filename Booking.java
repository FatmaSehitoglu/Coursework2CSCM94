import java.util.ArrayList;
public class Booking {
    private String date;
    private String time;
    private int customerID;
    private boolean approved;
    private int numOfGuests;
    private int duration;

    public void addReservation(Table reservation){
        reservations.add(reservation);
    }
    public Booking(String date, String time, int customerID,int numOfGuests) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
        this.numOfGuests = numOfGuests;
        this.approved = false;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
