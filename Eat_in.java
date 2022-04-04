import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Eat_in extends Order{
    private int tableID;
    private String waiterID;

    /**
     *
     * @param customID
     * @param items
     * @param approval
     * @param tableID
     * @param waiterID
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
     * 
     * @param customID
     * @param items
     * @param orderComplete
     * @param time
     * @param chefComplete
     * @param approval
     * @param tableID
     * @param waiterID
     */
    public Eat_in(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, int tableID, String waiterID) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.tableID = tableID;
        this.waiterID = waiterID;
    }

    //SETTERS
    //=======
    public void setTableID(int tableID) {
        this.tableID = tableID;
        Database.refreshOrders();
    }

    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
        Database.refreshOrders();
    }

    //GETTERS
    //=======
    public int getTableID() {
        return tableID;
    }

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
     *
     * @return String formatted
     */
    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%b|%s\n", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, tableID, waiterID);
    }

}
