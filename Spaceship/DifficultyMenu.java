import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifficultyMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyMenu extends World
{
    private static final int WIDTH = 750;
    private static final int HEIGHT = 450;
 
    private static final double SCALE_FACTOR = .3;
    
    public DifficultyMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        
         //scale down image
        GreenfootImage bg = getBackground();
        int wid = (int)(bg.getWidth() * SCALE_FACTOR);
        int hei = (int)(bg.getHeight() * SCALE_FACTOR);

        bg.scale(wid, hei);
        setBackground(bg);
        
        
        //back button
        addObject(new Back(), 110, 50);
        
        prepare();
    }
    
    private void prepare()
    {
        int mid = getWidth() / 2 + 18;
        
        Easy easy = new Easy();
        addObject(easy, mid, 220);
        
        Medium medium = new Medium();
        addObject(medium, mid, 305);
        
        Hard hard = new Hard();
        addObject(hard, mid, 390);
    }
}
