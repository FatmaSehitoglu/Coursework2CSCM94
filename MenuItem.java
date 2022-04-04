/**
 * The type Menu item.
 */
public class MenuItem {
    private int ID;
    private String price;
    private String name;
    private Boolean inMenu;
    private Boolean isSpecial;

    //CONSTRUCTOR
    //===========

    /**
     * Instantiates a new Menu item.
     *
     * @param ID        the id
     * @param price     the price
     * @param name      the name
     * @param inMenu    the in menu
     * @param isSpecial the is special
     */
    public MenuItem(int ID, String price, String name, Boolean inMenu, Boolean isSpecial) {
        this.ID = ID;
        this.price = price;
        this.name = name;
        this.inMenu = inMenu;
        this.isSpecial = isSpecial;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
//SETTERS
    //=======
    public void setID(int ID) {
        this.ID = ID;
        Database.refreshMenuItems();
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
        Database.refreshMenuItems();
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
        Database.refreshMenuItems();
    }

    /**
     * Sets in menu.
     *
     * @param setInMenu the set in menu
     */
    public void setInMenu(Boolean setInMenu) {
        this.inMenu = setInMenu;
        Database.refreshMenuItems();
    }

    /**
     * Sets is special.
     *
     * @param isSpecial the is special
     */
    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
        Database.refreshMenuItems();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
//GETTERS
    //=======
     public int getID() {
        return ID;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets in menu.
     *
     * @return the in menu
     */
    public Boolean getInMenu() {
        return inMenu;
    }

    /**
     * Gets is special.
     *
     * @return the is special
     */
    public Boolean getIsSpecial() {
        return isSpecial;
    } 

    @Override
    public String toString() {
        return String.format("%s %s %d", name, price, ID);
    }

    /**
     * To data string string.
     *
     * @return the string
     */
    public String toDataString() {
        return String.format("%d|%s|%s|%b|%b", ID, price, name, inMenu, isSpecial);
    }
    
}
