import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Abstract class MenuHub - All of the pop up text so it can be reused. 
 * 
 * @author Brandon Bruno
 */
public class MenuHub
{
    private Scanner input;
    private Scanner choice;

    /**
     * Constructor for class MenuHub
     */
    public MenuHub()
    {
        input = new Scanner(System.in);
        choice = new Scanner(System.in);
    }//ends the constructor

    /**
     * Outputs text that tells and waits for the user to press the enter key. 
     * Upon pressing enter, the screen will clear. 
     */
    public void pressEnter()
    {
        System.out.println();
        System.out.println(); 
        System.out.println("Press \"ENTER\" to continue...");
        input.nextLine();
        System.out.print('\u000C'); //Clears the screen
    }//ends the void

    /**
     * Turns the String named output (pulled from another method) into an array of Chars. 
     * The method then outputs the array one char at a time to add an animation like
     * the text is typing itself.
     * 
     * @param  output  String that is going to be outputed.
     */
    public void playText(String output)
    {
        for (char i : output.toCharArray()) //toCharArray turns a string into an array of characters
        {
            try        
            {
                if(i == '.' || i == '!')
                {
                    Thread.sleep(75);
                    System.out.print(i);
                }//ends the if
                else
                {
                    Thread.sleep(50);
                    System.out.print(i);
                }//ends the else
            }//ends the try
            catch(InterruptedException e) 
            {
                System.out.println("ERROR: " + e.getMessage());
            }//ends the catch
        }//ends the for
    }//ends the void

    /**
     * Menu that allows a user to see the backstories on the different types of dragons.
     * 
     * @param  owner  The owner of the dragon (used for when making a new dragon)
     * @param  dragons  The ArrayList of all the types of dragons.
     */
    public void infoMenu(String owner, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen
        System.out.println("PICK A DRAGON!!");
        System.out.println("You will battle with your new ally to fight off");
        System.out.println("all of these rogue dragons and save us all!\n");

        System.out.println("1. Fire");
        System.out.println("2. Water");
        System.out.println("3. Earth");
        System.out.println("4. Wind");

        int decide = choice.nextInt();
        if(decide == 1)
        {
            fireInfo(owner, dragons);
        }
        else if(decide == 2)
        {
            waterInfo(owner, dragons);
        }
        else if(decide == 3)
        {
            earthInfo(owner, dragons);
        }
        else if(decide == 4)
        {
            windInfo(owner, dragons);
        }
        else
        {
            System.out.println("ERROR: Invalid choice! Please pick again!");
            pressEnter();
            infoMenu(owner, dragons);
        }
    }//ends the void

    /**
     * Outputs the story behind water dragons and allows the user to choose the dragon.
     * 
     * @param  owner  The owner of the dragon
     * @param  dragons  The ArrayList of dragons
     */
    public void waterInfo(String owner, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen
        System.out.println("Water is the life and purity that this world ");
        System.out.println("has. Water dragons are extremely friendly "); 
        System.out.println("and do their best to make their masters happy."); 
        System.out.println("However, don't let their smiles fool you!"); 
        System.out.println("Water dragons are fierce when they feel threatened"); 
        System.out.println("and they could destroy their foes with powerful moves!"); 
        System.out.println("They're best at fighting fire, and water is one of the"); 
        System.out.println("rarest dragons around!"); 

        System.out.println("_      _    _____    _______     _____  __ __    ");
        System.out.println("/_/\\  /\\_\\  /\\___/\\ /\\_______)\\ /\\_____\\/_/\\__/\\  ");
        System.out.println(") ) )( ( ( / / _ \\ \\\\(___  __\\/( (_____/) ) ) ) ) ");
        System.out.println("/_/ //\\\\ \\_\\\\ \\(_)/ /  / / /     \\ \\__\\ /_/ /_/_/  ");
        System.out.println("\\ \\ /  \\ / // / _ \\ \\ ( ( (      / /__/_\\ \\ \\ \\ \\  ");
        System.out.println(")_) /\\ (_(( (_( )_) ) \\ \\ \\    ( (_____\\)_) ) \\ \\ ");
        System.out.println("\\_\\/  \\/_/ \\/_/ \\_\\/  /_/_/     \\/_____/\\_\\/ \\_\\/ ");

        System.out.println("Will you choose this dragon? (Y/N): ");
        String decide = new String("");
        decide = choice.nextLine();
        boolean isSelecting = true;
        while(isSelecting)
        {
            decide = choice.nextLine();
            if(decide.equals("y") || decide.equals("Y"))
            {
                isSelecting = false;
                dragons.add(new WaterDragon(owner));
                System.out.print('\u000C'); //Clears the screen
                SaveGame j = new SaveGame(dragons);
                Arena play = new Arena(dragons);
            }//ends the if
            else if(decide.equals("n") || decide.equals("N"))
            {
                isSelecting = false;
                infoMenu(owner, dragons);
            }//ends the else if
            else
            {
                isSelecting = true;
                int check = 1;
                try
                {
                    check = Integer.parseInt(decide);
                }
                catch(Exception e)
                {
                }
                if(check == 1 || check == 2 || check == 3 || check == 4)
                {
                    //THIS IF IS HERE TO PREVENT THE ERROR MESSAGE FOR SHOWING BEFORE THE
                    //USER TYPED Y OR N.
                }//ends the if
                else
                {
                    System.out.println("ERROR: Invalid input! Please try again.");
                }//ends the else
            }//ends the else
        }//ends the while
    }//ends the void

    /**
     * Outputs the story behind fire dragons and allows the user to choose the dragon.
     * 
     * @param  owner  The owner of the dragon
     * @param  dragons  The ArrayList of dragons
     */
    public void fireInfo(String owner, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen
        System.out.println("Fire is a crucial weapon and tool to our");
        System.out.println("world. Fire dragons are full of wonder "); 
        System.out.println("and are naturally strong and wise. However, "); 
        System.out.println("if not treated with care, fire dragons will turn their"); 
        System.out.println("power on their masters and try to overthrow"); 
        System.out.println("any kingdom in sight. This rage is usually calmed with "); 
        System.out.println("victory in a heated battle or by basking in a "); 
        System.out.println("volcano. If fire dragons are given the respect they deserve, "); 
        System.out.println("they are one of the most reliable dragons to have around!");

        System.out.println(" (     (    (         ");
        System.out.println(" )\\ )  )\\ ) )\\ )      ");
        System.out.println("(()/( (()/((()/( (    ");
        System.out.println(" /(_)) /(_))/(_)))\\   ");
        System.out.println("_))_|(_)) (_)) ((_)  ");
        System.out.println("| |_  |_ _|| _ \\| __| ");
        System.out.println("| __|  | | |   /| _|  ");
        System.out.println("|_|   |___||_|_\\|___| ");

        System.out.println("Will you choose this dragon? (Y/N): ");
        String decide = new String("");
        decide = choice.nextLine();
        boolean isSelecting = true;
        while(isSelecting)
        {
            decide = choice.nextLine();
            if(decide.equals("y") || decide.equals("Y"))
            {
                isSelecting = false;
                dragons.add(new FireDragon(owner));
                System.out.print('\u000C'); //Clears the screen
                SaveGame j = new SaveGame(dragons);
                Arena play = new Arena(dragons);
            }//ends the if
            else if(decide.equals("n") || decide.equals("N"))
            {
                isSelecting = false;
                infoMenu(owner, dragons);
            }//ends the else if
            else
            {
                isSelecting = true;
                int check = 1;
                try
                {
                    check = Integer.parseInt(decide);
                }
                catch(Exception e)
                {
                }
                if(check == 1 || check == 2 || check == 3 || check == 4)
                {
                    //THIS IF IS HERE TO PREVENT THE ERROR MESSAGE FOR SHOWING BEFORE THE
                    //USER TYPED Y OR N.
                }//ends the if
                else
                {
                    System.out.println("ERROR: Invalid input! Please try again.");
                }//ends the else
            }//ends the else
        }//ends the while
    }//ends the void

    /**
     * Outputs the story behind earth dragons and allows the user to choose the dragon.
     * 
     * @param  owner  The owner of the dragon
     * @param  dragons  The ArrayList of dragons
     */
    public void earthInfo(String owner, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen

        System.out.println("Earth dragons gather their power from the ");
        System.out.println("land around them. They are extremely independent"); 
        System.out.println("and slow. They usually wait for an attacking dragon to"); 
        System.out.println("attack and hit back twice as strong. They have a "); 
        System.out.println("vendetta against people because of the damage humans"); 
        System.out.println("do to the world, thus making them a very hard dragon to tame. "); 
        System.out.println("But once tamed, earth dragons never leave their master's side, "); 
        System.out.println("making them an extremely trustworthy ally. "); 

        System.out.println("      ,----.   ,---.                  ,--.--------.  ,--.-,,-,--, ");
        System.out.println("   ,-.--` , \\.--.'  \\      .-.,.---. /==/,  -   , -\\/==/  /|=|  | ");
        System.out.println("  |==|-  _.-`\\==\\-/\\ \\    /==/  `   \\==\\.-.  - ,-./|==|_ ||=|, | ");
        System.out.println("  |==|   `.-./==/-|_\\ |  |==|-, .=., |`--`\\==\\- \\   |==| ,|/=| _| ");
        System.out.println(" /==/_ ,    /\\==\\,   - \\ |==|   '='  /     \\==\\_ \\  |==|- `-' _ | ");
        System.out.println(" |==|    .-' /==/ -   ,| |==|- ,   .'      |==|- |  |==|  _     | ");
        System.out.println(" |==|_  ,`-./==/-  /\\ - \\|==|_  . ,'.      |==|, |  |==|   .-. ,\\ ");
        System.out.println(" /==/ ,     |==\\ _.\\=\\.-'/==/  /\\ ,  )     /==/ -/  /==/, //=/  | ");
        System.out.println(" `--`-----`` `--`        `--`-`--`--'      `--`--`  `--`-' `-`--`         ");

        System.out.println("Will you choose this dragon? (Y/N): ");
        String decide = new String("");
        decide = choice.nextLine();
        boolean isSelecting = true;
        while(isSelecting)
        {
            decide = choice.nextLine();
            if(decide.equals("y") || decide.equals("Y"))
            {
                isSelecting = false;
                dragons.add(new EarthDragon(owner));
                System.out.print('\u000C'); //Clears the screen
                SaveGame j = new SaveGame(dragons);
                Arena play = new Arena(dragons);
            }//ends the if
            else if(decide.equals("n") || decide.equals("N"))
            {
                isSelecting = false;
                infoMenu(owner, dragons);
            }//ends the else if
            else
            {
                isSelecting = true;
                int check = 1;
                try
                {
                    check = Integer.parseInt(decide);
                }
                catch(Exception e)
                {
                }
                if(check == 1 || check == 2 || check == 3 || check == 4)
                {
                    //THIS IF IS HERE TO PREVENT THE ERROR MESSAGE FOR SHOWING BEFORE THE
                    //USER TYPED Y OR N.
                }//ends the if
                else
                {
                    System.out.println("ERROR: Invalid input! Please try again.");
                }//ends the else
            }//ends the else
        }//ends the while
    }//ends the void

    /**
     * Outputs the story behind wind dragons and allows the user to choose the dragon.
     * 
     * @param  owner  The owner of the dragon
     * @param  dragons  The ArrayList of dragons
     */
    public void windInfo(String owner, ArrayList<Dragon> dragons)
    {
        System.out.print('\u000C'); //Clears the screen
        System.out.println("Wind dragons, being the balance of the other ");
        System.out.println("forces of nature, tend to avoid wars. These"); 
        System.out.println("dragons take the side of people by creating"); 
        System.out.println("a powerful fog to keep people hidden. If"); 
        System.out.println("a wind dragon is betrayed, however, they will create"); 
        System.out.println("a massive tornado that will destroy anything it touches.");

        System.out.println("    _                                       ");
        System.out.println("   ' )       )      )                     /'");
        System.out.println("    /     _/      /                    /'  ");
        System.out.println("   /    _/~/    _/~O  ,____     _____,/'    ");
        System.out.println("  /  _/~  /  _/~ /'  /'    )  /'    /'      ");
        System.out.println(" /_/~    /_/~  /'  /'    /' /'    /'        ");
        System.out.println("/~      /~    (__/'    /(__(___,/(__           ");     

        System.out.println("Will you choose this dragon? (Y/N): ");
        String decide = new String("");
        decide = choice.nextLine();
        boolean isSelecting = true;
        while(isSelecting)
        {
            decide = choice.nextLine();
            if(decide.equals("y") || decide.equals("Y"))
            {
                isSelecting = false;
                dragons.add(new WindDragon(owner));
                System.out.print('\u000C'); //Clears the screen
                SaveGame j = new SaveGame(dragons);
                Arena play = new Arena(dragons);
            }//ends the if
            else if(decide.equals("n") || decide.equals("N"))
            {
                isSelecting = false;
                infoMenu(owner, dragons);
            }//ends the else if
            else
            {
                isSelecting = true;
                int check = 1;
                try
                {
                    check = Integer.parseInt(decide);
                }
                catch(Exception e)
                {
                }
                if(check == 1 || check == 2 || check == 3 || check == 4)
                {
                    //THIS IF IS HERE TO PREVENT THE ERROR MESSAGE FOR SHOWING BEFORE THE
                    //USER TYPED Y OR N.
                }//ends the if
                else
                {
                    System.out.println("ERROR: Invalid input! Please try again.");
                }//ends the else
            }//ends the else
        }//ends the while
    }//ends the void

    /**
     * Divides the ArrayList of dragons into separate array lists so their contents can be searched
     * with an Iterator. 
     *
     * @param dragons The ArrayList of dragons
     */
    public void listDragons(ArrayList<Dragon> dragons)
    {
        /*
         * ==================================================================
         * ================ SPLITS THE ARRAYLIST OF DRAGONS =================
         * ==================================================================
         */
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> owners = new ArrayList<String>();
        ArrayList<String> natures = new ArrayList<String>();
        ArrayList<String> genders = new ArrayList<String>();
        ArrayList<Integer> levels = new ArrayList<Integer>();
        ArrayList<Double> exps = new ArrayList<Double>();

        for(int i = 0; i < dragons.size(); i++)
        {
            types.add(dragons.get(i).getType());
            owners.add(dragons.get(i).getOwner());
            names.add(dragons.get(i).getName());
            natures.add(dragons.get(i).getNature());
            genders.add(dragons.get(i).getGender());
            levels.add(dragons.get(i).getLevel());
            exps.add(dragons.get(i).getExp());
        }//ends the for

        /*
         * ===================================================
         * ================ THE LISTING PART =================
         * ===================================================
         */

        Iterator<String> typesItr = types.iterator();
        Iterator<String> namesItr = names.iterator();
        Iterator<String> naturesItr = natures.iterator();
        Iterator<String> gendersItr = genders.iterator();
        Iterator<String> ownersItr = owners.iterator();
        Iterator<Integer> levelsItr = levels.iterator();
        Iterator<Double> expsItr = exps.iterator();

        System.out.print('\u000C'); //Clears the screen
        System.out.println("You look inside of the dragons den. Which type of your ");
        System.out.println("tamed dragons do you want to see?\n");
        System.out.println("1. Fire");
        System.out.println("2. Water");
        System.out.println("3. Earth");
        System.out.println("4. Wind");
        int decide = choice.nextInt();

        if(decide == 1)
        {
            int i = 1;
            boolean repeat = true;
            System.out.print('\u000C'); //Clears the screen
            System.out.println("LISTING DRAGON TYPES: Fire");
            while(typesItr.hasNext()) //Keeps track of when the itr reaches its end.
            {
                int dragonNum = 1;
                int level = 0;
                double exp = 0.0;
                boolean check = false;
                String yn = new String("");
                while(repeat) //Looks for "Fire" dragons. In a while in case user has more than one fire dragon.
                {
                    if(!(typesItr.hasNext()) && dragonNum == 1)
                    {
                        System.out.println("ERROR: No dragon of this type found!");
                        pressEnter();
                        repeat = false;
                        break;
                    }//ends the if
                    else if( !(typesItr.hasNext()) )
                    {
                        break;
                    }//ends the else if
                    else if(typesItr.next().equals("Fire"))
                    {
                        String name = new String("");
                        String nature = new String("");
                        String gender = new String("");
                        String owner = new String("");
                        
                        //Sets the iterators to start from the beginning
                        namesItr = names.iterator();
                        naturesItr = natures.iterator();
                        gendersItr = genders.iterator();
                        ownersItr = owners.iterator();
                        levelsItr = levels.iterator();
                        expsItr = exps.iterator();
                        
                        for(int j = 0; j < i; j++)
                        {
                            name = namesItr.next();
                            nature = naturesItr.next();
                            gender = gendersItr.next();
                            owner = ownersItr.next();
                            level = levelsItr.next();
                            exp = expsItr.next();
                        }//ends the for

                        System.out.println("DRAGON #" + dragonNum + ": ");
                        System.out.println("    Name: " + name);
                        System.out.println("    Nature: " + nature);
                        System.out.println("    Gender: " + gender);
                        System.out.println("    Level: " + level);
                        System.out.println("    Exp: " + exp);
                        dragonNum += 1;

                        System.out.println("Do you want to use this dragon? (Y/N): ");
                        //yn = choice.nextLine();
                        check = false;
                        while(check == false)
                        {
                            yn = choice.nextLine();
                            if(yn.equals("Y") || yn.equals("y"))
                            {
                                check = true;
                                repeat = false;
                                ChoosePath go = new ChoosePath(name, "Fire", level, exp, dragons);
                            }//ends the if
                            else if(yn.equals("N") || yn.equals("n"))
                            {
                                check = true;
                                repeat = true;
                            }//ends the else if
                            else if(yn.equals(""))
                            {
                            }//ends the else if
                        }//ends the while
                    }//ends the if
                    i++;
                }//ends the while
                listDragons(dragons);
            }//ends the while
        }//ends the if
        else if(decide == 2)
        {
            int i = 1;
            boolean repeat = true;
            System.out.print('\u000C'); //Clears the screen
            System.out.println("LISTING DRAGON TYPES: Water");
            while(typesItr.hasNext())
            {
                int dragonNum = 1;
                int level = 0;
                double exp = 0.0;
                boolean check = false;
                String yn = new String("");
                while(repeat) //Looks for "Water" dragons. In a while in case user has more than one water dragon.
                {
                    if(!(typesItr.hasNext()) && dragonNum == 1)
                    {
                        System.out.println("ERROR: No dragon of this type found!");
                        pressEnter();
                        repeat = false;
                        break;
                    }//ends the if
                    else if( !(typesItr.hasNext()) )
                    {
                        break;
                    }//ends the else if
                    else if(typesItr.next().equals("Water"))
                    {
                        String name = new String("");
                        String nature = new String("");
                        String gender = new String("");
                        String owner = new String("");
                        
                        //Sets the iterators to start from the beginning
                        namesItr = names.iterator();
                        naturesItr = natures.iterator();
                        gendersItr = genders.iterator();
                        ownersItr = owners.iterator();
                        levelsItr = levels.iterator();
                        expsItr = exps.iterator();

                        for(int j = 0; j < i; j++)
                        {
                            name = namesItr.next();
                            nature = naturesItr.next();
                            gender = gendersItr.next();
                            owner = ownersItr.next();
                            level = levelsItr.next();
                            exp = expsItr.next();
                        }//ends the for

                        System.out.println("DRAGON #" + dragonNum + ": ");
                        System.out.println("    Name: " + name);
                        System.out.println("    Nature: " + nature);
                        System.out.println("    Gender: " + gender);
                        System.out.println("    Level: " + level);
                        System.out.println("    Exp: " + exp);
                        dragonNum += 1;

                        System.out.println("Do you want to use this dragon? (Y/N): ");
                        check = false;
                        while(check == false)
                        {
                            yn = choice.nextLine();
                            if(yn.equals("Y") || yn.equals("y"))
                            {
                                check = true;
                                repeat = false;
                                ChoosePath go = new ChoosePath(name, "Water", level, exp, dragons);
                            }//ends the if
                            else if(yn.equals("N") || yn.equals("n"))
                            {
                                check = true;
                                repeat = true;
                            }//ends the else if
                            else if(yn.equals(""))
                            {
                            }//ends the else if
                        }//ends the while
                    }//ends the if
                    i++;
                }//ends the while
                listDragons(dragons);
            }//ends the while
        }//ends the else if
        else if(decide == 3)
        {
            int i = 1;
            boolean repeat = true;
            System.out.print('\u000C'); //Clears the screen
            System.out.println("LISTING DRAGON TYPES: Earth");
            while(typesItr.hasNext())
            {
                int dragonNum = 1;
                int level = 0;
                double exp = 0.0;
                boolean check = false;
                String yn = new String("");
                while(repeat) //Looks for "Earth" dragons. In a while in case user has more than one earth dragon.
                {
                    if(!(typesItr.hasNext()) && dragonNum == 1)
                    {
                        System.out.println("ERROR: No dragon of this type found!");
                        pressEnter();
                        repeat = false;
                        break;
                    }//ends the if
                    else if( !(typesItr.hasNext()) )
                    {
                        break;
                    }//ends the else if
                    else if(typesItr.next().equals("Earth"))
                    {
                        String name = new String("");
                        String nature = new String("");
                        String gender = new String("");
                        String owner = new String("");
                        
                        //Sets the iterators to start from the beginning
                        namesItr = names.iterator();
                        naturesItr = natures.iterator();
                        gendersItr = genders.iterator();
                        ownersItr = owners.iterator();
                        levelsItr = levels.iterator();
                        expsItr = exps.iterator();

                        for(int j = 0; j < i; j++)
                        {
                            name = namesItr.next();
                            nature = naturesItr.next();
                            gender = gendersItr.next();
                            owner = ownersItr.next();
                            level = levelsItr.next();
                            exp = expsItr.next();
                        }//ends the for

                        System.out.println("DRAGON #" + dragonNum + ": ");
                        System.out.println("    Name: " + name);
                        System.out.println("    Nature: " + nature);
                        System.out.println("    Gender: " + gender);
                        System.out.println("    Level: " + level);
                        System.out.println("    Exp: " + exp);
                        dragonNum += 1;

                        System.out.println("Do you want to use this dragon? (Y/N): ");
                        //yn = choice.nextLine();
                        check = false;
                        while(check == false)
                        {
                            yn = choice.nextLine();
                            if(yn.equals("Y") || yn.equals("y"))
                            {
                                check = true;
                                repeat = false;
                                ChoosePath go = new ChoosePath(name, "Earth", level, exp, dragons);
                            }//ends the if
                            else if(yn.equals("N") || yn.equals("n"))
                            {
                                check = true;
                                repeat = true;
                            }//ends the else if
                            else if(yn.equals(""))
                            {
                            }//ends the else if
                        }//ends the while
                    }//ends the if
                    i++;
                }//ends the while
                listDragons(dragons);
            }//ends the while
        }//ends the else if
        else if(decide == 4)
        {
            int i = 1;
            boolean repeat = true;
            System.out.print('\u000C'); //Clears the screen
            System.out.println("LISTING DRAGON TYPES: Wind");
            while(typesItr.hasNext())
            {
                int dragonNum = 1;
                int level = 0;
                double exp = 0.0;
                boolean check = false;
                String yn = new String("");
                while(repeat) //Looks for "Wind" dragons. In a while in case user has more than one wind dragon.
                {
                    if(!(typesItr.hasNext()) && dragonNum == 1)
                    {
                        System.out.println("ERROR: No dragon of this type found!");
                        pressEnter();
                        repeat = false;
                        break;
                    }//ends the if
                    else if( !(typesItr.hasNext()) )
                    {
                        break;
                    }//ends the else if
                    else if(typesItr.next().equals("Wind"))
                    {
                        String name = new String("");
                        String nature = new String("");
                        String gender = new String("");
                        String owner = new String("");
                        
                        //Sets the iterators to start from the beginning
                        namesItr = names.iterator();
                        naturesItr = natures.iterator();
                        gendersItr = genders.iterator();
                        ownersItr = owners.iterator();
                        levelsItr = levels.iterator();
                        expsItr = exps.iterator();

                        for(int j = 0; j < i; j++)
                        {
                            name = namesItr.next();
                            nature = naturesItr.next();
                            gender = gendersItr.next();
                            owner = ownersItr.next();
                            level = levelsItr.next();
                            exp = expsItr.next();
                        }//ends the for

                        System.out.println("DRAGON #" + dragonNum + ": ");
                        System.out.println("    Name: " + name);
                        System.out.println("    Nature: " + nature);
                        System.out.println("    Gender: " + gender);
                        System.out.println("    Level: " + level);
                        System.out.println("    Exp: " + exp);
                        dragonNum += 1;

                        System.out.println("Do you want to use this dragon? (Y/N): ");
                        //yn = choice.nextLine();
                        check = false;
                        while(check == false)
                        {
                            yn = choice.nextLine();
                            if(yn.equals("Y") || yn.equals("y"))
                            {
                                check = true;
                                repeat = false;
                                ChoosePath go = new ChoosePath(name, "Wind", level, exp, dragons);
                            }//ends the if
                            else if(yn.equals("N") || yn.equals("n"))
                            {
                                check = true;
                                repeat = true;
                            }//ends the else if
                            else if(yn.equals(""))
                            {
                            }//ends the else if
                        }//ends the while
                    }//ends the if
                    i++;
                }//ends the while
                listDragons(dragons);
            }//ends the while
        }//ends the else if
        else
        {
            System.out.println("ERROR: Invalid choice! Please pick again!");
            pressEnter();
            listDragons(dragons); 
        }//ends the else
    }//ends the void

    /**
     * Calls the ArenaDriver
     */
    public void fightDragons(ArrayList<Dragon> dragons)
    {
        Arena run = new Arena(dragons);
    }//ends the void

    /**
     * Sets up the random amount of damage the dragon can do
     *
     * @param level The level of the dragon
     * @return Returns the damage the dragon will do
     */
    public int damage(int level)
    {
        int damage = (int )(Math.random() * 50 + 1);
        damage = level/2 * damage; 
        return damage;
    }//ends the int

    /**
     * Names the different paths the user must choose from
     *
     * @return The random number that route will be named off of
     */
    public int routeNum()
    {
        int route = (int )(Math.random() * 99 + 1);
        return route; 
    }//ends the int

    /**
     * Decides which terrain the arena will be in
     *
     * @param environment The choice that the user made
     * @return The enviornment path the user will take
     */
    public int environment(int environment)
    {
        environment = environment % 5; 
        if(environment == 0)
        {
            int rand = (int )(Math.random() * 4 + 1);
            environment = rand;
        }//ends the if

        return environment;
    }//ends the int
}//ends the class
