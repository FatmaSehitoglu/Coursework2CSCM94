public class Chef extends Staff {

     //CONSTRUCTOR
     //===========
     public Chef(String firstName, String lastName, int staffId) {
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
    public void completeOrder() {
        //add code here
    }

    //is this implemented? i forgot...
    public void updateDailySpecial() {
        //add code here
    }

}
