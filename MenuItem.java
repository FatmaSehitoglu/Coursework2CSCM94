public class MenuItem {
    private int ID;
    private String price;
    private String name;
    private Boolean inMenu;
    private Boolean isSpecial;

    public MenuItem(int ID, String description, String name, Boolean inMenu, Boolean isSpecial) {
        this.ID = ID;
        this.price = price;
        this.name = name;
        this.inMenu = inMenu;
        this.isSpecial = isSpecial;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInMenu() {
        return inMenu;
    }

    public void setInMenu(Boolean setInMenu) {
        this.inMenu = setInMenu;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", name, price, ID);
    }

    public String toDataString() {
        return String.format("%d|%s|%s|%b|%b", ID, price, name, inMenu, isSpecial);
    }

    
}
