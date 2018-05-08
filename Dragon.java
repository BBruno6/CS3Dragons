/**
 * Abstract class Dragon - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dragon
{
    private String myType;
    private String myOwner;
    private String myNature;
    private String myName;
    private String myGender;
    private int myLevel;
    private double myExp;
    
    /**
     * Default constructor for abstract class Dragon
     */
    public Dragon()
    {
        //This should do nothing if the default constructor is called.
    }//ends the default constructor
    /**
     * Constructor for creating a new dragon.
     * 
     * @param  type  The type of dragon
     * @param  owner  The owner of the dragon
     * @param  nature  The nature of the dragon
     * @param  name  The name of the dragon
     * @param  gender  The sex of the dragon
     * @param  level  The level of the dragon
     * @param  exp  The amount of EXP the dragon has
     */
    public Dragon(String type, String owner, String nature, String name, String gender, int level, double exp)
    {
        myType = type;
        myOwner = owner;
        myNature = nature;
        myName = name;
        myGender = gender;
        myLevel = level;
        myExp = exp;
    }//ends the second constructor
    
    /**
     * The getter and setter for the TYPE of the dragon.
     * 
     * @return  myType  The type of the dragon.
     */
    public String getType()
    {
        return myType;
    }//ends the String
    /**
     * The setter for the TYPE of dragon.
     *
     * @param  type  The type of the dragon.
     */
    public void setType(String type)
    {
        myType = type;
    }//ends the void
    
    /**
     * The getter for the OWNER of the dragon. 
     * 
     * @return  myOwner  The owner of the dragon.
     */
    public String getOwner()
    {
        return myOwner;
    }//ends the String
    /**
     * The setter for the OWNER of the dragon.
     *
     * @param  owner  The owner of the dragon.
     */
    public void setOwner(String owner)
    {
        myOwner = owner;
    }//ends the void
    
    /**
     * The getter for the NATURE of the dragon. 
     * 
     * @return  myNature  The nature of the dragon.
     */
    public String getNature()
    {
        return myNature;
    }//ends the String
    /**
     * The setter for the NATURE of the dragon.
     * 
     * @param  nature  The nature of the dragon.
     */
    public void setNature(String nature)
    {
        myNature = nature;
    }//ends the void
    
    /**
     * The getter for the NAME of the dragon. 
     * 
     * @return  myName  The name of the dragon.
     */
    public String getName()
    {
        return myName;
    }//ends the String
    /**
     * The setter for the NAME of the dragon.
     * 
     * @param  name  The name of the dragon.
     */
    public void setName(String name)
    {
        myName = name;
    }//ends the void
    
    /**
     * The getter for the GENDER of the dragon. 
     * 
     * @return  myGender  The gender of the dragon.
     */
    public String getGender()
    {
        return myGender;
    }//ends the String
    /**
     * The setter for the GENDER of the dragon.
     * 
     * @param  gender  The gender of the dragon.
     */
    public void setGender(String gender)
    {
        myGender = gender;
    }//ends the void
    
    /**
     * The getter and setter for the LEVEL of the dragon. 
     * 
     * @return  myLevel  The level of the dragon.
     */
    public int getLevel()
    {
        return myLevel;
    }//ends the int
    /**
     * The setter for the LEVEL of the dragon.
     * 
     * @param  level  The level of the dragon.
     */
    public void setLevel(int level)
    {
        myLevel = level;
    }//ends the void
    
    /**
     * The getter for the EXP of the dragon. 
     * 
     * @return  myExp  The exp of the dragon.
     */
    public double getExp()
    {
        return myExp;
    }//ends the double
    /**
     * The setter for the EXP of the dragon.
     * 
     * @param  exp  The exp of the dragon.
     */
    public void setExp(double exp)
    {
        myExp = exp;
    }//ends the void
    
    /**
     * Another class will overwrite this method if it extends Dragon.
     */
    public abstract void decideNature();
    
    /**
     * Another class will overwrite this method if it extends Dragon.
     */
    public abstract void decideGender();
}
