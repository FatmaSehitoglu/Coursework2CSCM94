import java.util.ArrayList;
public class Waiter extends Staff {
    
    //FIELDS
    //======
    //private firstName     (inherited)
    //private lastName      (inherited)
    //private staffId       (inherited)

    //CONSTRUCTOR
    //===========
    public Waiter(String firstName, String lastName, String staffId) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(staffId);
    }

    //METHODS
    //=======
    public void displayMainMenu() {
        boolean cont = true;
        while (cont) {
            System.out.println("Profile : " + toDataString());  
            System.out.println("1. New Eat In Order");
            System.out.println("2. View Active Orders");
            System.out.println("3. View Booking");
            System.out.println("0. Log Out");

            int select = Input.intInput(0, 3);

            switch (select) {
                case 1:
                    newEatInOrder();
                    break;
                case 2:
                    viewActiveOrders();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 0:
                    cont = false;
                    break;
            }
        }        
    }

    public void newEatInOrder() {
        int tableId = -1;
        //System.out.println("Enter table number: ");
        //tableId = Input.intInput(1, 999999);
        //String waiterId = this.getId();
        System.out.println("Enter customer id:");
        String cID = Input.stringInput();
        ArrayList<MenuItem> selection = new ArrayList<MenuItem>();
        selection = Menu.selectFromMenu();
        Eat_in order = new Eat_in(cID, selection, true, tableId, this.id);
        Database.addToOrderHistory(order);
    }

    public void viewActiveOrders() {
        int con = -1;
        while(!(con==0)) {
            for(int i=0;i<Database.orderHistory.size(); i++) {
                if(Database.orderHistory.get(i).isOrderComplete() == false) {
                    System.out.println(Database.orderHistory.get(i).toString());
                } 
            }
            System.out.println("To Approve a delivery Select 1");
            System.out.println("To cancel an order Select 2");
            System.out.println("To Go Back Select 0");
            int select = Input.intInput(0, 2);
            switch (select) {
                case 1:
                    System.out.println("Select a delivery to approve");
                    int app = Input.intInput(1, Database.orderHistory.size());
                    Database.orderHistory.get(app).setApproval(true);
                    break;
                case 2:
                    System.out.println("Select an order to cancel");
                    int cancel = Input.intInput(1, Database.orderHistory.size());
                    cancelOrder(Database.orderHistory.get(cancel);
                    break;
                case 0:
                    con = 0;
                    break;
            }
        }
    }

    public void viewBookings() {
        int bookingToApprove = -1;
        while(!(bookingToApprove==0)) {
            System.out.println("Select a Booking to Approve");
            for(int i = 0; i<Database.bookingHistory.size(); i++) {
                System.out.println(i+1 + " : " + Database.bookingHistory.get(i).toString());
            }
            System.out.println("Select a Booking to Approve or press 0 to go back");
            bookingToApprove = Input.intInput(0, Database.bookingHistory.size()+1);
            if(!(bookingToApprove == 0)) {
                Database.bookingHistory.get(bookingToApprove-1).setApproved(true);
            }else {
                break;
            }    
        }               
    }


    public void cancelOrder(Order order) {
        for(int i=0; i<Database.orderHistory.size(); i++) {
            if(order.equals(Database.orderHistory.get(i))) {
                Database.orderHistory.remove(i);
            }
        }
    }

    public void approveBooking(Booking booking) {
        booking.setApproved(true);
    }

    public void approveDelivery(Delivery delivery) {
        delivery.setApproval(true);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.getFirstName(), this.getLastName(), "Waiter");
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s", this.getFirstName(), this.getLastName(), this.getId(), "Waiter");
    }

}
