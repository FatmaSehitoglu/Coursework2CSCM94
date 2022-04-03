import java.util.ArrayList;

public class Database {

    public static void populateDb() {
        populateCustomers();
        populateStaff();
        populateMenuItems();
        populateBookings();
        populateOrders();
    }

    /**
     * @param none
     * @return none
     */

    //BOOKING DATABASE
    //======= ========
    public static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    public static void newBooking(Booking newBooking) {
        addToBookingHistory(newBooking);
        writeBooking(newBooking);
    }

    public static void addToBookingHistory(Booking newBooking) {
        bookingHistory.add(newBooking);
    }
    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public static void refreshBookings() {
        FileManager.clearFile("BookingDB.txt");
        for (int i = 0; i < bookingHistory.size(); i++) {
            writeBooking(bookingHistory.get(i));
        }
    }

    public static void writeBooking(Booking booking) {
        FileManager.writeToFile("BookingDb.txt", booking.toDataString());
    }

    public static void populateBookings() {
        String[][] str = FileManager.readFromFile("BookingDb.txt", 6);
        for (int i = 0; i < str.length; i++){
            addToBookingHistory(new Booking(str[i][0], str[i][1], str[i][2], Boolean.parseBoolean(str[i][3]), Integer.parseInt(str[i][4]), Integer.parseInt(str[i][5])));
        }
    }

   public static ArrayList<Booking> getBookings(String custId) {
        ArrayList<Booking> selection = new ArrayList<Booking>();
            for (int i = 0; i < bookingHistory.size(); i++) {
                if (bookingHistory.get(i).getCustomerID().equals(custId)) {
                    selection.add(bookingHistory.get(i));
                }
            }
        return selection;
   }

   public static void removeBooking(Booking booking) {
        /*for (int i = 0; i < bookingHistory.size(); i++) {
            if (bookingHistory.get(i).equals(booking)) {
                bookingHistory.remove(i);
            }
        }*/
        bookingHistory.remove(booking);
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

    public static void newOrder(Order newOrder) {
        addToOrderHistory(newOrder);
        writeOrder(newOrder);
    }

    public static void refreshOrders() {
        FileManager.clearFile("EatInOrderDB.txt");
        FileManager.clearFile("TakeawayOrderDB.txt");
        FileManager.clearFile("DeliveryOrderDB.txt");
        for (int i = 0; i < orderHistory.size(); i++) {
            writeOrder(orderHistory.get(i));
        }
    }

    public static void writeOrder(Order order) {
        if(order.getClass() == Eat_in.class) {
            writeEatInOrder((Eat_in) order);
        }else if(order.getClass() == Takeaway.class) {
            writeTakeawayOrder((Takeaway) order);
        }else if(order.getClass() == Delivery.class) {
            writeDeliveryOrder((Delivery) order);
        }
    }

    public static void writeEatInOrder(Eat_in eatIn) {
        FileManager.writeToFile("EatInOrderDb.txt", eatIn.toDataString());
    }

    public static void writeTakeawayOrder(Takeaway takeaway) {
        FileManager.writeToFile("TakeawayOrderDb.txt", takeaway.toDataString());
    }

    public static void writeDeliveryOrder(Delivery delivery) {
        FileManager.writeToFile("DeliveryOrderDb.txt", delivery.toDataString());
    }

    public static void populateOrders() {
        populateEatInOrders();
        populateTakeawayOrders();
        populateDeliveryOrders();
    }

    public static void populateEatInOrders() {
        String[][] str = FileManager.readFromFile("EatInOrderDb.txt", 8);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new Eat_in(str[i][0], FileManager.getItemsFromIds(str[i][1]), Boolean.parseBoolean(str[i][2]), FileManager.StringToLocalDateTime(str[i][3]), Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]), Integer.parseInt(str[i][6]), str[i][7]));
        }
    }

    public static void populateTakeawayOrders() {
        String[][] str = FileManager.readFromFile("TakeawayOrderDb.txt", 7);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new Takeaway(str[i][0], FileManager.getItemsFromIds(str[i][1]), Boolean.parseBoolean(str[i][2]), FileManager.StringToLocalDateTime(str[i][3]), Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]), (str[i][6])));
        }
    }

    public static void populateDeliveryOrders() {
        String[][] str = FileManager.readFromFile("DeliveryOrderDb.txt", 9);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new Delivery(str[i][0], FileManager.getItemsFromIds(str[i][1]), Boolean.parseBoolean(str[i][2]), FileManager.StringToLocalDateTime(str[i][3]), Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]), str[i][6], str[i][7], Boolean.parseBoolean(str[i][8])));
        }
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

    public static void refreshCustomers() {
        FileManager.clearFile("CustomerDB.txt");
        for (int i = 0; i < customerList.size(); i++) {
            writeCustomer(customerList.get(i));
        }
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

    public static void refreshStaff() {
        FileManager.clearFile("StaffDB.txt");
        for (int i = 0; i < staffList.size(); i++) {
            writeStaff(staffList.get(i));
        }
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
        for(int k = 0; k < staffList.size(); k++) {
            if(possibleID.equals(staffList.get(k).getId())) {
                return true;
            }
        }
        return false;
    }

    public static Staff getStaff(String ID) {
        for(int k = 0; k < staffList.size(); k++) {
            if(ID.equals(staffList.get(k).getId())) {
                return staffList.get(k);
            }
        }
        return null;
    }

    //MENU ITEMS DATABASE
    //==== ===== ========
    public static ArrayList<MenuItem>menuItems = new ArrayList<>();
    
    public static void populateMenuItems() {
        String[][] str = FileManager.readFromFile("MenuItemDb.txt", 5);
        for (int i = 0; i < str.length; i++) {
            addToMenu(new MenuItem(Integer.parseInt(str[i][0]), str[i][1], str[i][2], Boolean.parseBoolean(str[i][3]), Boolean.parseBoolean(str[i][4])));
        }
    }

    public static void newMenuItem(MenuItem newMenuItem) {
        addToMenu(newMenuItem);
        writeMenuItem(newMenuItem);
    }

    public static void addToMenu(MenuItem item){menuItems.add(item);}

    public static void refreshMenuItems() {
        FileManager.clearFile("MenuItemDB.txt");
        for (int i = 0; i < menuItems.size(); i++) {
            writeMenuItem(menuItems.get(i));
        }
    }

    public static void writeMenuItem(MenuItem menuItem) {
        FileManager.writeToFile("menuItemDb.txt", menuItem.toDataString());
    }

    public static ArrayList<MenuItem> getMenu(){return menuItems;};

    public static ArrayList<MenuItem> getSpecials() {
        ArrayList<MenuItem>specials = new ArrayList<>();
        for(int i=0; i<menuItems.size(); i++) {
            if(menuItems.get(i).getIsSpecial()) {
                specials.add(menuItems.get(i));
            }
        }
        return specials;
    }
    public static ArrayList<MenuItem> getActiveMenu() {
        ArrayList<MenuItem>activeMenu = new ArrayList<>();
        for(int i=0; i<menuItems.size(); i++) {
            if(menuItems.get(i).getInMenu()) {
                activeMenu.add(menuItems.get(i));
            }
        }
        return activeMenu;
    }

    public static MenuItem getItem(int ID) {
        for(int k = 0; k < menuItems.size(); k++) {
            if(ID == menuItems.get(k).getID()) {
                return menuItems.get(k);
            }
        }
        return null;
    }

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
