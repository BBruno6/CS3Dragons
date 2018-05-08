import java.util.ArrayList;

/**
 * Write a description of interface opponent here.
 *
 * @author Willianz Dietz
 */
public interface Fightable
{
    /**
     * Determines the strength of the enemy dragon.
     * @param dragons The list of dragons
     */
    public void difficulty(ArrayList<Dragon> dragons);
}//ends the interface
