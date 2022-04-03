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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Database.refreshStaff();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        Database.refreshStaff();
    }

    public void setId(String id) {
        this.id = id;
        Database.refreshStaff();
    }

    public void incrementHoursWorked(int n) {
        this.totalHoursWorked += n;
        Database.refreshStaff();
    }

    //GETTERS
    //=======
    public int getHoursWorked() {
        return totalHoursWorked;
    }

    public abstract String toDataString();

}
