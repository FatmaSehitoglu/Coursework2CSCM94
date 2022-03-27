public class Manager extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTOR
    //===========
    public Manager(String firstName, String lastName, String staffId) {
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
    public Customer getMostActiveCustomer() {
        Customer mostActive = Database.mostActiveCustomer();
        return mostActive;
    }
}
