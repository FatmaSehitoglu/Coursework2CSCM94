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
    public void displayStaff() {
        boolean cont = true;
        while (cont) {
            System.out.println("1. ADD NEW STAFF MEMBER");
            for (int i = 0; i < Database.getStaffCount(); i++) {
                System.out.println((i + 2) + Database.staffList.get(i).toString());
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
