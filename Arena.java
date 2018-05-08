import java.util.ArrayList;

/**
 * This starts the arena where the dragons level up.
 * 
 * @author Brandon Bruno
 */
public class Arena extends MenuHub
{
    /**
     * Arena Constructor
     *
     * @param dragons The list of dragons
     */
    public Arena(ArrayList<Dragon> dragons)
    {
        arenaIntro(dragons);
    }//ends the constructor
    
    /**
     * Starts the arena and tells the user to pick one of their dragons to use.
     *
     * @param dragons The list of dragons
     */
    public void arenaIntro(ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C');
        System.out.println("Welcome to the arena!");
        System.out.println("Please choose a dragon you want to enter with!");
        pressEnter();
        listDragons(dragons);
    }//ends the void
}//ends the class