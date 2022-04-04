public class Main {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
    
        /*
        Menu mainMenu = new Menu();
        Menu menu = mainMenu;
        menu.selectFromMenu();
        */
        Database.populateDb();
        InterfaceLogin.mainLogin();
    }
}
