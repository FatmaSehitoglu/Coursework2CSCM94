

public class TakeAwayOrder {
    
    //FIELDS
    //======
    //private int custId;           (inherited)
    //private boolean completed;    (inherited)
    //private String dateTime;      (inherited)
    private int pickupTime;

    //CONSTRUCTOR
    //===========
    public TakeAwayOrder(
        int custId, 
        boolean completed, 
        int pickupTime
    ) {
        this.custId = custId;
        this.completed = false;
        this.dateTime = currentDateTime();
        this.pickupTime = pickupTime;
    }
    
    
    //SETTERS
    //=======



    //METHODS
    //=======
    private static String currentDateTime() {
        String dt = "";
        return dt;
    }


}
