import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Order {

    //FIELDS
    //======
    public String customID;
    public ArrayList<MenuItem> items;
    public boolean orderComplete;
    public LocalDateTime time;
    public boolean chefComplete;
    public boolean approval;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Orders
     * @param customID
     * @param items
     * @param approval
     */
    public Order(String customID, ArrayList<MenuItem> items, boolean approval) {
        this.customID = customID;
        this.items = items;
        this.approval = approval;
        this.time = LocalDateTime.now();
        this.orderComplete = false;
        this.chefComplete = false;
    }

    /**
     * Constructor for Orders read from Database
     * @param customID
     * @param items
     * @param approval
     * @param time
     * @param orderComplete
     * @param chefComplete
     */
    public Order(String customID, ArrayList<MenuItem> items, boolean approval, LocalDateTime time, boolean orderComplete, boolean chefComplete) {
        this.customID = customID;
        this.items = items;
        this.approval = approval;
        this.time = time;
        this.orderComplete = orderComplete;
        this.chefComplete = chefComplete;
    }

    //SETTERS
    //=======
    /**
     * Setter for customID
     * @param customID
     */
    public void setCustomID(String customID) {
        this.customID = customID;
        Database.refreshOrders();
    }

    /**
     * Setter for items
     * @param items
     */
    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
        Database.refreshOrders();
    }
    
    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
        Database.refreshOrders();
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
        Database.refreshOrders();
    }

    public void setChefComplete(boolean chefComplete) {
        this.chefComplete = chefComplete;
        Database.refreshOrders();
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
        Database.refreshOrders();
    }

    //GETTERS
    //=======
    public String getCustomID() {
        return customID;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    } 

    public boolean isOrderComplete() {
        return orderComplete;
    }

    public LocalDateTime getTime() {
        return time;
    }   

    public boolean isChefComplete() {
        return chefComplete;
    }

    public boolean isApproval() {
        return approval;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customID " + customID +
                " items " + items.toString() +
                " orderComplete " + orderComplete +
                " time " + time +
                " chefComplete " + chefComplete +
                " }";
    }

}
