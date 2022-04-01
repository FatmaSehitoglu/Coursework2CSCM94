public class Chef extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    
    
    //CONSTRUCTOR
    //===========
    public Chef(String firstName, String lastName, String id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
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

    public void addToMenu(){
        int id;
        String description;
        String name;
        System.out.println("Enter ID of item you want to add:");

        id = Input.intInput(0, 999999);
        System.out.println("Describe the item you are adding: ");
        description = Input.stringInput();
        System.out.println("Now give it a name: ");
        name = Input.stringInput();
        Database.addToMenu(new MenuItem(id, description, name,true,false));
    }

    /*
    public void updateDailySpecial() { //not finished
        //assuming there can be only one daily special first take off the old special
        MenuItem old = Database.getTodaysSpecial();
        old.setIsSpecial(false);
        System.out.println("Select from the new special from following list");


    }
    */

    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {  
            System.out.println("1. New Menu Item");
            System.out.println("2. View Active Orders");
            System.out.println("3. View Menu Items");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 3);

            switch (select) {
                case 1:
                    addToMenu();
                    break;
                case 2:
                    viewActiveOrders();
                    break;
                case 3:
                    viewMenuItems();
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }   
    }

    public void viewActiveOrders() {

    }

    public void viewMenuItems() {

    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Chef");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s", this.getFirstName(), this.getLastName(), this.getId(), "Chef");
    }

}
