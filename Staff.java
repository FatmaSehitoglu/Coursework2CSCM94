public abstract class Staff extends User{
    
    //FIELDS
    //======
    //private String firstName;     (inherited)
    //private String lastName;      (inherited)
    //private String id;            (inherited)
    //Shift[] hoursToWork; (not implemented)
    private int totalHoursWorked = 0;


    public Staff (String firstName, String lastName, String id) {
        super (firstName, lastName, id);
    }

    //SETTERS
    //=======
    public void incrementHoursWorked(int n) {
        this.totalHoursWorked += n;
    }

    //GETTERS
    //=======
    public int getHoursWorked() {
        return totalHoursWorked;
    }

    public abstract String toDataString();

}
