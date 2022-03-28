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

    public void addtoMenu(){
        int id;
        String description;
        String name;
        System.out.println("Enter ID of item you want to add:");

        id = Input.intInput(0, 999999);
        System.out.println("Describe the item you are adding: ");
        description = Input.stringInput();
        System.out.println("Now give it a name: ");
<<<<<<< HEAD
        name = Input.stringInput();
        Database.addToMenu(new MenuItem(id, description, name));
=======
        name = in.nextLine();
        Database.addToMenu(new MenuItem(id, description, name,true,false));
>>>>>>> 48245d74af2c2e55dee5f9a79c11bbdeb70610ac
    }

    public void updateDailySpecial() { //not finished
        //assuming there can be only one daily special first take off the old special
        MenuItem old = Database.getTodaysSpecial();
        old.setIsSpecial(false);
        System.out.println("Select from the new special from following list");


    }

    public void displayMainMenu() {}

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Chef");
    }

}
