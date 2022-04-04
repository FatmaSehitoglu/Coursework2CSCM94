/**
 * <h2>Main class</h2>
 * @author Martin Dimitrov
 * @version 1.0
 */
public class Main {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
    
        Database.populateDb();
        InterfaceLogin.mainLogin();
    }
}
