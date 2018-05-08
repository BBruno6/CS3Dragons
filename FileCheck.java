import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class pulls the dragons from the saved file. 
 *
 * @author Brandon Bruno
 */
public class FileCheck extends MenuHub
{
    private File savedData; 
    private FileWriter writer;
    private Scanner read;
    private Scanner input;
    private String filePath;
    private String output;

    ArrayList<Dragon> dragons = new ArrayList<Dragon>();

    /**
     * Constructor for class FileCheck
     */
    public FileCheck()
    {
        filePath = new String("savedData.txt");
        output = new String("");
        input = new Scanner(System.in);

        try
        {            
            savedData = new File(filePath);
            writer = new FileWriter(filePath, true);
            read = new Scanner(savedData);

            if( !(hasSave()) )
            {
                //savedData.createNewFile();
                NewGame start = new NewGame(dragons);
            }//ends the if
            else
            {
                readData();
                Arena run = new Arena(dragons);
            }//ends the else

        }//ends the try
        catch(IOException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }//ends the catch

    }//ends the constructor

    /**
     * Checks to see if the file exists in the project folder.
     * 
     * @return  true  The file exists.
     * @return  false  The file does not exist.
     */
    private boolean hasSave()
    {
        if(savedData.exists() && !savedData.isDirectory())
        {
            return true;
        }//ends the if
        else
        {
            return false;
        }//ends the else
    }//ends the boolean

    /**
     * After the read file has no more lines, closeFile() will close the file it needs to write to.
     */
    public void closeFile()
    {
        try
        {
            writer.close();
            read.close();
        }//ends the try
        catch(Exception i)
        {
            System.out.println("Error: " + i.getMessage() );
        }//ends the catch
    }//ends the void

    /**
     * Pulls the different dragons from the text file then adds them to
     * the ArrayList dragons. 
     */
    private void readData()
    {
        while(read.hasNext())
        {
            read.next(); //Skips label
            String typeOfDragon = new String(read.nextLine());
            typeOfDragon = typeOfDragon.trim();

            read.next(); //Skips label
            String ownerOfDragon = new String(read.nextLine());
            ownerOfDragon = ownerOfDragon.trim();

            read.next(); //Skips label
            String natureOfDragon = new String(read.nextLine());
            natureOfDragon = natureOfDragon.trim();

            read.next(); //Skips label
            String nameOfDragon = new String(read.nextLine());
            nameOfDragon = nameOfDragon.trim();

            read.next(); //Skips label
            String genderOfDragon = new String(read.nextLine());
            genderOfDragon = genderOfDragon.trim();
            
            read.next(); // Skips label
            String levelOfDragon = new String(read.nextLine());
            levelOfDragon = levelOfDragon.trim();
            Integer convLevel = new Integer(Integer.parseInt(levelOfDragon)); //Integer wrapper
            int level = convLevel.intValue();
            
            read.next(); // Skips label
            String expOfDragon = new String(read.nextLine());
            expOfDragon = expOfDragon.trim();
            Double convExp = new Double(Double.parseDouble(expOfDragon)); //Double wrapper
            double exp = convExp.doubleValue();
            
            if(typeOfDragon.equals("Fire"))
            {
                output = "[Fire] DRAGON FOUND: Adding it to the dragons den...\n";
                System.out.print(output);
                System.out.println("Name: " + nameOfDragon);
                System.out.println("Nature: " + natureOfDragon);
                System.out.println("Owner: " + ownerOfDragon);
                System.out.println("Gender: " + genderOfDragon);
                System.out.println("Level: " + level);
                System.out.println("Exp: " + exp);
                //playText(output);
                dragons.add(new FireDragon(typeOfDragon, ownerOfDragon, natureOfDragon, nameOfDragon, genderOfDragon, level, exp));
                pressEnter();
                //Arena play = new Arena(dragons);
            }//ends the if
            else if(typeOfDragon.equals("Water"))
            {
                output = "[Water] DRAGON FOUND: Adding it to the dragons den...\n";
                System.out.print(output);
                System.out.println("Name: " + nameOfDragon);
                System.out.println("Nature: " + natureOfDragon);
                System.out.println("Owner: " + ownerOfDragon);
                System.out.println("Gender: " + genderOfDragon);
                System.out.println("Level: " + level);
                System.out.println("Exp: " + exp);
                //playText(output);
                dragons.add(new WaterDragon(typeOfDragon, ownerOfDragon, natureOfDragon, nameOfDragon, genderOfDragon, level, exp));
                pressEnter();
                
            }//ends the else if
            else if(typeOfDragon.equals("Earth"))
            {
                output = "[Earth] DRAGON FOUND: Adding it to the dragons den...\n";
                System.out.print(output);
                System.out.println("Name: " + nameOfDragon);
                System.out.println("Nature: " + natureOfDragon);
                System.out.println("Owner: " + ownerOfDragon);
                System.out.println("Gender: " + genderOfDragon);
                System.out.println("Level: " + level);
                System.out.println("Exp: " + exp);
                //playText(output);
                dragons.add(new EarthDragon(typeOfDragon, ownerOfDragon, natureOfDragon, nameOfDragon, genderOfDragon, level, exp));
                pressEnter();
                
            }//ends the else if
            else if(typeOfDragon.equals("Wind"))
            {
                output = "[Wind] DRAGON FOUND: Adding it to the dragons den...\n";
                System.out.print(output);
                System.out.println("Name: " + nameOfDragon);
                System.out.println("Nature: " + natureOfDragon);
                System.out.println("Owner: " + ownerOfDragon);
                System.out.println("Gender: " + genderOfDragon);
                System.out.println("Level: " + level);
                System.out.println("Exp: " + exp);
                //playText(output);
                dragons.add(new WindDragon(typeOfDragon, ownerOfDragon, natureOfDragon, nameOfDragon, genderOfDragon, level, exp));
                pressEnter();
                
            }//ends the else if
            else
            {
                System.out.println("ERROR: Found invalid dragon! Please check your save file!");
            }//ends the else

        }//ends the while
        
        if (dragons.isEmpty())
        {
            System.out.println("NO DRAGONS FOUND IN THE FILE! STARTING A NEW GAME!");
            pressEnter();
            NewGame start = new NewGame(dragons);
        }//ends the if
        
        Arena play = new Arena(dragons);
        this.closeFile();
    }//ends the void

}//ends the class
