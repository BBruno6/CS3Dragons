
/**
 * Abstract class AbstractClass - write a description of the class here
 *
 * @author (your name here)
 */
public abstract class DragonStats extends MenuHub
{
    //ALL DRAGONS SHOULD USE THIS. OURS AND ENEMY DRAGONS
    
    /**
     * Tracks the user's health
     */
    public abstract void health();
    /**
     * How much damage the user will do
     * @param move If the user chose a normal or special attack
     */
    public abstract void decideDamage(int move); 
    /**
     * Decides the opposing dragon's type
     */
    public abstract void enemyType();
}
