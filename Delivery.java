import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Delivery extends Order{
    private String address;
    private int driveID;

    public Delivery(String address, int driveID, ArrayList<MenuItem> items) {
        this.address = address;
        this.driveID = driveID;
        record(items);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDriveID() {
        return driveID;
    }

    public void setDriveID(int driveID) {
        this.driveID = driveID;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "address='" + address + '\'' +
                ", driveID=" + driveID +
                '}';
    }

    @Override
    public void record(ArrayList<MenuItem> items) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the customer ID:");
        int id = sc.nextInt();
        setCustomID(id);
        System.out.println("Please enter the item:");

        setTime(LocalDateTime.now());
        setOrderComplete(false);
    }
}

