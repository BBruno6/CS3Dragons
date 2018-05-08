import java.util.Scanner; 
import java.util.ArrayList;

public class ChoosePath extends MenuHub
{
    private String dragonName; 
    private String dragonType;
    private int dragonLevel;
    private double dragonExp;
    private int choice, damage, health;
    private Scanner in;

    /**
     * ChoosePath Constructor
     *
     * @param name The name of the dragon
     * @param type The dragon's type
     * @param level The dragon's level
     * @param exp The experience the dragon has.
     * @param dragons The list of dragons.
     */
    public ChoosePath(String name, String type, int level, double exp, ArrayList<Dragon> dragons)
    {
        in = new Scanner(System.in);

        dragonName = name; //This gets the name of the dragon
        dragonType = type; //This gets the dragons type
        dragonLevel = level; //This gets the level of the dragon
        dragonExp = exp; //This gets the xp

        routeMenu(dragons);
    }//ends the constructor

    /**
     * Welcomes the player and creates a random route number, depending on that number it
     * also choses the environment based off that route num
     * 
     * @param dragons The list of dragons 
     */
    public void routeMenu(ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C');
        System.out.println("Please select one of the Routes!"); 
        System.out.println("The Dragon you are using is " + dragonName);
        System.out.println("The type of this dragon is " + dragonType);

        int route1, route2, route3, route4; 
        boolean loop = true; 
        route1 = routeNum(); 
        System.out.println("1. Route " + route1);

        route2 = routeNum(); 
        System.out.println("2. Route " + route2);

        route3 = routeNum(); 
        System.out.println("3. Route " + route3);

        route4 = routeNum(); 
        System.out.println("4. Route " + route4);

        //Makes sure that the user puts in a number 1-4
        while(loop == true)
        {
            choice = in.nextInt();  

            if(choice == 1)
            {
                Integer environment = new Integer(environment(route1)); //Integer wrapper
                int environ = environment.intValue();
                 
                loop = false; 
                BattleArena battle = new BattleArena(dragonName, dragonType, dragonLevel, dragonExp, environ, damage, health, dragons); 
            }//ends the if
            else if(choice == 2)
            {
                Integer environment = new Integer(environment(route2)); //Integer wrapper
                int environ = environment.intValue();
                ///int environ = environment(route2); 
                loop = false; 
                BattleArena battle = new BattleArena(dragonName, dragonType, dragonLevel, dragonExp, environ, damage, health, dragons);
            }//ends the else if
            else if(choice == 3)
            {
                Integer environment = new Integer(environment(route3)); //Integer wrapper
                int environ = environment.intValue();
                loop = false; 
                BattleArena battle = new BattleArena(dragonName, dragonType, dragonLevel, dragonExp, environ, damage, health, dragons);
            }//ends the else if
            else if(choice == 4)
            {
                Integer environment = new Integer(environment(route4)); //Integer wrapper
                int environ = environment.intValue();
                loop = false; 
                BattleArena battle = new BattleArena(dragonName, dragonType, dragonLevel, dragonExp, environ, damage, health, dragons);
            }//ends the else if
            else
            {
                System.out.println("Invalid input, please put a number!");
                choice = in.nextInt(); 
            }//ends the else
        }//ends the while
    }//ends the void

}//ends the class