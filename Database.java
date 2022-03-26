import java.util.ArrayList;

public class Database {
//Booking Database
    public static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    public static void addToBookingHistory(Booking newBooking) {
        bookingHistory.add(newBooking);
    }
    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }
//Order Database
    public static ArrayList<Order> orderHistory = new ArrayList<Order>();

    public static void addToOrderHistory(Booking newOrder) {
        bookingHistory.add(newOrder);
    }
    public static ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

//Customer Database
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static void addToCustomerList(Customer newCustomer) {
        customerList.add(newCustomer);
    }
    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

//Staff Database
    public static ArrayList<Staff> staffList = new ArrayList<Staff>();

    public static void addToStaffList(Staff newStaff) {
        staffList.add(newStaff);
    }
    public static ArrayList<Staff> getStaffList() {
        return staffList;
    }


    //FIELDS
    //======
    public static Order[] orders;
    public static Booking[] bookings;
    public static Customer[] customers;
    public static Staff[] staff;
    public static MenuItem[] menuItems;

    

}
