import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Eat_in extends Order{
    private int tableID;
    private int waiterID;



    public Eat_in(int tableID, int waiterID, ArrayList<MenuItem> items) {
        this.tableID = tableID;
        this.waiterID = waiterID;
        record(items);
    }


    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getWaiterID() {
        return waiterID;
    }

    public void setWaiterID(int waiterID) {
        this.waiterID = waiterID;
    }

    @Override
    public String toString() {
        return "Eat_in{" +
                "tableID=" + tableID +
                ", waiterID=" + waiterID +
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
