import java.util.ArrayList;
/**
 * <h2>The type Menu.</h2>
 * @author Fatma Sehitoglu
 * @author Martin Dimitrov
 * @version 1.0
 */
public class Menu {

    //METHODS
    //=======

    /**
     * This is the method to display the menu and allow the user to make selections
     *
     * @return selections as an ArrayList of objects of MenuItem
     */
    public static ArrayList<MenuItem> selectFromMenu(){
        ArrayList<MenuItem> selections = new ArrayList<MenuItem>();
        int exit = -1;
        int noOfSpecials= Database.getSpecials().size();
        while(exit == -1) {
            System.out.println("Please enter the code of the item you want to select. Press 0 to finish the order");
            System.out.println("Today's Specials");
            for(int k=0; k<noOfSpecials; k++) {
                System.out.println((k+1000) + "- " + Database.getSpecials().get(k).toString() );
            }
            System.out.println("Menu");
            for(int k=0; k<Database.getActiveMenu().size(); k++) {
                System.out.println(k+1 + "- " + Database.getActiveMenu().get(k).toString() );
            }
            int input = Input.intInput(0,1000+noOfSpecials);
            if(input == 0) {
                exit = 0;
            } else if(input>0 && input<Database.getActiveMenu().size()+2) {
                input = input-1;
                selections.add(Database.getActiveMenu().get(input));
            } else if(input>999 && input<1000+noOfSpecials) { 
                input = input-1000;
                selections.add(Database.getSpecials().get(input));
            } else {
                System.out.println("Please enter a valid input");
            }
        }
        return selections;
    }

}
