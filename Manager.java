/**
 * <h2>Manager class</h2>
 * A subclass of Staff
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @author Niu Zhaoye
 * @version 1.0
 */
public class Manager extends Staff {

    //FIELDS
    //======

    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTORS
    //============

    /**
     * Constructor for new Manager.
     *
     * @param firstName as a String
     * @param lastName  as a String
     * @param id        as a String
     */
    public Manager(
        String firstName, 
        String lastName, 
        String id
    ) {
        super(firstName, lastName, id);
    }
   
    //METHODS
    //=======

    /**
     * Displays the main menu for Manager
     */
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Edit Staff");
            System.out.println("2. Most Popular Items Report");
            System.out.println("3. Most Active Customer Report");
            System.out.println("4. Highest Hours Worked By A Staff Member");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 4);
            switch (select) {
                case 1:
                    displayStaff();
                    break;
                case 2:
                    getMostPopularItems();
                    break;
                case 3:
                    getMostActiveCustomer();
                    break;
                case 4:
                    mostWorkedStaff();
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }
    }

    /**
     * Displays the menu for editing staff members
     */
    public void displayStaff() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Add New Staff Member");
            System.out.println("2. Add Hours Worked To A Staff Member");
            for (int i = 0; i < Database.getStaffCount(); i++) {
                System.out.println((i + 3) + "- " + Database.staffList.get(i).toString());
            }
            System.out.println("0. Back");

            int select = Input.intInput(0, Database.getStaffCount() + 3);
            
            if (select == 1) {
                //1. ADD NEW STAFF MEMBER
                addStaff();
            }else if (select == 2){
                System.out.println("Select the staff you want to add hours worked");
                select = (Input.intInput(3, Database.getStaffCount() + 3)) - 3;
                System.out.println("How many hours worked would you like to add to " +
                Database.getStaffList().get(select).getFirstName() +
                " " + Database.getStaffList().get(select).getLastName() +
                "'s record?");
                int hour = Input.intInput(1, 100);
                Database.getStaffList().get(select).incrementHoursWorked(hour);
                System.out.println(Database.getStaffList().get(select).getFirstName() +
                " " + Database.getStaffList().get(select).getLastName() + ": " +
                Database.getStaffList().get(select).getHoursWorked() + 
                " total hours worked.");
            
            } else if (select == 0) {
                //0. Back
                cont = false;
            } else {
                //2 - n. (Staff member)
                editStaff(select - 3);
            }
        } 
    }

    /**
     * Displays menu for adding staff
     */
    public void addStaff() {
        String firstName = "";
        String lastName = "";
        String id = "";
        int role = -1;
        System.out.println("Enter role:\n1. Manager\n2. Waiter\n3. Chef\n4. Driver");
        role = Input.intInput(1,4);
        System.out.println("Enter first name: ");
        firstName = Input.stringInput();
        System.out.println("Enter last name: ");
        lastName = Input.stringInput();
        System.out.println("Enter email address: ");
        id = Input.stringInput();
        switch (role) {
            case 1:
                Staff newManager = new Manager(firstName, lastName, id);
                Database.addNewStaff(newManager);
                break;
            case 2:
                Staff newWaiter = new Waiter(firstName, lastName, id);
                Database.addNewStaff(newWaiter);
                break;
            case 3:
                Staff newChef = new Chef(firstName, lastName, id);
                Database.addNewStaff(newChef);
                break;
            case 4:
                Staff newDriver = new Driver(firstName, lastName, id);
                Database.addNewStaff(newDriver);
                break;
        }
    }

    /**
     * A method that allows Manager to remove staff
     * @param staff as a Staff
     */
    public void removeStaff(Staff staff) {

        if (Database.removeStaffFromDatabase(staff.getId())){
            System.out.println("Delete is successful");
        }else {
            System.out.println("Delete failed");
        }
    }

    /**
     * A method that lets the manager edit staff
     * @param n the index of the Staff member in the Database Staff ArrayList
     */
    public void editStaff(int n) {
        Input.intInput(1,4);
        int choose;
        String change;
        Staff staff =  Database.staffList.get(n);
        System.out.println("What would you like to change?");
        System.out.println("1. Change first name");
        System.out.println("2. Change last name");
        System.out.println("3. Change ID");
        System.out.println("4. Remove staff member");

        Lo:
        while (true){
            System.out.println("Please enter your choice (1,2,3):");
            choose = Input.intInput(1,4);
            switch (choose){
                case 1:
                    System.out.println("Please enter new first name:");
                    change = Input.stringInput();
                    staff.setFirstName(change);
                    System.out.println("success!");
                    break;
                case 2:
                    System.out.println("Please enter new last name:");
                    change = Input.stringInput();
                    staff.setLastName(change);
                    System.out.println("success!");
                    break;
                case 3:
                    System.out.println("Please enter new ID:");
                    change = Input.stringInput();
                    staff.setId(change);
                    System.out.println("success!");
                    break;
                case 4:
                    lo:
                    while (true){
                        System.out.println("Are you sure you want to delete this staff member? (yes or no)");
                        change = Input.stringInput();
                        if (change.equalsIgnoreCase("yes")) {
                            removeStaff(staff);
                            break Lo;
                        }else if (change.equalsIgnoreCase("no")){
                            continue Lo;
                        }else {
                            System.out.println("Incorrect input. Please try again");
                            continue lo;
                        }
                    }
            }
        }
    }

    //public void approveEvent() {} (not implemented)

    /**
     * A method to display the most active customer
     */
    public void getMostActiveCustomer() {
        Customer mostActive = Database.mostActiveCustomer();
        int sum = 0;
        for(int i = 0; i<Database.getOrderHistory().size(); i++) {
            if(mostActive.getID().contentEquals(Database.getOrderHistory().get(i).getCustomID()) ) {
                sum = sum + 1;
            }
        }
        System.out.println("The Most Active Customer: " + 
        mostActive.getFirstName() +
        " " + mostActive.getLastName() +
        " with " + sum +
        " orders." );
    }

    /**
     * A method to show the most popular items
     */
    public void getMostPopularItems() {
        int max = 0;
        String maxName = "";
        System.out.println("Popularity Of Each Menu Item:");
        for(int i=0; i<Database.getMenu().size(); i++) {
            int sum = 0;
            MenuItem item = Database.getMenu().get(i);
            int itemID= item.getID();
            for(int k=0; k<Database.getOrderHistory().size(); k++) {
                for(int l=0; l<Database.getOrderHistory().get(k).getItems().size(); l++) {
                    if(itemID == (Database.getOrderHistory().get(k).getItems().get(l).getID())) {
                        sum = sum + 1;
                    }
                }
            }
            if(sum > max) {
                max = sum;
                maxName = item.getName();
            }
            System.out.println(item.getID() + " " +
            item.getName() + " -> " + sum);
        }
        System.out.println("The most popular item is " +
        maxName + " with " +
        max + " times ordered." );
    }

    /**
     * Prints highest number of hours worked by a Staff member
     */
    public void mostWorkedStaff() {
        int maxHour = 0;
        int maxIndex = 0;
        for(int i = 0; i<Database.getStaffCount(); i++) {
            if(Database.getStaffList().get(i).getHoursWorked() > maxHour) {
                maxHour = Database.getStaffList().get(i).getHoursWorked();
                maxIndex = i;
            }
        }
        if(maxHour == 0) {
            System.out.println("Total Hours worked by all staff is 0 hours");
        }else {
            System.out.println("The highest number of hours worked is " +
            maxHour + " by " + Database.getStaffList().get(maxIndex).getFirstName() +
            " " + Database.getStaffList().get(maxIndex).getLastName() );
        }
    }

    /**
     * toString method for Manager (for menu displays)
     * @return Manager as a String
     */
    @Override
    public String toString() {
        return String.format(
            "%s %s, %s", 
            this.getFirstName(), 
            this.getLastName(), 
            "Manager"
        );
    }

    /**
     * Converts Manager to a data string (for database storage)
     * @return Manager as a data String
     */
    public String toDataString() {
        return String.format(
            "%s|%s|%s|%s\n", 
            this.getFirstName(), 
            this.getLastName(), 
            this.getId(), 
            "Manager"
        );
    }

}
