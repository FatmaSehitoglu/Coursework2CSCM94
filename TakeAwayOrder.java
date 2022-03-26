import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Takeaway extends Order{
    private LocalDateTime arriveTime;

    /*public Takeaway(int customID, String[] items, boolean orderComplete, LocalDateTime time, LocalDateTime arriveTime) {
        super(customID, items, orderComplete, time);
        this.arriveTime = arriveTime;
    }*/

    public Takeaway(LocalDateTime arriveTime, ArrayList<MenuItem> items) {
        this.arriveTime = arriveTime;
        record(items);
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

    @Override
    public void record(ArrayList<MenuItem> items) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the customer ID:");
        int id = sc.nextInt();
        setCustomID(id);
        setItems(items);
        setTime(LocalDateTime.now());
        setOrderComplete(false);
    }
}
