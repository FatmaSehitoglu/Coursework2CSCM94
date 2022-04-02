import java.util.ArrayList;
import java.time.LocalDateTime;


public class Eat_in extends Order{
    private int tableID;
    private String waiterID;


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



    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getWaiterID() {
        return waiterID;
    }

    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
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

    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%b|%s", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, tableID, waiterID);
    }

}
