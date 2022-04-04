import java.util.ArrayList;

/**
 * <h2>The type Database.</h2>
 * @version 1.0
 * @author Christ
 * @author Fatma
 * @author Martin
 * @author Niu
 */
public class Database {

    /**
     * Populate the database.
     */
    public static void populateDb() {
        populateCustomers();
        populateStaff();
        populateMenuItems();
        populateBookings();
        populateOrders();
    }

    /**
     * The constant bookingHistory.
     *
     * @param none
     * @return none
     */
//BOOKING DATABASE
    //======= ========
    private static ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    /**
     * New booking.
     *
     * @param newBooking the new booking as an object of Booking
     */
    public static void newBooking(Booking newBooking) {
        addToBookingHistory(newBooking);
        writeBooking(newBooking);
    }

    /**
     * Add to booking history.
     *
     * @param newBooking the new booking as an object of Booking
     */
    public static void addToBookingHistory(Booking newBooking) {
        bookingHistory.add(newBooking);
    }

    /**
     * Gets booking history.
     *
     * @return the booking history as an Arraylist of objects Booking
     */
    public static ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    /**
     * Refresh bookings.
     */
    public static void refreshBookings() {
        FileManager.clearFile("BookingDB.txt");
        for (int i = 0; i < bookingHistory.size(); i++) {
            writeBooking(bookingHistory.get(i));
        }
    }

    /**
     * Write booking.
     *
     * @param booking the booking as an object of Booking
     */
    public static void writeBooking(Booking booking) {
        FileManager.writeToFile("BookingDb.txt", booking.toDataString());
    }

    /**
     * Populate bookings.
     */
    public static void populateBookings() {
        String[][] str = FileManager.readFromFile("BookingDb.txt", 6);
        for (int i = 0; i < str.length; i++){
            addToBookingHistory(new Booking(str[i][0], str[i][1], str[i][2], Boolean.parseBoolean(str[i][3]),
                    Integer.parseInt(str[i][4]), Integer.parseInt(str[i][5])));
        }
    }

    /**
     * Gets bookings.
     *
     * @param custId the cust id as a String
     * @return the bookings as an Arraylist of objects Booking
     */
    public static ArrayList<Booking> getBookings(String custId) {
        ArrayList<Booking> selection = new ArrayList<Booking>();
            for (int i = 0; i < bookingHistory.size(); i++) {
                if (bookingHistory.get(i).getCustomerID().equals(custId)) {
                    selection.add(bookingHistory.get(i));
                }
            }
        return selection;
   }

    /**
     * Remove booking.
     *
     * @param booking the booking as an object Booking
     */
    public static void removeBooking(Booking booking) {
        /*for (int i = 0; i < bookingHistory.size(); i++) {
            if (bookingHistory.get(i).equals(booking)) {
                bookingHistory.remove(i);
            }
        }*/
        bookingHistory.remove(booking);
   }


    /**
     * The constant orderHistory.
     */
//ORDER DATABASE
    //===== ========
    private static ArrayList<Order> orderHistory = new ArrayList<Order>();

    /**
     * Delivery array list.
     *
     * @param orderHistory the order history as an Arraylist of objects of class Order
     * @return deliveryList as an ArrayList of objects of class Order
     */
    public static ArrayList<Order> delivery(ArrayList<Order> orderHistory){
        ArrayList<Order> deliveryList = new ArrayList<>();
        for (Order order : orderHistory){
            if (order.getClass() == Delivery.class){
                deliveryList.add(order);
            }
        }
        return deliveryList;
    }

    /**
     * Add to order history.
     *
     * @param newOrder the new order as an Object of Order
     */
    public static void addToOrderHistory(Order newOrder) {
        orderHistory.add(newOrder);
    }

    /**
     * Gets order history.
     *
     * @return the order history as an Arraylist of objects Order
     */
    public static ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * New order.
     *
     * @param newOrder the new order as an object Order
     */
    public static void newOrder(Order newOrder) {
        addToOrderHistory(newOrder);
        writeOrder(newOrder);
    }

    /**
     * Refresh orders.
     */
    public static void refreshOrders() {
        FileManager.clearFile("EatInOrderDB.txt");
        FileManager.clearFile("TakeawayOrderDB.txt");
        FileManager.clearFile("DeliveryOrderDB.txt");
        for (int i = 0; i < orderHistory.size(); i++) {
            writeOrder(orderHistory.get(i));
        }
    }

    /**
     * Write order.
     *
     * @param order the order as an object of Order
     */
    public static void writeOrder(Order order) {
        if (order.getClass() == EatIn.class) {
            writeEatInOrder((EatIn) order);
        }else if (order.getClass() == Takeaway.class) {
            writeTakeawayOrder((Takeaway) order);
        }else if (order.getClass() == Delivery.class) {
            writeDeliveryOrder((Delivery) order);
        }
    }

    /**
     * Write eat in order.
     *
     * @param eatIn the eat in as an object of Eat_in
     */
    public static void writeEatInOrder(EatIn eatIn) {
        FileManager.writeToFile("EatInOrderDb.txt", eatIn.toDataString());
    }

    /**
     * Write takeaway order.
     *
     * @param takeaway the takeaway as an object of Takeaway
     */
    public static void writeTakeawayOrder(Takeaway takeaway) {
        FileManager.writeToFile("TakeawayOrderDb.txt", takeaway.toDataString());
    }

    /**
     * Write delivery order.
     *
     * @param delivery the delivery as an object of Delivery
     */
    public static void writeDeliveryOrder(Delivery delivery) {
        FileManager.writeToFile("DeliveryOrderDb.txt", delivery.toDataString());
    }

    /**
     * Populate orders.
     */
    public static void populateOrders() {
        populateEatInOrders();
        populateTakeawayOrders();
        populateDeliveryOrders();
    }

    /**
     * Populate eat in orders.
     */
    public static void populateEatInOrders() {
        String[][] str = FileManager.readFromFile("EatInOrderDb.txt", 8);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new EatIn(str[i][0], FileManager.getItemsFromIds(str[i][1]),
                    Boolean.parseBoolean(str[i][2]), FileManager.stringToLocalDateTime(str[i][3]),
                    Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]),
                    Integer.parseInt(str[i][6]), str[i][7]));
        }
    }

    /**
     * Populate takeaway orders.
     */
    public static void populateTakeawayOrders() {
        String[][] str = FileManager.readFromFile("TakeawayOrderDb.txt", 7);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new Takeaway(str[i][0], FileManager.getItemsFromIds(str[i][1]),
                    Boolean.parseBoolean(str[i][2]), FileManager.stringToLocalDateTime(str[i][3]),
                    Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]), (str[i][6])));
        }
    }

    /**
     * Populate delivery orders.
     */
    public static void populateDeliveryOrders() {
        String[][] str = FileManager.readFromFile("DeliveryOrderDb.txt", 9);
        for (int i = 0; i < str.length; i++){
            addToOrderHistory(new Delivery(str[i][0], FileManager.getItemsFromIds(str[i][1]),
                    Boolean.parseBoolean(str[i][2]), FileManager.stringToLocalDateTime(str[i][3]),
                    Boolean.parseBoolean(str[i][4]), Boolean.parseBoolean(str[i][5]), str[i][6], str[i][7],
                    Boolean.parseBoolean(str[i][8])));
        }
    }


    /**
     * The constant customerList.
     */
//CUSTOMER DATABASE
    //======== ========
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();

    /**
     * Populate customers.
     */
    public static void populateCustomers() {
        String[][] str = FileManager.readFromFile("CustomerDb.txt", 4);
        for (int i = 0; i < str.length; i++){
            addToCustomerList(new Customer(str[i][0], str[i][1], str[i][2], str[i][3]));
        }
    }

    /**
     * Add to customer list.
     *
     * @param newCustomer the new customer as an object of Customer
     */
    public static void addToCustomerList(Customer newCustomer) {
        customerList.add(newCustomer);
    }

    /**
     * Add new customer.
     *
     * @param newCustomer the new customer as an object of Customer
     */
    public static void addNewCustomer(Customer newCustomer) {
        addToCustomerList(newCustomer);
        writeCustomer(newCustomer);
    }

    /**
     * Refresh customers.
     */
    public static void refreshCustomers() {
        FileManager.clearFile("CustomerDB.txt");
        for (int i = 0; i < customerList.size(); i++) {
            writeCustomer(customerList.get(i));
        }
    }

    /**
     * Write customer.
     *
     * @param newCustomer the new customer as an object of Customer
     */
    public static void writeCustomer(Customer newCustomer) {
        FileManager.writeToFile("CustomerDb.txt", newCustomer.toDataString());
    }

    /**
     * Gets customer list.
     *
     * @return the customer list as an Arraylist of objects of Customer
     */
    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Check customer boolean.
     *
     * @param possibleID the possible id as a String
     * @return false as a boolean
     */
    public static boolean checkCustomer(String possibleID) {
        for (int k=0; k < customerList.size(); k++) {
            if (possibleID.equals(customerList.get(k).getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets customer.
     *
     * @param id the id as a String
     * @return the customer as an object of Customer
     */
    public static Customer getCustomer(String id) {
        for (int k=0; k < customerList.size(); k++) {
            if (id.equals(customerList.get(k).getId())) {
                return customerList.get(k);
            }
        }
        return null;
    }

    /**
     * The constant staffList.
     */
//STAFF DATABASE
    //===== ========
    private static ArrayList<Staff> staffList = new ArrayList<Staff>();

    /**
     * Add new staff.
     *
     * @param newStaff the new staff as an object of Staff
     */
    public static void addNewStaff(Staff newStaff) {
        addToStaffList(newStaff);
        writeStaff(newStaff);
    }

    /**
     * Refresh staff.
     */
    public static void refreshStaff() {
        FileManager.clearFile("StaffDB.txt");
        for (int i = 0; i < staffList.size(); i++) {
            writeStaff(staffList.get(i));
        }
    }

    /**
     * Write staff.
     *
     * @param newStaff the new staff as an object of Staff
     */
    public static void writeStaff(Staff newStaff) {
        FileManager.writeToFile(
                "StaffDb.txt", newStaff.toDataString());
    }

    /**
     * Add to staff list.
     *
     * @param newStaff the new staff as an object of Staff
     */
    public static void addToStaffList(Staff newStaff) {
        staffList.add(newStaff);
    }

    /**
     * Populates the staff.
     */
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
                default:
                    break;
            }    
        }
    }

    /**
     * Gets staff list.
     *
     * @return the staff list as an Arraylist of objects of Staff
     */
    public static ArrayList<Staff> getStaffList() {
        return staffList;
    }

    /**
     * Gets staff count.
     *
     * @return the staff count as an int
     */
    public static int getStaffCount() {
        return staffList.size();
    }

    /**
     * Check staff boolean.
     *
     * @param possibleID the possible idas a String
     * @return true or false as a boolean
     */
    public static boolean checkStaff(String possibleID) {
        for (int k = 0; k < staffList.size(); k++) {
            if (possibleID.equals(staffList.get(k).getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets staff.
     *
     * @param id the id as a String
     * @return the staff as an object of Staff
     */
    public static Staff getStaff(String id) {
        for (int k = 0; k < staffList.size(); k++) {
            if (id.equals(staffList.get(k).getId())) {
                return staffList.get(k);
            }
        }
        return null;
    }

    /**
     * Remove staff from database boolean.
     *
     * @param id the id as a String
     * @return true or false as a boolean
     */
    public static boolean removeStaffFromDatabase(String id) {

        for (Staff a: staffList){
            if (a.getId() == id){
                staffList.remove(a);
                return true;
            }
        }
        return false;

    }

    /**
     * The constant menuItems.
     */
//MENU ITEMS DATABASE
    //==== ===== ========
    private static ArrayList<MenuItem> menuItems = new ArrayList<>();

    /**
     * Populate menu items.
     */
    public static void populateMenuItems() {
        String[][] str = FileManager.readFromFile("MenuItemDb.txt", 5);
        for (int i = 0; i < str.length; i++) {
            addToMenu(new MenuItem(Integer.parseInt(str[i][0]), str[i][1], str[i][2],
                    Boolean.parseBoolean(str[i][3]), Boolean.parseBoolean(str[i][4])));
        }
    }

    /**
     * New menu item.
     *
     * @param newMenuItem the new menu item as an object of MenuItem
     */
    public static void newMenuItem(MenuItem newMenuItem) {
        addToMenu(newMenuItem);
        writeMenuItem(newMenuItem);
    }

    /**
     * Add to menu.
     *
     * @param item the item as an object of MenuItem
     */
    public static void addToMenu(MenuItem item) {
        menuItems.add(item);
    }

    /**
     * Refresh menu items.
     */
    public static void refreshMenuItems() {
        FileManager.clearFile("MenuItemDB.txt");
        for (int i = 0; i < menuItems.size(); i++) {
            writeMenuItem(menuItems.get(i));
        }
    }

    /**
     * Write menu item.
     *
     * @param menuItem the menu item as an object of MenuItem
     */
    public static void writeMenuItem(MenuItem menuItem) {
        FileManager.writeToFile("menuItemDb.txt", menuItem.toDataString());
    }

    /**
     * Get menu array list.
     *
     * @return menuItems as an Arraylist of objects of MenuItem
     */
    public static ArrayList<MenuItem> getMenu(){
        return menuItems;
    };

    /**
     * Gets specials.
     *
     * @return the specials as an Arraylist of objects of MenuItem
     */
    public static ArrayList<MenuItem> getSpecials() {
        ArrayList<MenuItem> specials = new ArrayList<>();
        for (int i=0; i<menuItems.size(); i++) {
            if (menuItems.get(i).getIsSpecial()) {
                specials.add(menuItems.get(i));
            }
        }
        return specials;
    }

    /**
     * Gets active menu.
     *
     * @return the active menu as an ArrayList of objects of MenuItem
     */
    public static ArrayList<MenuItem> getActiveMenu() {
        ArrayList<MenuItem> activeMenu = new ArrayList<>();
        for (int i=0; i<menuItems.size(); i++) {
            if (menuItems.get(i).getInMenu()) {
                activeMenu.add(menuItems.get(i));
            }
        }
        return activeMenu;
    }

    /**
     * Gets item.
     *
     * @param id the id as an int
     * @return the item as an objectof MenuItem
     */
    public static MenuItem getItem(int id) {
        for (int k = 0; k < menuItems.size(); k++) {
            if (id == menuItems.get(k).getID()) {
                return menuItems.get(k);
            }
        }
        return null;
    }

    /**
     * The constant selectionss.
     */
    private static ArrayList<MenuItem> selectionss = new ArrayList<>();

    /**
     * Add to selections.
     *
     * @param selections the selections as an object of MenuItem
     */
    public static void addToSelections(MenuItem selections){
        selectionss.add(selections);
    }

    /**
     * Get selections array list.
     *
     * @return the selections as an ArrayList of objects of MenuItem
     */
    public static ArrayList<MenuItem> getSelections(){
        return selectionss;
    };

    /**
     * Customer history array list.
     *
     * @param custId the cust id as a String
     * @return custHistory as an ArrayList of objects of Order
     */
// return customer history
    public static ArrayList<Order> customerHistory(String custId) {
        ArrayList<Order> custHistory = new ArrayList<Order>();
        for (int i = 0; i < orderHistory.size(); i++) {
            Order checking = orderHistory.get(i);
            if (checking.getCustomID().equals(custId)) {
                custHistory.add(checking);
            }
        }
        return custHistory;
    }

    /**
     * Most active customer customer.
     *
     * @return the most active customer as an object of Customer
     */
//most active customer
    public static Customer mostActiveCustomer() {
        Customer mostActiveCust = getCustomerList().get(0); // If the customer list is empty error will occur!!!
        int maxSize = 0;
        Customer checkingCust = getCustomerList().get(0);
        for (int i = 0; i <getCustomerList().size(); i++) {
            checkingCust = customerList.get(i);
            int size = 0;
            for (int k = 0; k<getOrderHistory().size(); k++) {
                String checkingCustID = checkingCust.getID();
                if (checkingCustID.equals(getOrderHistory().get(k).getCustomID())) {
                    size = size + 1;
                }
            }
            if (size > maxSize) {
                maxSize = size;
                mostActiveCust = checkingCust;
            }
        }
        return mostActiveCust;
    }

    

}
