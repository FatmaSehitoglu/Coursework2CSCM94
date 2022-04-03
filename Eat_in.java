import java.util.ArrayList;
import java.time.LocalDateTime;


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
        return "Eat_in{" +
                "tableID " + tableID +
                " waiterID " + waiterID +
                "customID " + customID +
                " items " + items.toString() +
                " orderComplete " + orderComplete +
                " time " + time +
                " }";
    }


    /**
     *
     * @return String formatted
     */
    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%b|%s", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, tableID, waiterID);
    }

}
