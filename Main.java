public class Main {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
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
        Database.populateDb();
        InterfaceLogin.mainLogin();
    }
}
