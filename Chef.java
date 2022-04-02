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
    public void completeOrder(Order order) {
        order.setChefComplete(true);
    }

    public void addToMenu(boolean special){
        int id;
        String description;
        String name;
        System.out.println("Enter a 6 digit ID for the new Menu Item:");
        id = Input.intInput(0, 999999);
        System.out.println("Name of the New Menu Item: ");
        name = Input.stringInput();
        System.out.println("Describe the item you are adding: ");
        description = Input.stringInput();
        MenuItem newItem = new MenuItem(id, description, name, true, special);
        Database.menuItems.add(newItem);
    }

    
    public void editDailySpecial() {
        boolean cont = true;
        while(cont) {
            for(int i=0;i<Database.getSpecials().size();i++) {
                System.out.println(Database.getSpecials().get(i).toString());
            }
            System.out.println("1. Make an existing menu item daily special");
            System.out.println("2. Enter a new menu item as daily special");
            System.out.println("3. Cancel a daily special");
            System.out.println("0. Back To Previous Menu");
            int select = Input.intInput(0, 3);
            switch (select) {
                case 1:
                    for(int i=0; i<Database.menuItems.size();i++) {
                        System.out.println(Database.menuItems.get(i).toString());
                    }
                    System.out.println("Enter the id of the item you want to designate as daily special");
                    boolean found = false;
                    int input = Input.intInput(0, 999999);
                    for(int i=0;i<Database.menuItems.size();i++) {
                        if(input == Database.getSpecials().get(i).getID()) {
                            Database.getSpecials().get(i).setIsSpecial(true);
                            found = true;
                        }
                    }
                    if(found == false) {
                        System.out.println("No item with id " + input + " found."  );
                    }
                    break;
                case 2:
                    addToMenu(true);
                    break;
                case 3:
                    System.out.println("Enter the id of the item you want to designate as NOT daily special");
                    found = false;
                    input = Input.intInput(0, 999999);
                    for(int i=0;i<Database.getSpecials().size();i++) {
                        if(input == Database.getSpecials().get(i).getID()) {
                            Database.getSpecials().get(i).setIsSpecial(false);
                            found = true;
                        }
                    }
                    if(found == false) {
                        System.out.println("No item with id " + input + " found."  );
                    }
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
    }

    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {  
            System.out.println("1. New Menu Item");
            System.out.println("2. View Active Orders");
            System.out.println("3. View Menu Items");
            System.out.println("4. Edit Daily Specials");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 4);
            switch (select) {
                case 1:
                    addToMenu(false);
                    break;
                case 2:
                    viewActiveOrders();
                    break;
                case 3:
                    viewMenuItems();
                    break;
                case 4:
                    editDailySpecial();
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }   
    }

    public void viewActiveOrders() {
        boolean cont = true;
        while(cont == true) {
            for(int i=0; i<Database.orderHistory.size(); i++) {
                if(Database.orderHistory.get(i).isChefComplete() == false) {
                    System.out.println(Database.orderHistory.get(i).toString());
                }
            }
            System.out.println("1.Complete an incomplete order");
            System.out.println("0.Go Back");
            int select = Input.intInput(0, 1);
            switch (select) {
                case 1:
                    System.out.println("Select an order to complete");
                    int order = Input.intInput(0, Database.orderHistory.size());
                    Database.orderHistory.get(order).setChefComplete(true);
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
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
