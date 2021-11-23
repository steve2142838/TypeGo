import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SmoothMover
{
    private final double SCALE_FACTOR = .35;
    private final double DX= 14.5;
    
    public Projectile() {
        // scale down img
        GreenfootImage projectile = getImage();
        int wid = (int)(projectile.getWidth() * SCALE_FACTOR);
        int hei = (int)(projectile.getHeight() * SCALE_FACTOR);
        projectile.scale(wid, hei);
        setImage(projectile);
        
        Greenfoot.playSound("projectile.wav");
        
    }
    
    public void act()
    {
        move(DX);
    }
}
