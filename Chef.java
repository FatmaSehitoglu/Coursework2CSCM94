public class Chef extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    
    
    //CONSTRUCTOR
    //===========
    public Chef(String firstName, String lastName, String staffId) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setStaffId(staffId);
    }

    //SETTERS
    //=======
   
    //GETTERS
    //=======
   
    //METHODS
    //=======
    public void completeOrder() {
        //add code here
    }

    public void updateDailySpecial() {
        //add code here
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.firstName, this.lastName, "Chef");
    }

}
