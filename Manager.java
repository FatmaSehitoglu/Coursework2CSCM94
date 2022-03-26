public class Manager extends Staff {

    //CONSTRUCTOR
    //===========
    public Manager(String firstName, String lastName, int staffId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffId = staffId;
    }

    //SETTERS
    //=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //GETTERS
    //=======
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getStaffId() {
        return this.staffId;
    }

    //METHODS
    //=======
    public void addStaff() {
        //add code here
    }

    public void removeStaff() {
        //add code here
    }

    public void editStaff() {
        //add code here
    }

    //public void approveEvent() {} (not implemented)

}
