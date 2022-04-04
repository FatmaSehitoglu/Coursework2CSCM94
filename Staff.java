/**
 * <h1>User class</h1>
 * Subclass of User, abstract superclass for Manager, Waiter, Driver and Chef
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @version 1.0
 */
public abstract class Staff extends User{
    
    //FIELDS
    //======

    //private String firstName;     (inherited)
    //private String lastName;      (inherited)
    //private String id;            (inherited)
    //Shift[] hoursToWork;          (not implemented)
    private int totalHoursWorked = 0;

    //CONSTRUCTORS
    //============

    /**
     * 
     * @param firstName as a String
     * @param lastName  as a String
     * @param id        as a String
     */
    public Staff (
        String firstName, 
        String lastName, 
        String id
    ) {
        super(firstName, lastName, id);
    }

    //SETTERS
    //=======

    /**
     * Sets firstName
     * @param firstName as a String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Database.refreshStaff();
    }

    /**
     * Sets lastName
     * @param lastName as a String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
        Database.refreshStaff();
    }

    /**
     * Sets id
     * @param id as a String
     */
    public void setId(String id) {
        this.id = id;
        Database.refreshStaff();
    }

    /**
     * Increments hours worked
     * @param n number of hours worked as an int
     */
    public void incrementHoursWorked(int n) {
        this.totalHoursWorked += n;
        Database.refreshStaff();
    }

    //GETTERS
    //=======

    /**
     * Gets hours worked
     * @return totalHoursWorked as an int
     */
    public int getHoursWorked() {
        return totalHoursWorked;
    }

    /**
     * Abstract method for returning data Strings used in Database storage
     * @return Staff member as a data String
     */
    public abstract String toDataString();

}
