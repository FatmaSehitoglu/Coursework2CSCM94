import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * <h2>Delivery class</h2>
 * A subclass of Order class
 * @author Niu Zhaoye
 * @version 1.0
 */
public class Delivery extends Order{

    //FIELDS
    //======

    //public String customID;               (inherited)
    //public ArrayList<MenuItem> items;     (inherited)
    //public boolean orderComplete;         (inherited)
    //public LocalDateTime time;            (inherited)
    //public boolean chefComplete;          (inherited)
    //public boolean approval;              (inherited)
    private String address;
    private String driveID;
    private boolean driveComplete;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Deliveries
     * @param customID as a String
     * @param items    as a MenuItem ArrayList
     * @param approval as a boolean
     * @param address  as a String
     * @param driveID  as a String
     */
    public Delivery(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean approval, 
        String address, 
        String driveID
    ) {
        super(customID, items, approval);
        this.address = address;
        this.driveID = driveID;
    }

    /**
     * Constructor for Deliveries read from Database
     * @param customID      as a String
     * @param items         as a MenuItem ArrayList
     * @param orderComplete as a boolean
     * @param time          as a LocalDateTime
     * @param chefComplete  as a boolean
     * @param approval      as a boolean
     * @param address       as a String
     * @param driveID       as a String
     * @param driveComplete as a boolean
     */
    public Delivery(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean orderComplete, 
        LocalDateTime time, 
        boolean chefComplete, 
        boolean approval, 
        String address, 
        String driveID, 
        boolean driveComplete
    ) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.address = address;
        this.driveID = driveID;
        this.driveComplete = driveComplete;
    }

    //SETTERS
    //=======

     /**
     * Sets address.
     * @param address as a String
     */
    public void setAddress(String address) {
        this.address = address;
        Database.refreshOrders();
    }

    /**
     * Sets driveID
     * @param driveID as a String
     */
    public void setDriveID(String driveID) {
        this.driveID = driveID;
        Database.refreshOrders();
    }

    /**
     * Sets driveComplete.
     * @param driveComplete as a boolean
     */
    public void setDriveComplete(boolean driveComplete) {
        this.driveComplete = driveComplete;
        Database.refreshOrders();
    }

    //GETTERS
    //=======

    /**
     * Gets address
     * @return address as a String
     */
    public String getAddress() {
        return address;   
    }

    /**
     * Gets driveID
     * @return driveID as a String
     */
    public String getDriveID() {
        return driveID;
    }

    /**
     * Gets isDriveComplete
     * @return isDriveComplete as a boolean
     */
    public boolean isDriveComplete() {
        return driveComplete;
    }

    //UTILITY METHODS
    //======= =======

    /**
     * toString method for Delivery (for menu displays)
     * @return Delivery as a String
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time1 = time.format(formatter);
        String order1 = items.toString();
        String status2 = approval ? "Approved" : "Awaiting approval";
        String status3 = chefComplete ? "Cooking complete" : "Cooking in progress";
        String status4 = driveComplete ? "Order delivered" : "On the way";
        return String.format(
            "\nType: Delivery\nCustomer: %s\nStatus: %s\nTime: %s\nAddress: %s\nOrder: %s\nChef Progress: %s\nDriver Progress: %s\n", 
            customID, 
            status2,
            time1,
            address, 
            order1, 
            status3,
            status4
        );
    }

    /**
     * Converts Delivery Order to a data string for entry in Database
     * @return Delivery as a data string
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%b|%s|%b|%b|%s|%s|%b\n", 
            customID, 
            FileManager.getItemIds(items), 
            orderComplete, 
            FileManager.localDateTimeToString(time), 
            chefComplete, 
            approval, 
            address, 
            driveID, 
            driveComplete
        );
    }

}
