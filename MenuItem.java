public class MenuItem {
    private int ID;
    private String price;
    private String name;
    private Boolean inMenu;
    private Boolean isSpecial;

    //CONSTRUCTOR
    //===========

    /**
     *
     * @param ID
     * @param price
     * @param name
     * @param inMenu
     * @param isSpecial
     */
    public MenuItem(int ID, String price, String name, Boolean inMenu, Boolean isSpecial) {
        this.ID = ID;
        this.price = price;
        this.name = name;
        this.inMenu = inMenu;
        this.isSpecial = isSpecial;
    }

    //SETTERS
    //=======
    public void setID(int ID) {
        this.ID = ID;
        Database.refreshMenuItems();
    }

    public void setPrice(String price) {
        this.price = price;
        Database.refreshMenuItems();
    }
    
    public void setName(String name) {
        this.name = name;
        Database.refreshMenuItems();
    }

    public void setInMenu(Boolean setInMenu) {
        this.inMenu = setInMenu;
        Database.refreshMenuItems();
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
        Database.refreshMenuItems();
    }

    //GETTERS
    //=======
     public int getID() {
        return ID;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Boolean getInMenu() {
        return inMenu;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    } 

    @Override
    public String toString() {
        return String.format("%s %s %d", name, price, ID);
    }

    public String toDataString() {
        return String.format("%d|%s|%s|%b|%b", ID, price, name, inMenu, isSpecial);
    }
    
}
