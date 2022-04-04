/**
 * <h2>The type Menu item.</h2>
 * @author Martin
 * @version 1.0
 */
public class MenuItem {

    //FIELDS
    //======

    private int id;
    private String price;
    private String name;
    private Boolean inMenu;
    private Boolean isSpecial;

    //CONSTRUCTORS
    //============

    /**
     * Instantiates a new Menu item.
     *
     * @param id        the id as an int
     * @param price     the price as a String
     * @param name      the name as a String
     * @param inMenu    the in menu as a Boolean
     * @param isSpecial the is special as a Boolean
     */
    public MenuItem(
        int id,
        String price, 
        String name, 
        Boolean inMenu, 
        Boolean isSpecial
    ) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.inMenu = inMenu;
        this.isSpecial = isSpecial;
    }

    //SETTERS
    //=======

    /**
     * Sets id.
     * @param id the id as an int
     */
    public void setID(int id) {
        this.id = id;
        Database.refreshMenuItems();
    }

    /**
     * Sets price.
     * @param price the price as a String
     */
    public void setPrice(String price) {
        this.price = price;
        Database.refreshMenuItems();
    }

    /**
     * Sets name.
     * @param name the name as a String
     */
    public void setName(String name) {
        this.name = name;
        Database.refreshMenuItems();
    }

    /**
     * Sets in menu.
     * @param setInMenu the set in menu as a boolean
     */
    public void setInMenu(Boolean setInMenu) {
        this.inMenu = setInMenu;
        Database.refreshMenuItems();
    }

    /**
     * Sets is special.
     * @param isSpecial the is special as a boolean
     */
    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
        Database.refreshMenuItems();
    }

    //GETTERS
    //=======

    /**
     * Gets id.
     * @return the id as an int
     */
     public int getID() {
        return id;
    }

    /**
     * Gets price.
     * @return the price as a String
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets name.
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets in menu.
     * @return the in menu as a boolean
     */
    public Boolean getInMenu() {
        return inMenu;
    }

    /**
     * Gets is special.
     * @return the is special as a boolean
     */
    public Boolean getIsSpecial() {
        return isSpecial;
    }

    //METHODS
    //=======

    /**
     * toString method for MenuItem (for menu displays)
     * @return MenuItem as a String
     */
    @Override
    public String toString() {
        return String.format("%s %s %d", name, price, ID);
    }

    /**
     * Converts MenuItem to a data String (for database storage)
     * @return MenuItem as a data String
     */
    public String toDataString() {
        return String.format("%d|%s|%s|%b|%b", ID, price, name, inMenu, isSpecial);
    }
    
}
