import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TakeAwayOrder extends Order {
    
    //FIELDS
    //======
    //int custId;           (inherited)
    //boolean completed;    (inherited)
    //String dateTime;      (inherited)
    private String pickupTime;

    //CONSTRUCTOR
    //===========
    public TakeAwayOrder(
        int custId, 
        boolean completed, 
        String pickupTime
    ) {
        this.custId = custId;
        this.completed = false;
        this.dateTime = currentDateTime();
        this.pickupTime = pickupTime;
    }
        
    //SETTERS
    //=======
    public void setCustId(int custId) {
        this.custId = custId;
    }

    public void setComplete() {
        this.completed = true;
    }

    public void setIncomplete() {
        this.completed = false;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    //GETTERS
    //=======
    public int getCustId() {
        return this.custId;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getPickupTime() {
        return this.pickupTime;
    }

    //METHODS
    //=======

    //Methods here

    //UTILITY METHODS
    //======= =======
    private static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}
