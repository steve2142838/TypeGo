import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsWorld extends World
{
private static final int WIDTH = 750;
    private static final int HEIGHT = 450;
    
    private final double SCALE_FACTOR = .25;
    
    public CreditsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        scaleDownImage();
        
        showText("Credits", WIDTH / 2, HEIGHT / 2 - 120);
        String instructions = String.format("%s\n", "Steve Nguyen");
        instructions += String.format("%s\n", "Hussain Amin");
        instructions += String.format("%s\n", "sypro goumas");
        showText(instructions, WIDTH / 2, HEIGHT / 2 + 40);
        
        //back button
        addObject(new Back(), 110, 50);
    }
    
    private void scaleDownImage() {
        GreenfootImage bg = getBackground();
        int wid = (int)(bg.getWidth() * SCALE_FACTOR);
        int hei = (int)(bg.getHeight() * SCALE_FACTOR);
        bg.scale(wid, hei);
        
        setBackground(bg);
    }
}
