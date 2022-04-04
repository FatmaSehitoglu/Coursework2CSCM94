/**
 * <h2>Chef class</h2>
 * A subclass of Staff
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @version 1.0
 */
public class Chef extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)    

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Chef
     * @param firstName as a String
     * @param lastName  as a String
     * @param id        as a String
     */
    public Chef(
        String firstName, 
        String lastName, 
        String id
    ) {
        super(firstName, lastName, id);
    }

    //METHODS
    //=======

    /**
     * Displays the main menu for Chef
     */
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

    /**
     * Marks an Order as completed by the chef
     * @param order as an Order
     */
    public void completeOrder(Order order) {
        order.setChefComplete(true);
    }

    /**
     * Adds a MenuItem to the menu as a special
     * @param special as a boolean
     */
    public void addToMenu(boolean special){
        int id;
        String price;
        String name;
        System.out.println("Enter a 6 digit ID for the new Menu Item:");
        id = Input.intInput(0, 999999);
        System.out.println("Name of the New Menu Item: ");
        name = Input.stringInput();
        System.out.println("Price of the item you are adding: ");
        price = Input.stringInput();
        MenuItem newItem = new MenuItem(id, price, name, true, special);
        Database.newMenuItem(newItem);
    }

    /**
     * Edits the daily special.
     */
    public void editDailySpecial() {
        boolean cont = true;
        while(cont) {
            System.out.println("Daily Specials:");
            for(int i=0;i<Database.getSpecials().size();i++) {
                System.out.println(Database.getSpecials().get(i).toString());
            }
            System.out.println("-----------");
            System.out.println("1. Make an existing menu item daily special");
            System.out.println("2. Enter a new menu item as daily special");
            System.out.println("3. Cancel a daily special");
            System.out.println("0. Back To Previous Menu");
            int select = Input.intInput(0, 3);
            switch (select) {
                case 1:
                    for(int i = 0; i<Database.menuItems.size();i++) {
                        System.out.println(Database.menuItems.get(i).toString());
                    }
                    System.out.println("Enter the id of the item you want to designate as daily special");
                    boolean found = false;
                    int s = Input.intInput(0, 999999);
                    for(int i = 0; i<Database.getMenu().size(); i++) {
                        if(s == Database.getMenu().get(i).getID()) {
                            Database.getMenu().get(i).setIsSpecial(true);
                            found = true;
                        }
                    }
                    if(found == false) {
                        System.out.println("No item with id " + s + " found."  );
                    }
                    break;
                case 2:
                    addToMenu(true);
                    break;
                case 3:
                    System.out.println("Enter the id of the item you want to designate as NOT daily special");
                    found = false;
                    s = Input.intInput(0, 999999);
                    for(int i=0; i<Database.getSpecials().size();i++) {
                        if(s == Database.getSpecials().get(i).getID()) {
                            Database.getSpecials().get(i).setIsSpecial(false);
                            found = true;
                        }
                    }
                    if(found == false) {
                        System.out.println("No item with id " + s + " found."  );
                    }
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
    }

    /**
     * View active orders.
     */
    public void viewActiveOrders() {
        boolean cont = true;
        while(cont == true) {
            for(int i=0; i<Database.orderHistory.size(); i++) {
                if(Database.orderHistory.get(i).isChefComplete() == false) {
                    System.out.println(i+1 + "- " +
                    Database.orderHistory.get(i).toString());
                }
            }
            System.out.println("1.Complete an incomplete order");
            System.out.println("0.Go Back");
            int select = Input.intInput(0, 1);
            switch (select) {
                case 1:
                    System.out.println("Select an order to complete");
                    int order = Input.intInput(1, Database.orderHistory.size()+1)-1;
                    Database.orderHistory.get(order).setChefComplete(true);
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
    }

    /**
     * View menu items.
     */
    public void viewMenuItems() {
        boolean cont = true;
        while(cont == true) {
            for(int i=0; i<Database.menuItems.size(); i++) {
                if(Database.menuItems.get(i).getInMenu() == true) {
                    System.out.println(i+1 + "- " + Database.menuItems.get(i).toString() + 
                    " Menu Status: Actively In the menu");
                }else {
                    System.out.println(Database.menuItems.get(i).toString() + 
                    " Menu Status: Not In the menu");
                }
            }
            System.out.println("1.Change the menu status of an item");
            System.out.println("0.Go Back");
            int select = Input.intInput(0, 1);
            switch (select) {
                case 1: //switches menu states
                    System.out.println("Select an menu item");
                    int order = Input.intInput(1, Database.menuItems.size()+1) - 1;
                    if(Database.menuItems.get(order).getInMenu() == true){
                        Database.menuItems.get(order).setInMenu(false);
                    }else {
                        Database.menuItems.get(order).setInMenu(true);
                    }
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
    }

    /**
     * toString method for Chef (for menu displays)
     * @return Chef as a String
     */
    @Override
    public String toString() {
        return String.format(
            "%s %s, %s", 
            this.getFirstName(), 
            this.getLastName(), 
            "Chef"
        );
    }

    /**
     * Converts Chef to data String (for database storage)
     * @return Chef as a data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%s|%s\n", 
            this.getFirstName(), 
            this.getLastName(), 
            this.getId(), 
            "Chef"
        );
    }

}
