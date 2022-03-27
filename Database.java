import java.util.ArrayList;
import java.util.Arrays;

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

    public static void addToOrderHistory(Order newOrder) {
        orderHistory.add(newOrder);
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
    public static int getStaffCount() {
        return staffList.size();
    }

//Menu Database
    public static ArrayList<MenuItem>menuItems = new ArrayList<>(Arrays.asList(new MenuItem(1,
        "Pepperoni", "Pizza"), new MenuItem(2, "Carbonara", "Pasta"),
        new MenuItem(3, "Chicken tomato sauce", "Chicken tomato")));
    public static void addToMenu(MenuItem item){menuItems.add(item);}
    public static ArrayList<MenuItem> getMenu(){return menuItems;};
    public static ArrayList<MenuItem> selectionss = new ArrayList<>();
    public static void addToSelections(MenuItem selections){selectionss.add(selections);}
    public static ArrayList<MenuItem> getSelections(){return selectionss;};

    // return customer history
    public static ArrayList<Order> customerHistory(int custId) {
        ArrayList<Order> custHistory = new ArrayList<Order>();
        for(int i = 0; i < orderHistory.size(); i++  ) {
            Order checking = orderHistory.get(i);
            if( checking.getCustomID() == custId) {
                custHistory.add(checking);
            }
        }
        return custHistory;
    }

    //most active customer
    public static Customer mostActiveCustomer() {
        Customer mostActiveCust = customerList.get(0); // If the customer list is empty error will occur!!!
        int maxSize = 0;
        for(int i = 0; i <customerList.size(); i++) {
            Customer checkingCust = customerList.get(i);
            int size = customerHistory(checkingCust.getCustId()).size();
            if(size > maxSize) {
                maxSize = size;
                mostActiveCust = checkingCust;
            }
        }
        return mostActiveCust;
    }

    

}
