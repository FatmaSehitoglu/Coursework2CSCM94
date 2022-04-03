public class Driver extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    

    /**
     *
     * @param firstName
     * @param lastName
     * @param id
     */

    //CONSTRUCTOR
    //===========
    public Driver(String firstName, String lastName, String id) {
        super (firstName, lastName, id);
    }

    //METHODS
    //=======

    /**
     * <h1>This method displays menu interface</h1>
     * @param none
     * @return none
     */
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {  
            System.out.println("1. View Active Orders");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 1);

            switch (select) {
                case 1:
                    viewActiveOrders();
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }   
    }
   
    public void viewActiveOrders() {
        
    }

    public void completeDelivery() {
        //add code here
    }


    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Driver");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s", this.getFirstName(), this.getLastName(), this.getId(), "Driver");
    }
   

}
