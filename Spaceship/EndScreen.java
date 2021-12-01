import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class EndScreen extends Actor
{
    public EndScreen(String text) {
        GreenfootImage screen = new GreenfootImage(text, 60, Color.WHITE, Color.BLACK);
        
        setImage(screen);
    }
    
}
