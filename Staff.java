public abstract class Staff extends User{
    
    //FIELDS
    //======
    //int totalHoursWorked; (not implemented)
    //Shift[] hoursToWork; (not implemented)
    int staffId;

    //SETTERS
    //=======
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    //GETTERS
    //=======
    public int getStaffId() {
        return this.staffId;
    }

}
