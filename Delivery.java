import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * The type Delivery.
 */
public class Delivery extends Order{
    private String address;
    private String driveID;
    private boolean driveComplete;


    /**
     * Instantiates a new Delivery.
     *
     * @param customID the custom id
     * @param items    the items
     * @param approval the approval
     * @param address  the address
     * @param driveID  the drive id
     */
    public Delivery(String customID, ArrayList<MenuItem> items, boolean approval, String address, String driveID) {
        super(customID, items, approval);
        this.address = address;
        this.driveID = driveID;
    }

    /**
     * Instantiates a new Delivery.
     *
     * @param customID      the custom id
     * @param items         the items
     * @param orderComplete the order complete
     * @param time          the time
     * @param chefComplete  the chef complete
     * @param approval      the approval
     * @param address       the address
     * @param driveID       the drive id
     * @param driveComplete the drive complete
     */
    public Delivery(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, String address, String driveID, boolean driveComplete) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.address = address;
        this.driveID = driveID;
        this.driveComplete = driveComplete;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
//SETTERS
    //=======
    public void setAddress(String address) {
        this.address = address;
        Database.refreshOrders();
    }

    /**
     * Sets drive id.
     *
     * @param driveID the drive id
     */
    public void setDriveID(String driveID) {
        this.driveID = driveID;
        Database.refreshOrders();
    }

    /**
     * Sets drive complete.
     *
     * @param driveComplete the drive complete
     */
    public void setDriveComplete(boolean driveComplete) {
        this.driveComplete = driveComplete;
        Database.refreshOrders();
    }

    /**
     * Gets address.
     *
     * @return the address
     */
//GETTERS
    //=======
    public String getAddress() {
        return address;   
    }

    /**
     * Gets drive id.
     *
     * @return the drive id
     */
    public String getDriveID() {
        return driveID;
    }

    /**
     * Is drive complete boolean.
     *
     * @return the boolean
     */
    public boolean isDriveComplete() {
        return driveComplete;
    }

   


    /**
     *
     * @return String formatted
     */
    @Override
    public String toString() {
        return "Delivery{" +
        "customID " + customID +
        " orderApproved " + approval +
        " time " + time +
        " address " + address +
        " driveID " + driveID +
        " chefComplete " + chefComplete +
        " driveComplete " + driveComplete + "/n" +
        " items " + items.toString() +
        " }";
    }


    /**
     * To data string string.
     *
     * @return String formatted
     */
    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%s|%s|%b\n", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, address, driveID, driveComplete);
    }

}
