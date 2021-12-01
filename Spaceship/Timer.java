import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private GreenfootImage timer;
    private int seconds = 1;
    
    public Timer(int x, int y) {
        getWorld().showText("Timer: " + seconds + "s", x, y);
    }
    
    
    public void act()
    {
        if (((Jupiter)getWorld()).getFrames() % 60 == 0) {
            getWorld().showText("Timer: " + seconds + "s", getX(), getY());
        }
    }
}
