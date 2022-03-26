public class Chef extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    
    
    //CONSTRUCTOR
    //===========
    public Chef(String firstName, String lastName, int staffId) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setStaffId(staffId);
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
    public void completeOrder() {
        //add code here
    }

    //is this implemented? i forgot...
    public void updateDailySpecial() {
        //add code here
    }

}
