import java.util.ArrayList;

public class Menu {

    MenuItem Pizza = new MenuItem(1,"Pepperoni", "Pizza");
    MenuItem Pasta = new MenuItem(2, "Carbonara", "Pasta");

    public static ArrayList<MenuItem>menuItems = new ArrayList<>();
public static void addMenuItem(MenuItem item){
    menuItems.add(item);
    }
}
