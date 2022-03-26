public abstract class User {
    //FIELDS
    //======
    String firstName;
    String lastName;

    //SETTERS
    //=======
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //GETTERS
    //=======
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
