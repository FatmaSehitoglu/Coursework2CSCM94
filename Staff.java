public abstract class Staff extends User{
    
    //FIELDS
    //======
    //Shift[] hoursToWork; (not implemented)
    private String staffId;
    private int totalHoursWorked = 0;

    //SETTERS
    //=======
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void incrementHoursWorked(int n) {
        this.totalHoursWorked += n;
    }

    //GETTERS
    //=======
    public String getStaffId() {
        return this.staffId;
    }

    public int getHoursWorked() {
        return totalHoursWorked;
    }

}
