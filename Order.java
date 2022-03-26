
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Order {
    private int customID;
    private ArrayList<MenuItem> items;
    private boolean orderComplete;
    private LocalDateTime time;

    public Order() {
    }

    public Order(int customID, ArrayList<MenuItem> items, boolean orderComplete, LocalDateTime time) {
        this.customID = customID;
        this.items = items;
        this.orderComplete = orderComplete;
        this.time = time;
    }

    public int getCustomID() {
        return customID;
    }

    public void setCustomID(int customID) {
        this.customID = customID;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public boolean isOrderComplete() {
        return orderComplete;
    }

    public void setOrderComplete(boolean orderComplete) {
        this.orderComplete = orderComplete;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customID=" + customID +
                ", items=" + items +
                ", orderComplete=" + orderComplete +
                ", time=" + time +
                '}';
    }

    //public abstract void record();

    public abstract void record(ArrayList<MenuItem> items);
    //public abstract boolean additem();
}

