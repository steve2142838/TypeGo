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
    private final double DX= 11.5;
    
    private int x;
    private int y;
    
    public Projectile(int x, int y) {
        // scale down img                
        GreenfootImage projectile = getImage();
        int wid = (int)(projectile.getWidth() * SCALE_FACTOR);
        int hei = (int)(projectile.getHeight() * SCALE_FACTOR);
        projectile.scale(wid, hei);
        setImage(projectile);
        
        //turn towards asteroid
        this.x = x;
        this.y = y;
        
        Greenfoot.playSound("projectile.wav");
        
    }
    
    public void act()
    {
        turnTowards(x, y);
        move(DX);
        
        // remove if at end of screen
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        
    }
}
