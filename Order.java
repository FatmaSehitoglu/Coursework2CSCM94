import java.time.LocalDateTime;
import java.util.ArrayList;
public abstract class Order {
    /**
     * <h2>Order class</h2>
     * Superclass for Eat_in, Delivery and Takeaway
     * @author Niu Zhaoye
     * @version 1.0
     */

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
     * @param customID as a String
     * @param items as a MenuItem ArrayList
     * @param approval as a boolean
     */
    public Order(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean approval
    ) {
        this.customID = customID;
        this.items = items;
        this.approval = approval;
        this.time = LocalDateTime.now();
        this.orderComplete = false;
        this.chefComplete = false;
    }

    /**
     * Constructor for Orders read from Database
     * @param customID as a String
     * @param items as a MenuItem ArrayList
     * @param approval as a boolean
     * @param time as a LocalDateTime
     * @param orderComplete as a boolean
     * @param chefComplete as a boolean
     */
    public Order(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean approval, 
        LocalDateTime time, 
        boolean orderComplete, 
        boolean chefComplete
    ) {
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
     * @param customID as a String
     */
    public void setCustomID(String customID) {
        this.customID = customID;
        Database.refreshOrders();
    }

    /**
     * Setter for items
     * @param items as a MenuItem ArrayList
     */
    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
        Database.refreshOrders();
    }
    
    /**
     * Setter for orderComplete
     * @param orderComplete as a boolean
     */
    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
        Database.refreshOrders();
    }

    /**
     * Setter for time
     * @param time as a LocalDateTime
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
        Database.refreshOrders();
    }

    /**
     * Setter for chefCompete
     * @param chefComplete as a boolean
     */
    public void setChefComplete(boolean chefComplete) {
        this.chefComplete = chefComplete;
        Database.refreshOrders();
    }

    /**
     * Setter for approval
     * @param approval as a boolean
     */
    public void setApproval(boolean approval) {
        this.approval = approval;
        Database.refreshOrders();
    }

    //GETTERS
    //=======
    /**
     * Getter for customID
     * @return customID as a String
     */
    public String getCustomID() {
        return customID;
    }

    /**
     * Getter for items
     * @return items as a MenuItem ArrayList
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    } 

    /**
     * Getter for orderComplete
     * @return orderComplete as a boolean
     */
    public boolean isOrderComplete() {
        return orderComplete;
    }

    /**
     * Getter for time
     * @return time as a LocalDateTime
     */
    public LocalDateTime getTime() {
        return time;
    }   

    /**
     * Getter for chefComplete
     * @return chefComplete as a boolean
     */
    public boolean isChefComplete() {
        return chefComplete;
    }

    /**
     * Getter for approval
     * @return approval as a boolean
     */
    public boolean isApproval() {
        return approval;
    }

}
