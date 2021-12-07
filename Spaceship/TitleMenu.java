import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleMenu extends World
{
    private static final int WIDTH = 750;
    private static final int HEIGHT = 450;

    private static final double SCALE_FACTOR = .4;
    
    private GreenfootSound soundtrack = new GreenfootSound("menu_bg.mp3");
    
    
    public TitleMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 

        //scale down image
        GreenfootImage bg = getBackground();
        int wid = (int)(bg.getWidth() * SCALE_FACTOR);
        int hei = (int)(bg.getHeight() * SCALE_FACTOR);

        bg.scale(wid, hei);
        setBackground(bg);

        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int mid = getWidth() / 2 + 18;

        Title title = new Title();
        addObject(title,mid,95);
        
        Play play = new Play();
        addObject(play, mid, 220);

        Instructions instructions = new Instructions();
        addObject(instructions, mid, 305);

        Credits credits = new Credits();
        addObject(credits, mid, 390);
        
    }
    
    public void started() {
        soundtrack.playLoop();
    }
    
    public void stopped() {
        soundtrack.stop();
    }
}
