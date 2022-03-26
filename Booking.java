import java.util.ArrayList;
public class Booking {
    private String date;
    private String time;
    private int customerID;
    private boolean approved;
    public void addBooking(Booking book){
        bookings.add(book);
    }
    ArrayList<Booking> bookings = new ArrayList<>();

    public Booking(String date, String time, int customerID) {
        this.date = date;
        this.time = time;
        this.customerID = customerID;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
