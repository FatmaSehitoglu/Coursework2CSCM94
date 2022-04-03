import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Takeaway extends Order{
    private String arriveTime;

    //CONSTRUCTORS
    //============

    public Takeaway(String customID, ArrayList<MenuItem> items, boolean approval, LocalDateTime time) {
        super(customID, items, approval);
    }

    public Takeaway(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, String arriveTime) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.arriveTime = arriveTime;
    }

    //SETTERS
    //=======
    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
        Database.refreshOrders();
    }
      
    //GETTERS
    //=======
    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

   

    @Override
    public String toString() {
        return "Takeaway{" +
                "arriveTime " + arriveTime +
                " }";
    }

    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%s", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, arriveTime);
    }

}
