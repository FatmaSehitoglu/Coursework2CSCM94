import java.time.LocalDateTime;
import java.util.ArrayList;


public class Delivery extends Order{
    private String address;
    private String driveID;
    private boolean driveComplete;

    /**
     * @param customID
     * @param items
     * @param approval
     * @param address
     * @param driveID
     */


    public Delivery(String customID, ArrayList<MenuItem> items, boolean approval, String address, String driveID) {
        super(customID, items, approval);
        this.address = address;
        this.driveID = driveID;
    }

    public Delivery(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, String address, String driveID, boolean driveComplete) {
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
    public void setAddress(String address) {
        this.address = address;
        Database.refreshOrders();
    }

    public void setDriveID(String driveID) {
        this.driveID = driveID;
        Database.refreshOrders();
    }

    public void setDriveComplete(boolean driveComplete) {
        this.driveComplete = driveComplete;
        Database.refreshOrders();
    }

    //GETTERS
    //=======
    public String getAddress() {
        return address;   
    }

    public String getDriveID() {
        return driveID;
    }

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
     *
     * @return String formatted
     */
    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%s|%s|%b", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, address, driveID, driveComplete);
    }

}
