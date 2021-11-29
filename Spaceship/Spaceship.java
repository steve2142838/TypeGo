import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends SmoothMover
{
    private final GifImage bg = new GifImage("space-ship.gif");
    private final double SCALE_FACTOR = .6;
    
    private int frames;
    private String currentKey = "";
    
    
    
    public Spaceship() {
        // scale down imgs
        for (GreenfootImage currentImg : bg.getImages()) {
            int wid = (int)(currentImg.getWidth() * SCALE_FACTOR);
            int hei = (int)(currentImg.getHeight() * SCALE_FACTOR);
            currentImg.scale(wid, hei); 
        }
        setImage(bg.getCurrentImage());
        
        // rotate img
        setRotation(90);
    }
    
    public void act()
    {
        getFrames();
        updateImage();
        
    }
    
    private void getFrames() {
        setFrames(((Jupiter)getWorld()).getFrames());
    }
    
    private void updateImage() {
        
        if (frames % 7 == 0) {
            setImage(bg.getCurrentImage());    
        }
    }
    
    public void setFrames(int frames) {
        this.frames = frames;
    }
    
    
    
}
