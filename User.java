public abstract class User {
    //FIELDS
    //======
    public String firstName;
    public String lastName;
    public String id;

    //SETTERS
    //=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

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
