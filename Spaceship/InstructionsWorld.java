import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsWorld extends World
{
    private static final int WIDTH = 750;
    private static final int HEIGHT = 450;
    
    private final double SCALE_FACTOR = .7;
    
    public InstructionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        scaleDownImage();
        
        showText("Instructions", WIDTH / 2, HEIGHT / 2 - 120);
        String instructions = String.format("%s\n", "1- Pick a difficulty");
        instructions += String.format("%s\n", "2- Type the words you see on the asteroids");
        instructions += String.format("%s\n", "3- Try to win by typing all the words");
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
