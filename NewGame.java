import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * If there is no save file, the user will start the story from the beginning.
 *
 * @author Brandon Bruno
 */
public class NewGame extends MenuHub
{
    private String owner;
    private Scanner input;
    
    /**
     * Constructor for objects of class NewGame
     * 
     * @param  dragons  The ArrayList of dragons
     */
    public NewGame(ArrayList<Dragon> dragons)
    {
        owner = new String("");
        input = new Scanner(System.in);

        startStory(dragons);
    }//ends the constructor

    /**
     * The introduction to why the dragons are fighting.
     *
     * @param  dragons  The ArrayList of dragons
     */
    public void startStory(ArrayList<Dragon> dragons)
    {
        String output = new String("");
        output = "Long ago there lived a great dragon tamer... \n";
        output += "This was before the greed of humanity...";
        playText(output);
        pressEnter();

        output = "People have invaded the dragons' territory\n";
        output += "and the dragons have been retaliating. Without\n";
        output += "the great dragon tamer, the dragons have been\n";
        output += "flying free, destroying village after village...";
        playText(output);
        pressEnter();

        chooseFirstDragon(output, dragons);

    }//ends the void

    /**
     * After the intro, the user will choose the dragon they want to fight with in the arena.
     * 
     * @param  output  The String that is going to be outputed
     * @param  dragons  The ArrayList of dragons
     */
    private void chooseFirstDragon(String output, ArrayList<Dragon> dragons)
    {
        output = "But now we have you, traveler!\n";
        output += "You will keep these dragons at bay!\n";
        output += "If it's not too much to ask, what is your name?: ";
        playText(output);

        owner = input.nextLine();
        System.out.print('\u000C'); //Clears the screen
        
        output = "What a nice name, " + owner + "!\n";
        output += "It's time for you to tame your first dragon...\n";
        output += "You will battle with your new ally to fight off\n";
        output += "all of these rogue dragons and save us all!\n";
        playText(output);
        pressEnter();
        
        infoMenu(owner, dragons);
    }//ends the void

    /**
     * Calls the arena driver.
     */
    private void playArena(ArrayList<Dragon> dragons)
    {
        Arena j = new Arena(dragons);
    }//ends the void
}//ends the class
