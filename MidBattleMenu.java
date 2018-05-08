import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Handles the battling of the dragons in the arena
 * 
 * @author Willianz Dietz
 */
public class MidBattleMenu extends DragonStats implements Fightable
{
    private int dragDamage, dragLevel, dragHealth; 
    private int enemyDamage, enemyLevel, enemyHealth;
    private double dragExp;
    private boolean hasAttackBoost; 
    private String dragType, dragName, environment;

    private String enemyType = new String("");
    private Scanner in;

    /**
     * MidBattleMenu Constructor
     *
     * @param name The name of the dragon
     * @param boost Whether or not the dragon has an attack boost
     * @param exp The exp of the dragon
     * @param level The dragon's level
     * @param type The dragon's type
     * @param health The dragon's health
     * @param environ The environment the arena takes place in
     * @param dragons The list of dragons
     */
    public MidBattleMenu(String name, boolean boost, double exp, int level, String type, int health, String environ, ArrayList<Dragon> dragons)
    {
        in = new Scanner(System.in);

        environment = new String(environ);
        dragName = new String(name);
        hasAttackBoost = boost;
        dragLevel = level;
        dragDamage = 0;
        dragExp = exp; 
        dragType = new String(type); 
        dragHealth = health;

        difficulty(dragons);
        battle(dragons);
    }//ends the constructor

    /**
     * Searches the ArrayList to get the location of the dragon in the list.
     *
     * @param dragons The list of dragons
     * @return The location of the dragon in the list
     */
    public int dragLoc(ArrayList<Dragon> dragons)
    {
        int dragLoc = 0;

        ArrayList<String> names = new ArrayList<String>();
        for(int i = 0; i < dragons.size(); i++)
        {
            names.add(dragons.get(i).getName());
        }//ends the for

        Iterator<String> namesItr = names.iterator();
        while(namesItr.hasNext())
        {
            if(namesItr.next().equals(dragName))
            {
                break;
            }
            dragLoc++;
        }//ends the while

        return dragLoc;
    }//ends the int

    /**
     * The user decides if they want to attack or save and quit
     *
     * @param dragons The list of dragons
     */
    public void decision(ArrayList<Dragon> dragons)
    {
        int choice; 
        int dragLoc = 0;

        System.out.println();
        System.out.println();
        System.out.println("1. Normal Attack ");
        System.out.println("2. " + dragType + " Attack");
        System.out.println("\n3. Info Menu");
        System.out.println("4. Save & Quit");

        boolean check = true;
        while(check)
        {
            choice = in.nextInt();
            if(choice == 1)
            {
                check = false;
                decideDamage(choice);
            }//ends the else if
            else if(choice == 2)
            {
                check = false;
                decideDamage(choice);
            }//ends the else if
            else if(choice == 3)
            {
                System.out.print('\u000C');
                System.out.println("ELEMENTAL DOMINANCE: \n");
                System.out.println("Water beats Fire");
                System.out.println("Fire beats Air");
                System.out.println("Air beats Earth");
                System.out.println("Earth beats Water");
                
                pressEnter();
                battle(dragons);
            }//ends the else if
            else if(choice == 4)
            {
                dragons.get(dragLoc(dragons)).setExp(dragExp);

                SaveGame save = new SaveGame(dragons);

                System.out.print('\u000C');

                String output = new String("");
                output += "Thank you for playing! \nSee you next time!";
                playText(output);
                pressEnter();
                System.exit(0);
            }//ends the else if
            else
            {
                System.out.println("ERROR: Invalid input!");
            }//ends the else
        }//ends the while
    }//ends the void

    /**
     * Sets the difficulty of the enemy dragon
     *
     * @param dragons The list of dragons
     */
    public void difficulty(ArrayList<Dragon> dragons)
    {
        Random rand = new Random();
        //System.out.println(enemyLevel);
        if(dragLevel <= 10)
        {
            enemyLevel = rand.nextInt(10)+1;
            enemyHealth = enemyLevel*2 + rand.nextInt((enemyLevel*2));
            enemyDamage = rand.nextInt(5) + 15;
        }//ends the if
        else if(dragLevel <= 20)
        {
            enemyLevel = rand.nextInt(20);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(10) + 4;
        }//ends the if
        else if(dragLevel <= 30)
        {
            enemyLevel = rand.nextInt(30);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(15) + 6;
        }//ends the if
        else if(dragLevel <= 40)
        {
            enemyLevel = rand.nextInt(40);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(20) + 8;
        }//ends the if
        else if(dragLevel <= 50)
        {
            enemyLevel = rand.nextInt(50);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(25) + 10;
        }//ends the if
        else if(dragLevel <= 60)
        {
            enemyLevel = rand.nextInt(60);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(30) + 12;
        }//ends the if
        else if(dragLevel <= 70)
        {
            enemyLevel = rand.nextInt(70);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(35) + 14;
        }//ends the if
        else if(dragLevel <= 80)
        {
            enemyLevel = rand.nextInt(80);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(40) + 16;
        }//ends the if
        else if(dragLevel <= 90)
        {
            enemyLevel = rand.nextInt(90);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(45) + 18;
        }//ends the if
        else if(dragLevel <= 100)
        {
            enemyLevel = rand.nextInt(100);
            enemyHealth = enemyLevel*2 + rand.nextInt(enemyLevel*2);
            enemyDamage = rand.nextInt(50) + 20;
        }//ends the if

        health();
        enemyType();
    }//ends the void

    /**
     * Sets the health of the user's dragon based on their level
     *
     */
    public void health()
    {
        Random rand = new Random();

        if(dragLevel <= 10)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2)+1;
        }//ends the else if
        else if(dragLevel <= 20)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 30)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 40)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 50)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 60)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 70)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 80)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 90)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel <= 100)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
        else if(dragLevel == 100)
        {
            dragHealth = dragLevel*2 + rand.nextInt(dragLevel*2);
        }//ends the else if
    }//ends the void

    /**
     * Sets the amount of damage the user's dragon will do.
     *
     * @param choice 1 or 2. Tells if the user clicked normal or special attack.
     */
    public void decideDamage(int choice)
    {
        Random rand = new Random();

        if(dragLevel <= 10)
        {
            dragDamage = rand.nextInt(10) + 10;
        }//ends the if
        else if(dragLevel <= 20)
        {
            dragDamage = rand.nextInt(18) + 20;
        }//ends the if
        else if(dragLevel <= 30)
        {
            dragDamage = rand.nextInt(25) + 30;
        }//ends the if
        else if(dragLevel <= 40)
        {
            dragDamage = rand.nextInt(34) + 40;
        }//ends the if
        else if(dragLevel <= 50)
        {
            dragDamage = rand.nextInt(48) + 50;
        }//ends the if
        else if(dragLevel <= 60)
        {
            dragDamage = rand.nextInt(90) + 60;
        }//ends the if
        else if(dragLevel <= 70)
        {
            dragDamage = rand.nextInt(126) + 70;
        }//ends the if
        else if(dragLevel <= 80)
        {
            dragDamage = rand.nextInt(195) + 80;
        }//ends the if
        else if(dragLevel <= 90)
        {
            dragDamage = rand.nextInt(300) + 90;
        }//ends the if
        else if(dragLevel <= 100)
        {
            dragDamage = rand.nextInt(500) + 100;
        }//ends the if
        else if(dragLevel == 100)
        {
            dragDamage = rand.nextInt(750) + 100;
        }//ends the if

        if(hasAttackBoost)
        {
            dragDamage *= 1.2;
        }//ends the if
        if(choice == 2) //The elemental attack
        {
            /*
             * Water beats Fire
             * Fire beats Air
             * Air beats Earth
             * Earth beats Water
             */
            
            //Water
            if(dragType.equals("Water") && enemyType.equals("Fire"))
            {
                dragDamage *= 1.12;
            }//ends the if
            else if(dragType.equals("Water") && enemyType.equals("Earth"))
            {
                dragDamage -= (dragDamage*0.12);
            }//ends the else if
            
            //Fire
            if(dragType.equals("Fire") && enemyType.equals("Air"))
            {
                dragDamage *= 1.12;
            }//ends the if
            else if(dragType.equals("Fire") && enemyType.equals("Water"))
            {
                dragDamage -= (dragDamage*0.12);
            }//ends the else if
            
            //Air
            if(dragType.equals("Air") && enemyType.equals("Earth"))
            {
                dragDamage *= 1.12;
            }//ends the if
            else if(dragType.equals("Air") && enemyType.equals("Fire"))
            {
                dragDamage -= (dragDamage*0.12);
            }//ends the else if
            
            //Earth
            if(dragType.equals("Earth") && enemyType.equals("Water"))
            {
                dragDamage *= 1.12;
            }//ends the if
            else if(dragType.equals("Earth") && enemyType.equals("Air"))
            {
                dragDamage -= (dragDamage*0.12);
            }//ends the else if
        }//ends the if
    }//ends the void

    /**
     * Decides the opposing dragon's type
     */
    public void enemyType()
    {
        Random rand = new Random();
        int i = rand.nextInt(1000);
        if(i <= 250)
        {
            enemyType = "Fire";
        }//ends the if
        else if(i <= 500)
        {
            enemyType = "Water";
        }//ends the else
        else if(i <= 750)
        {
            enemyType = "Wind";
        }
        else
        {
            enemyType = "Earth";
        }
    }//ends the void

    /**
     * The screen that refreshes while fighting in the arena.
     *
     */
    public void display()
    {
        System.out.print('\u000C'); //Clears the screen

        System.out.println(environment + "\n");
        System.out.printf("%s", dragName + "'s Stats: ");
        System.out.printf("%20s", "Enemy's Stats: \n");

        System.out.println("//=//=//=//=//=//=//=//=//=//=//=//=//=//\n");

        System.out.printf("%s", "Level: " + dragLevel);
        System.out.printf("%20s", "Level: " + enemyLevel + "\n");
        System.out.printf("%s", "Type: " + dragType);
        System.out.printf("%20s", "Type: " + enemyType + "\n");
        System.out.printf("%s", "Energy: " + dragHealth);
        System.out.printf("%20s", "Energy: " + enemyHealth + "\n");
    }//ends the void

    /**
     * Adds the exp to the dragon
     *
     * @param dragons The list of dragons
     */
    public void addExp(ArrayList<Dragon> dragons)
    {
        dragExp += 100.0;
        dragons.get(dragLoc(dragons)).setExp(dragExp);
        if(dragExp >= 1000.0)
        {
            dragExp = 0;
            levelUp(dragons);
        }//ends the if
        pressEnter();
    }//ends the void

    /**
     * Adds a level to the dragon and lets the user choose a new dragon
     *
     * @param dragons The list of dragons
     */
    public void levelUp(ArrayList<Dragon> dragons)
    {
        int dragLoc = 0;
        dragLevel += 1;

        String output = new String("");
        output = "\nYour dragon gained a level!\n";
        output += "You are now allowed to choose another dragon!";
        playText(output);
        pressEnter();

        dragons.get(dragLoc(dragons)).setLevel(dragLevel);

        infoMenu(dragons.get(0).getOwner(), dragons);
    }//ends the void

    /**
     * Keeps track of the health of the dragons and handles if they move on or fail
     *
     * @param dragons The list of dragons
     */
    public void battle(ArrayList<Dragon> dragons)
    {
        String attackMsg = new String("\nThe enemy is attacking...");
        String failMsg = new String("\nYour dragon is unable to battle! Saving...");
        String output = new String("");
        while(dragHealth > 0 || dragHealth == 0)
        {
            display();

            decision(dragons);
            enemyHealth -= dragDamage;

            display();
            if(enemyHealth < 0 || enemyHealth == 0)
            {
                output = "\nYou defeated the enemy dragon!\n";
                playText(output);
                pressEnter();

                output = "Your dragon earned exp!";
                playText(output);
                addExp(dragons);

                difficulty(dragons);
                battle(dragons);
            }//ends the if

            playText(attackMsg);
            dragHealth -= enemyDamage;
            pressEnter();

            display();
        }//ends the while

        SaveGame j = new SaveGame(dragons);
        playText(failMsg);
        output = "\nSAVED! ";
        playText(output);
        pressEnter();

        System.out.print('\u000C'); //Clears the screen
        output = "You blacked out...";
        playText(output);
        pressEnter();

        fightDragons(dragons);
    }//ends the void

}//ends the class
