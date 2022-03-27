import java.util.Scanner;

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

            Scanner in = new Scanner(System.in);
            while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
                System.out.println("1. Edit Staff");
                System.out.println("0. Exit Program");
                in.nextLine();
            }
            int select = in.nextInt();
            in.nextLine();

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
            while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
                System.out.println("1. ADD NEW STAFF MEMBER");
                for (int i = 0; i < Database.getStaffCount(); i++) {
                    System.out.println((i + 2) + ". " + Database.staffList.get(i).toString());
                }
                System.out.println("0. Back");
                in.nextLine();
            }
            int select = in.nextInt();
            in.nextLine();
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

        Scanner in = new Scanner(System.in);
        System.out.println("Enter role:\n1. Manager\n2. Waiter\n3. Chef\n4. Driver");
        while (!in.hasNextInt()) {   //checks whether the input is Int so program doesn't crash
            System.out.println("Enter role:\n1. Manager\n2. Waiter\n3. Chef\n4. Driver");
            in.nextLine();
        }
        role = in.nextInt();
        in.nextLine();



        System.out.println("Enter first name: ");
        firstName = in.nextLine();
        System.out.println("Enter last name: ");
        lastName = in.nextLine();
        System.out.println("Enter email address: ");
        id = in.nextLine();

        switch (role) {
            case 1:
                Staff newManager = new Manager(firstName, lastName, id);
                Database.addToStaffList(newManager);
                break;
            case 2:
                Staff newWaiter = new Waiter(firstName, lastName, id);
                Database.addToStaffList(newWaiter);
                break;
            case 3:
                Staff newChef = new Chef(firstName, lastName, id);
                Database.addToStaffList(newChef);
                break;
            case 4:
                Staff newDriver = new Driver(firstName, lastName, id);
                Database.addToStaffList(newDriver);
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
}
