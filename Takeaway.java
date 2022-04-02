import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Takeaway extends Order{
    private LocalDateTime arriveTime;

    public Takeaway(String customID, ArrayList<MenuItem> items, boolean approval, LocalDateTime time) {
        super(customID, items, approval);
    }

    public Takeaway(String customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time, boolean chefComplete, boolean approval, LocalDateTime arriveTime) {
        super(customID, items, approval);
        this.orderComplete = orderComplete;
        this.time = time;
        this.chefComplete = chefComplete;
        this.arriveTime = arriveTime;
    }


    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public String toString() {
        return "Takeaway{" +
                "arriveTime " + arriveTime +
                " }";
    }

    public String toDataString() {
        return String.format("%s|%s|%b|%s|%b|%b|%s", customID, FileManager.getItemIds(items), orderComplete, FileManager.LocalDateTimeToString(time), chefComplete, approval, FileManager.LocalDateTimeToString(arriveTime));
    }

}
