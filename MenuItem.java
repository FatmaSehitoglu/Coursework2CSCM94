public class MenuItem {
    private int ID;
    private String description;
    private String name;
    private Boolean inMenu;
    private Boolean isSpecial;

    public MenuItem(int ID, String description, String name, Boolean inMenu, Boolean isSpecial) {
        this.ID = ID;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return String.format("%s\n%s", name, description);
    }

    public String toDataString() {
        return String.format("%s|%s|%s|%s|%s", ID, description, name, inMenu, isSpecial);
    }

    
}
