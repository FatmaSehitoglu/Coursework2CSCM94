public class Manager extends Staff {

    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTOR
    //===========
    public Manager(String firstName, String lastName, String id) {
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
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Edit Staff");
            System.out.println("0. Exit Program");

            int select = Input.intInput(0, 1);

            if (select == 1) {
                //1. Edit Staff
                displayStaff();
            } else if (select == 0) {
                //0. Exit Program
                cont = false;
            }
        }
    }

    public void displayStaff() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. ADD NEW STAFF MEMBER");
            for (int i = 0; i < Database.getStaffCount(); i++) {
                System.out.println((i + 2) + ". " + Database.staffList.get(i).toString());
            }
            System.out.println("0. Back");

            int select = Input.intInput(0, Database.getStaffCount() + 2);
            
            if (select == 1) {
                //1. ADD NEW STAFF MEMBER
                addStaff();
            } else if (select == 0) {
                //0. Back
                cont = false;
            } else {
                //2 - n. (Staff member)
                editStaff(select - 2);
            }
        } 
    }

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

    public void removeStaff() {
        //add code here
    }

    public void editStaff(int n) {
        //add code here
    }

    //public void approveEvent() {} (not implemented)
    
    public Customer getMostActiveCustomer() {
        Customer mostActive = Database.mostActiveCustomer();
        return mostActive;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Manager");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s", this.getFirstName(), this.getLastName(), this.getId(), "Manager");
    }
}
