import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * The type Eat in.
 */
public class Eat_in extends Order{
    private int tableID;
    private String waiterID;

    /**
     * Instantiates a new Eat in.
     *
     * @param customID the custom id
     * @param items    the items
     * @param approval the approval
     * @param tableID  the table id
     * @param waiterID the waiter id
     */
    public Eat_in(String customID, ArrayList<MenuItem> items, boolean approval, int tableID, String waiterID) {
        super(customID, items, approval);
        this.customID = customID;
        this.items = items;
        this.approval = approval;
        this.time = LocalDateTime.now();
        this.orderComplete = false;
        this.chefComplete = false;
        this.tableID = tableID;
        this.waiterID = waiterID;
    }

    /**
<<<<<<< HEAD
     * 
     * @param customID
     * @param items
     * @param orderComplete
     * @param time
     * @param chefComplete
     * @param approval
     * @param tableID
     * @param waiterID
=======
     * Instantiates a new Eat in.
     *
     * @param customID      the custom id
     * @param items         the items
     * @param orderComplete the order complete
     * @param time          the time
     * @param chefComplete  the chef complete
     * @param approval      the approval
     * @param tableID       the table id
     * @param waiterID      the waiter id
>>>>>>> cbd464aed1167f12004785c999a6dab4b3bb39da
     */
    public Eat_in(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, int tableID, String waiterID) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.tableID = tableID;
        this.waiterID = waiterID;
    }

    /**
     * Sets table id.
     *
     * @param tableID the table id
     */
//SETTERS
    //=======
    public void setTableID(int tableID) {
        this.tableID = tableID;
        Database.refreshOrders();
    }

    /**
     * Sets waiter id.
     *
     * @param waiterID the waiter id
     */
    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
        Database.refreshOrders();
    }

    /**
     * Gets table id.
     *
     * @return the table id
     */
//GETTERS
    //=======
    public int getTableID() {
        return tableID;
    }

    /**
     * Gets waiter id.
     *
     * @return the waiter id
     */
    public String getWaiterID() {
        return waiterID;
    }

    

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time1 = time.format(formatter);
        String order1 = items.toString();
        String status1 = orderComplete ? "Complete" : "Incomplete";
        return String.format("Table %d, Waiter: %s, Customer: %s, Time: %s, Order: %s, Status: %s", tableID, waiterID, customID, time1, order1, status1);
    }


    /**
     * To data string string.
     *
     * @return String formatted
     */
    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%b|%s\n", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, tableID, waiterID);
    }

}
