public class Waiter extends Staff {
    
    //Constructor method
    public Waiter(String firstName, String lastName, int staffId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffId = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getStaffId() {
        return this.staffId;
    }

    public void newEatInOrder() {
        //add code here
    }

    public void cancelOrder() {
        //add code here
    }

    public void approveBooking() {
        //add code here
    }

    public void approveDelivery() {
        //add code here
    }

}
