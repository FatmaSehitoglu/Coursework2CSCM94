public abstract class Staff extends User{
    
    //FIELDS
    //======
    //int totalHoursWorked; (not implemented)
    //Shift[] hoursToWork; (not implemented)
    private String staffId;

    //SETTERS
    //=======
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    //GETTERS
    //=======
    public String getStaffId() {
        return this.staffId;
    }

}
