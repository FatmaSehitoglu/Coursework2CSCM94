import java.time.LocalDateTime;
import java.util.ArrayList;


public class Takeaway extends Order{
    private LocalDateTime arriveTime;

    public Takeaway(String customID, ArrayList<MenuItem> items, boolean approval, LocalDateTime time) {
        super(customID, items, approval);
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
                "arriveTime=" + arriveTime +
                '}';
    }

}
