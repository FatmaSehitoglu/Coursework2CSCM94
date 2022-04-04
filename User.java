/**
 * <h2>User class</h2>
 * Abstract superclass for Customer and Staff
 * @author Fatma Sehitoglu
 * @author Chris Litting
 * @version 1.0
 */
public abstract class User {

    //FIELDS
    //======

    public String firstName;
    public String lastName;
    public String id;

    //CONSTRUCTORS
    //============

    /**
     * Constructor for User
     * @param firstName as a String
     * @param lastName  as a String
     * @param id        as a String
     */
    public User (
        String firstName, 
        String lastName, 
        String id
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //SETTERS
    //=======

    /**
     * Sets firstName
     * @param firstName as a String
     */
    public abstract void setFirstName(String firstName);

    /**
     * Sets lastName
     * @param lastName as a String
     */
    public abstract void setLastName(String lastName);

    /**
     * Sets id
     * @param id as a String
     */
    public abstract void setId(String id);

    //GETTERS
    //=======

    /**
     * Gets firstName
     * @return firstName as a String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get lastName
     * @return lastName as a String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets id
     * @return id as a String
     */
    public String getId() {
        return this.id;
    }

    //ABSTRACT METHODS
    //======== =======

    /**
     * Displays main menu for each subclass of User
     */
    public abstract void displayMainMenu();

}
