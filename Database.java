import java.util.ArrayList;

public class Database {

    public static void populateDb() {
        populateCustomers();
        populateStaff();
    }

    //BOOKING DATABASE
    //======= ========
    public static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    public static void addToBookingHistory(Booking newBooking) {
        bookingHistory.add(newBooking);
    }
    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }
    //ORDER DATABASE
    //===== ========
    public static ArrayList<Order> orderHistory = new ArrayList<Order>();

    public static void addToOrderHistory(Order newOrder) {
        orderHistory.add(newOrder);
    }
    public static ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    //CUSTOMER DATABASE
    //======== ========
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static void populateCustomers() {
        String[][] str = FileManager.readFromFile("CustomerDb.txt", 4);
        for (int i = 0; i < str.length; i++){
            addToCustomerList(new Customer(str[i][0], str[i][1], str[i][2], str[i][3]));
        }
    }

    public static void addToCustomerList(Customer newCustomer) {
        customerList.add(newCustomer);
    }

    public static void addNewCustomer(Customer newCustomer) {
        addToCustomerList(newCustomer);
        writeCustomer(newCustomer);
    }

    public static void writeCustomer(Customer newCustomer) {
        FileManager.writeToFile("CustomerDb.txt", newCustomer.toDataString());
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    public static boolean checkCustomer(String possibleID) {
        for(int k=0; k < customerList.size(); k++) {
            if(possibleID.equals(customerList.get(k).getId())) {
                return true;
            }
        }
        return false;
    }

    public static Customer getCustomer(String ID) {
        for(int k=0; k < customerList.size(); k++) {
            if(ID.equals(customerList.get(k).getId())) {
                return customerList.get(k);
            }
        }
        return null;
    }

    //STAFF DATABASE
    //===== ========
    public static ArrayList<Staff> staffList = new ArrayList<Staff>();


    public static void addNewStaff(Staff newStaff) {
        addToStaffList(newStaff);
        writeStaff(newStaff);
    }

    public static void writeStaff(Staff newStaff) {
        FileManager.writeToFile("StaffDb.txt", newStaff.toDataString());
    }

    public static void addToStaffList(Staff newStaff) {
        staffList.add(newStaff);
    }

    public static void populateStaff() {
        String[][] str = FileManager.readFromFile("StaffDb.txt", 4);
        for (int i = 0; i < str.length; i++){
            switch (str[i][3]) {
                case "Manager":
                    addToStaffList(new Manager(str[i][0], str[i][1], str[i][2]));
                    break;
                case "Waiter":
                    addToStaffList(new Waiter(str[i][0], str[i][1], str[i][2]));
                    break;
                case "Chef":
                    addToStaffList(new Chef(str[i][0], str[i][1], str[i][2]));
                    break;
                case "Driver":
                    addToStaffList(new Driver(str[i][0], str[i][1], str[i][2]));
                    break;    
            }
            
        }
    }


    public static ArrayList<Staff> getStaffList() {
        return staffList;
    }
    public static int getStaffCount() {
        return staffList.size();
    }
    public static boolean checkStaff(String possibleID) {
        for(int k=0; k < staffList.size(); k++) {
            if(possibleID.equals(staffList.get(k).getId())) {
                return true;
            }
        }
        return false;
    }
    public static Staff getStaff(String ID) {
        for(int k=0; k < staffList.size(); k++) {
            if(ID.equals(staffList.get(k).getId())) {
                return staffList.get(k);
            }
        }
        return null;
    }

    //MENU ITEMS DATABASE
    //==== ===== ========
    public static ArrayList<MenuItem>menuItems = new ArrayList<>();
    
    public static void addToMenu(MenuItem item){menuItems.add(item);}
    public static ArrayList<MenuItem> getMenu(){return menuItems;};
    public static ArrayList<MenuItem> selectionss = new ArrayList<>();
    public static void addToSelections(MenuItem selections){selectionss.add(selections);}
    public static ArrayList<MenuItem> getSelections(){return selectionss;};

    // return customer history
    public static ArrayList<Order> customerHistory(String custId) {
        ArrayList<Order> custHistory = new ArrayList<Order>();
        for(int i = 0; i < orderHistory.size(); i++  ) {
            Order checking = orderHistory.get(i);
            if( checking.getCustomID().equals(custId)) {
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
            int size = customerHistory(checkingCust.getId()).size();
            if(size > maxSize) {
                maxSize = size;
                mostActiveCust = checkingCust;
            }
        }
        return mostActiveCust;
    }

    

}
