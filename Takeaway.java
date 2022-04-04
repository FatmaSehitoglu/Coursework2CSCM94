import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * <h1>Takeaway class</h1>
 * A subclass of Order class
 * @author Niu Zhaoye
 * @version 1.0
 */
public class Takeaway extends Order{
   
    //FIELDS
    //======

    private String arriveTime;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Takeaway Orders
     * @param customID  as a String
     * @param items     as a MenuItem ArrayList
     * @param approval  as a boolean
     */
    public Takeaway(
        String customID, 
        ArrayList<MenuItem> items, 
        boolean approval
    ) {
        super(customID, items, approval);
    }

    /**
     *
     * @param customID      as a String
     * @param items         as a MenuItem ArrayList
     * @param orderComplete as a boolean
     * @param time          as a LocalDateTime
     * @param chefComplete  as a boolean
     * @param approval      as a boolean
     * @param arriveTime    as a String
     */
    public Takeaway(String customID, 
        ArrayList<MenuItem> items, 
        boolean orderComplete, 
        LocalDateTime time, 
        boolean chefComplete, 
        boolean approval, 
        String arriveTime
    ) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.arriveTime = arriveTime;
    }

    //SETTERS
    //=======

    /**
     * Sets arriveTime
     * @param arriveTime as a String
     */
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
        Database.refreshOrders();
    }
      
    //GETTERS
    //=======

    /**
     * Gets arriveTime
     * @return arriveTime as a String
     */
    public String getArriveTime() {
        return arriveTime;
    }

    //UTILITY METHODS
    //======= =======

    /**
     * toString method for Takeaway Order (for menu displays)
     * @return Takeaway as a String
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time1 = time.format(formatter);
        String order1 = items.toString();
        String status1 = orderComplete ? "Complete" : "Incomplete";
        String status2 = chefComplete ? "Cooking complete" : "Cooking in progress";
        return String.format(
            "Customer: %s, Time: %s, Estimated arrival time: %s, \nOrder: %s, \nCooking status: %s, Order Status: %s", 
            customID, 
            time1,
            arriveTime, 
            order1,
            status2, 
            status1
        );
    }

    /**
     * Converts Takeaway Order to a data String for Database storage
     * @return Takeaway as a data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%b|%s|%b|%b|%s\n", 
            customID, 
            FileManager.getItemIds(items), 
            orderComplete, 
            FileManager.LocalDateTimeToString(time), 
            chefComplete, 
            approval, 
            arriveTime
        );
    }

}
