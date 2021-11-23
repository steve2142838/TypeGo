import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends SmoothMover
{
    private static final double SCALE_FACTOR = 1.4;
    private static final double DX = .75;
    
    private String asteroidWord;
    private Label label;

    
    public Asteroid(String asteroidWord) {
        // scale down img
        GreenfootImage asteroid = getImage();
        int wid = (int)(asteroid.getWidth() * SCALE_FACTOR);
        int hei = (int)(asteroid.getHeight() * SCALE_FACTOR);
        asteroid.scale(wid, hei);
        setImage(asteroid);
        
        this.asteroidWord = asteroidWord;
    }
    
    
    public void act()
    {
        move(-DX);
        checkProjectile();
        updateLabels();
    }
    
    private void checkProjectile() {
        if (isTouching(Projectile.class)) {
            //List<String> asteroidsList = ((Jupiter)getWorld()).getAsteroidsList();
            String word = ((Jupiter)getWorld()).asteroidWord;
            int idx = word.indexOf(asteroidWord);
            
            //update word
            asteroidWord = asteroidWord.substring(1);
            ((Jupiter)getWorld()).asteroidWord = asteroidWord;
            removeTouching(Projectile.class);
        }
    }
    
    private void updateLabels() {
        //remove old label
        removeTouching(Label.class);
        
        //update new label location
        Label label = new Label(asteroidWord, 26);
        getWorld().addObject(label, (int)getExactX(), (int)getExactY());
    }
    
    
    
    
    
    
    
    
    
    
    
}
