import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * <h2>Eat In class</h2>
 * A subclass of Order class
 * @author Niu Zhaoye
 * @version 1.0
 */
public class EatIn extends Order{

    //FIELDS
    //======

    //public String customID;               (inherited)
    //public ArrayList<MenuItem> items;     (inherited)
    //public boolean orderComplete;         (inherited)
    //public LocalDateTime time;            (inherited)
    //public boolean chefComplete;          (inherited)
    //public boolean approval;              (inherited)
    private int tableID;
    private String waiterID;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Eat In Orders
     * @param customID as a String
     * @param items    as a MenuItem ArrayList
     * @param approval as a boolean
     * @param tableID  as an int
     * @param waiterID as a String
     */
    public EatIn(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean approval, 
        int tableID, 
        String waiterID
    ) {
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
     * Constructor for Eat In Orders read from Database
     * @param customID      as a String
     * @param items         as a MenuItem ArrayList
     * @param orderComplete as a boolean
     * @param time          as a LocalDateTime
     * @param chefComplete  as a boolean
     * @param approval      as a boolean
     * @param tableID       as an int
     * @param waiterID      as a String
     */
    public EatIn(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean orderComplete, 
        LocalDateTime time, 
        boolean chefComplete, 
        boolean approval, 
        int tableID, 
        String waiterID
    ) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.tableID = tableID;
        this.waiterID = waiterID;
    }

    //SETTERS
    //=======

    /**
     * Sets tableID
     * @param tableID as an int
     */
    public void setTableID(int tableID) {
        this.tableID = tableID;
        Database.refreshOrders();
    }

    /**
     * Sets waiterID
     * @param waiterID as a String
     */
    public void setWaiterID(String waiterID) {
        this.waiterID = waiterID;
        Database.refreshOrders();
    }
    
    //GETTERS
    //=======

    /**
     * Gets tableID
     * @return tableID as an int
     */
    public int getTableID() {
        return tableID;
    }

    /**
     * Gets waiterID
     * @return waiterID as a String
     */
    public String getWaiterID() {
        return waiterID;
    }

    //UTILITY METHODS
    //======= =======

    /**
     * toString method for Eat_in (for menus displays)
     * @return Eat_in as a String
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time1 = time.format(formatter);
        String order1 = items.toString();
        String status1 = orderComplete ? "Complete" : "Incomplete";
        return String.format(
            "Type: Eat In, Table %d, Waiter: %s, Customer: %s, Time: %s, Order: %s, Status: %s", 
            tableID, 
            waiterID, 
            customID, 
            time1, 
            order1, 
            status1
        );
    }

    /**
     * Converts Eat_in Order to a data string for entry in Database
     * @return Eat_in as a data string
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%b|%s|%b|%b|%b|%s\n", 
            customID, 
            FileManager.getItemIds(items), 
            orderComplete, 
            FileManager.localDateTimeToString(time), 
            chefComplete, 
            approval, 
            tableID, 
            waiterID
        );
    }

}
