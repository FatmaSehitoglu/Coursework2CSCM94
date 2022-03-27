class Coursework2 {
    public static void main(String[] args) {
        /*
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

        Manager georgeMallard = new Manager("George", "Mallard", "george@mallard.com");
        Database.addToStaffList(georgeMallard);

        mainLogin();
    }

    //Main login page for app
    private static void mainLogin() {
        boolean cont = true;
        while (cont) {
            System.out.println("Welcome to Cafe 94\n1. Customer Login\n2. Staff Login\n3. New Customer\n4. Exit");
            int select = Input.intInput(1, 4);
            if (select == 1) {
                customerLogin();
            } else if (select == 2) {
                staffLogin();
            } else if (select == 3) {
                customerSignup();
            } else {
                cont = false;
            }
        }
    }

    //Login page for existing Customers
    private static void customerLogin() {
        Customer user = null;
        boolean cont = true;
        while (cont) {
            System.out.println("Enter email address:");
            String id = Input.stringInput();
            if (Database.checkCustomer(id)) {
                user =  Database.getCustomer(id);
                cont = false;
                user.displayMainMenu();
            } else {
                System.out.println("Customer email not found\n1. Try again\n2. Sign up\n3. Back to main menu");
                int select = Input.intInput(1, 3);
                if (select == 2) {
                    cont = false;
                    customerSignup();
                } else if (select == 3){
                    cont = false;
                }
            }
        }
    }

    //Login page for existing Staff members
    private static void staffLogin() {
        Staff user = null;
        boolean cont = true;
        while (cont) {
            System.out.println("Enter email address:");
            String id = Input.stringInput();
            if (Database.checkStaff(id)) {
                user = Database.getStaff(id);
                cont = false;
                //checks staffUsers class and shows different menus accordingly
                if(user.getClass() == Manager.class) {
                    user.displayMainMenu();
                }else if(user.getClass() == Waiter.class) {
                    user.displayMainMenu();
                }else if(user.getClass() == Chef.class) {
                    user.displayMainMenu();
                }else {
                    user.displayMainMenu();
                }
                
            } else {
                System.out.println("Customer email not found\n1. Try again\n2. Back to main menu");
                int select = Input.intInput(1, 2);
                if (select == 2) {
                    cont = false;
                }
            }
        }    
    }

    //Sign up page for new Customers
    private static void customerSignup() {
        System.out.println("Enter first name:");
        String firstName = Input.stringInput();
        System.out.println("Enter last name:");
        String lastName = Input.stringInput();
        System.out.println("Enter your home address (or leave blank):");
        String address = Input.stringInput();
        System.out.println("Enter email address:");
        String email1 = Input.stringInput();
        Customer cust = new Customer(firstName, lastName, address, email1);
        Database.addToCustomerList(cust);
        System.out.println("\nWelcome to Cafe94 " + firstName + "!\n");
    }

}
