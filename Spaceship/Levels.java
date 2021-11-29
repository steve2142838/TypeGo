/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels  
{
    // instance variables - replace the example below with your own
    //private static String[] level1 = {"fell" , "empirical", "damn", "favorable", "functional", "a" , "e", "e", "t"};
    private static String[] level1 = {"functional"};
    private static String[] level2 = {};
    
    /**
     * Constructor for objects of class Levels
     */
    public Levels()
    {
    }

    public static String[] getLevel(int lvl)
    {   
        switch (lvl) {
            case 1: 
                return level1;
            case 2:
                return level2;
            default:
                return level1;
        }
    
    }
}
