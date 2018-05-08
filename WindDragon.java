import java.util.Random;
import java.util.Scanner;

/**
 * Creates and adds the required information in order to create a new WindDragon.
 * 
 * @author Brandon Bruno
 */
public class WindDragon extends Dragon implements Tamable
{    
    private Scanner input;
    
    /**
     * Default constructor for class WaterDragon.
     */
    public WindDragon()
    {
        System.out.println("ERROR: Dragon has no owner!");
    }//ends the default constructor
    /**
     * Constructor for when making a new dragon.
     * 
     * @param  owner  The owner of the dragon
     */
    public WindDragon(String owner)
    {
        input = new Scanner(System.in);
        
        setType("Wind");
        setOwner(owner);
        decideNature();
        decideGender();
        decideName();
        setLevel(1);
        setExp(0);
    }//ends the constructor
    /**
     * Constructor for when reading the dragon from a file.
     * 
     * @param  type  The type of dragon
     * @param  owner  The owner of the dragon
     * @param  nature  The nature of the dragon
     * @param  name  The name of the dragon
     * @param  gender  The sex of the dragon
     * @param  level  The level of the dragon
     * @param  exp  The amount of EXP the dragon has
     */
    public WindDragon(String type, String owner, String nature, String name, String gender, int level, double exp)
    {
        setType(type);
        setOwner(owner);
        setNature(nature);
        setName(name);
        setGender(gender);
        setLevel(level);
        setExp(exp);
    }//ends the constructor
    
    /**
     * If the dragon is found without a nature, this method gives the dragon a nature. 
     */
    public void decideNature()
    {
        String nature = new String("");
        Random rand = new Random();
        int i = rand.nextInt(100);
        if(i <= 25)
        {
            nature = "Very mischievous. Enjoys hiding objects in plain sight";
        }//ends the if
        else if(i > 25 && i <= 50)
        {
            nature = "Loves to spend time sleeping on the clouds";
        }//ends the else if
        else if(i > 50 && i <= 75)
        {
            nature = "Is very playful";
        }//ends the else if
        else
        {
            nature = "Loves to perform dances in the air";
        }
        
        setNature(nature);
    }//ends the void
    
    /**
     * If the dragon is found without a name, this method gives the dragon a name. 
     */
    public void decideName()
    {
        System.out.println("What do want your newly tamed WIND dragon to be named?");
        String name = new String(input.nextLine());
        
        setName(name);
    }//ends the void
    
    /**
     * If the dragon is found without a gender, this method gives the dragon a gender. 
     * Wind dragons have a 52% chance to be female and a 48% chance to be male. 
     */
    public void decideGender()
    {
        String gender = new String("");
        Random rand = new Random();
        int i = rand.nextInt(100);
        if(i <= 52)
        {
            gender = "Female";
        }//ends the if
        else
        {
            gender = "Male";
        }//ends the else
        
        setGender(gender);
    }//ends the void
}//ends the class
