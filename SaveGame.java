import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This saves the ArrayList of dragons into a text document so they can be loaded later. 
 *
 * @author Brandon Bruno
 */
public class SaveGame extends MenuHub
{
    private File savedData; 
    private FileWriter writer;
    private Scanner read;
    private Scanner input;
    private String filePath;
    private String output;

    /**
     * Constructor for class SaveGame
     * 
     * @param  dragons  The ArrayList of dragons
     */
    public SaveGame(ArrayList<Dragon> dragons)
    {
        filePath = new String("savedData.txt");
        output = new String("");
        input = new Scanner(System.in);
        try
        {            
            savedData = new File(filePath);
            writer = new FileWriter(filePath, false);
            read = new Scanner(savedData);

            if(hasSave())
            {
                saveData(dragons);
            }//ends the if
            else
            {
                savedData.createNewFile();
                saveData(dragons);
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
     * Saves the ArrayList of dragons into the text file.
     * 
     * @param  dragons  The ArrayList of dragons
     */
    public void saveData(ArrayList<Dragon> dragons)
    {
        String type = new String("");
        String owner = new String("");
        String nature = new String("");
        String name = new String("");
        String gender = new String("");
        int level = 0;
        double exp = 0;
        
        for(int i = 0; i < dragons.size(); i++)
        {
            type = dragons.get(i).getType();
            owner = dragons.get(i).getOwner();
            nature = dragons.get(i).getNature();
            name = dragons.get(i).getName();
            gender = dragons.get(i).getGender();
            level = dragons.get(i).getLevel();
            exp = dragons.get(i).getExp();
            
            try
            {
                writer.write("typeOfDragon: " + type + "\r\n");
                writer.write("ownerOfDragon: " + owner + "\r\n");
                writer.write("natureOfDragon: " + nature + "\r\n");
                writer.write("nameOfDragon: " + name + "\r\n");
                writer.write("genderOfDragon: " + gender + "\r\n");
                writer.write("levelOfDragon: " + level + "\r\n");
                writer.write("expOfDragon: " + exp + "\r\n");
                writer.write("\r\n");
            }//ends the try
            catch(Exception e)
            {
                System.out.println("ERROR: " + e.getMessage());
            }//ends the catch
        }//ends the for
        
        this.closeFile();
    }//ends the void
}//ends the class
