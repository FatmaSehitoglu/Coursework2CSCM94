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
            System.out.println("1. New Eat In Order");
            System.out.println("2. View Active Orders");
            System.out.println("3. View Active Bookings");
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
                    viewActiveBookings();
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
        ArrayList<MenuItem> selection = new ArrayList<>();
        selection = Menu.selectFromMenu();
        Eat_in order = new Eat_in(cID, selection, true, tableId, this.id);
        Database.addToOrderHistory(order);
    }

    public void viewActiveOrders() {

    }

    public void viewActiveBookings() {

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
