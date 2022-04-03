public abstract class User {
    //FIELDS
    //======
    public String firstName;
    public String lastName;
    public String id;

    public User (String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //SETTERS
    //=======
    public abstract void setFirstName(String firstName);

    public abstract void setLastName(String lastName);

    public abstract void setId(String id);

    //GETTERS
    //=======
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getId() {
        return this.id;
    }

    //ABSTRACT METHODS
    //======== =======
    public abstract void displayMainMenu();

}
