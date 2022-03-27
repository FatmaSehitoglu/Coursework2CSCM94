import java.util.Scanner;
//import java.util.ArrayList;
class Coursework2 {
    public static void main(String[] args) {
        /*
        System.out.println("Hello World!"); 
        Scanner in = new Scanner(System.in);
        Customer cust1 = new Customer("fatma", "sh", "Swansea", "00011");
        System.out.println("Enter the date for the booking");
        String x = in.nextLine();
        System.out.println("Enter the time for the booking");
        String y = in.nextLine();
        System.out.println("Enter the number of guests for the booking");
        int guestNo = in.nextInt();
        cust1.requestBooking(x,y,guestNo);
        */

        /*
        Menu mainMenu = new Menu();
        Menu menu = mainMenu;
        menu.selectFromMenu();
        */

        Manager george = new Manager("George", "Mallard", "george@mallard.com");
        Database.addToStaffList(george);

        User user = mainLogin();
        user.displayMainMenu();          
        
    }

    public static User mainLogin() {
        User user = null;
        boolean cont = true;
        while (cont) {
            System.out.println("Welcome to Cafe 94\n1. Customer Login\n2. Staff Login\n3. Exit");
            Input.intInput(1, 3);
            if (select == 1) {
                user = customerLogin();
            } else if (select == 2) {
                user = staffLogin();
            } else {
                cont = false;
            }
        }
        return user;
    }

    public static customerLogin() {
        boolean cont = true;
        while (cont) {
            System.out.println("Enter email address:");
            String id = Input.stringInput();
        }
    }




}
