import java.util.*; 
/**
 * This class is going to create the arena basically and sets the environment from
 * the past class. This also declares the boost so that the dragon has their
 * stats boosted if they are in the same 
 */
public class BattleArena extends MenuHub 
{
    private String dragName; 
    private String dragType; 
    private int dragLevel, myLocation, damage, dragHealth; 
    private double dragExp;
    private String climate;
    private boolean boost = false; 
    
    /**
     * BattleArena Constructor
     *
     * @param dragonName The name of the dragon
     * @param dragonType The type of the dragon
     * @param level The level of the dragon
     * @param exp The exp of the dragon
     * @param location The terrain the dragon will be fighting in
     * @param dmg The damage the dragon will do
     * @param health The health the dragon has
     */
    public BattleArena(String dragonName, String dragonType, int level, double exp, int location, int dmg, int health, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen
        System.out.println("You have entered the Battle Arena!");
        pressEnter();
        
        dragName = dragonName; 
        dragType = dragonType;             
        dragLevel = level; 
        dragExp = exp; 
        myLocation = location;  
        dragHealth = health; 
        
        setLocation(location, dragons); 
        
    }//ends the constructor
    
    /**
     * Sets the location the arena will take place in.
     *
     * @param location The arena environment
     * @param dragons The list of dragons
     */
    private void setLocation(int location, ArrayList<Dragon> dragons)
    {
        if(location == 1)
        {
            climate = "the Fiery Castle"; 
            if(dragType.equals("Fire"))
            {
                boost = true; 
            }//ends the if
        }//ends the if
        else if(location == 2)
        {
            climate = "the Tropical Island"; 
            if(dragType.equals("Water"))
            {
                boost = true; 
            } //ends the if
        }//ends the else if
        else if(location == 3)
        {
            climate = "the Air Temple"; 
            if(dragType.equals("Air"))
            {
                boost = true; 
            }//ends the if
        }//ends the else if
        else if(location == 4){
            climate = "the Rocky Mountains"; 
            if(dragType.equals("Earth")){
                //System.out.println("YOU HAVE RECIEVED A BOOST!");
                boost = true; 
            }//ends the if
        }//ends the else if
        String environ = new String("You find yourself at " + climate);
        MidBattleMenu j = new MidBattleMenu(dragName, boost, dragExp, dragLevel, dragType, dragHealth, environ, dragons);
    }//ends the void
}//ends the class