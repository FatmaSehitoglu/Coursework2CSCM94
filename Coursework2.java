import java.util.Scanner;
//import java.util.ArrayList;
class Coursework2 {
    public static void main(String[] args) {
        /*
        System.out.println("Hello World!"); 
        Scanner in = new Scanner(System.in);
        Customer cust1 = new Customer("fatma", "sh", "Swansea", "00011");
        //String x = in.nextLine();
       // String y = in.nextLine();
        cust1.requestBooking("7","4",3);
        System.out.println(Database.getBookingHistory().get(0).getTime());
        */

        Manager george = new Manager("George", "Mallard", "george@mallard.com");
        Database.addToStaffList(george);
        User user = george;
        user.displayMainMenu();




    }
}
