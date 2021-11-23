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
        playGame();
    }
    
    private void getFrames() {
        frames = ((Jupiter)getWorld()).getFrames();
    }
    
    private void updateImage() {
        
        if (frames % 7 == 0) {
            setImage(bg.getCurrentImage());    
        }
    }
    
    private void playGame() {
        //check for keypress
        checkKeys();
        
        
    }
    
    private void checkKeys() {
        String word = ((Jupiter)getWorld()).asteroidWord;
        
        if (word.isEmpty() || word == null) {
          ((Jupiter)getWorld()).winner();  
          return;
        }
        
        if (word.substring(0,1).equals(Greenfoot.getKey())) {
            getWorld().addObject(new Projectile(), (int)getExactX(), (int)getExactY()); 
        }
        
        /*
        for (int i = 0; i < asteroidsList.size(); i++) {
            String word = asteroidsList.get(i);
            if (word.substring(0,1).equals(Greenfoot.getKey())) {
                asteroidsList.add(i, word.substring(1));
                getWorld().addObject(new Projectile(), (int)getExactX(), (int)getExactY());    
            }
        }
        */
       
       
        
    }
    
    
    
    
}
