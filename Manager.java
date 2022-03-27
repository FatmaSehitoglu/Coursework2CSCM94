import java.util.Scanner;

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
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. Edit Staff");
            System.out.println("0. Exit Program");

            Scanner in = new Scanner(System.in);
            int select = in.nextInt();
            
            if (select == 1) {
                displayStaff();
            } else if (select == 0) {
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
            Scanner in = new Scanner(System.in);
            int select = in.nextInt();
            if (select == 1) {
                addStaff();
            } else if (select == 0) {
                cont = false;
            } else {
                editStaff(select - 2);
            }


        } 
    }


    public void addStaff() {
        String firstName = "";
        String lastName = "";
        String id = "";
        int role = -1;
        String temp = "";

        Scanner in = new Scanner(System.in);
        System.out.println("Enter role:\n1. Manager\n2. Waiter\n3. Chef\n4. Driver");
        role = in.nextInt();
        temp = in.next();


        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter last name: ");
        lastName = in.nextLine();
        System.out.println("Enter email address: ");
        id = in.nextLine();

        switch (role) {
            case 1:
                Staff newStaff = new Manager(firstName, lastName, id);
                break;
            case 2:
                Staff newStaff = new Waiter(firstName, lastName, id);
                break;
            case 3:
                Staff newStaff = new Chef(firstName, lastName, id);
                break;
            case 4:
                Staff newStaff = new Driver(firstName, lastName, id);
                break;
        }

        Database.addToStaffList(newStaff);





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
        return String.format("%s %s, %s", this.firstName, this.lastName, "Manager");
    }
}
