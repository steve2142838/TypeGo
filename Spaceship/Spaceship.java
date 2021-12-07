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
    private final double SCALE_FACTOR = .7;
    
    private int frames;
    private String currentLetter;
    private boolean isKeyDown = false;
    
    
    
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
        getLatestFrames();
        
        //START game-related-stuff
        checkShooting();
        
        
        //END game-related-stuff
        
        updateImage();
        
    }
    
    private void getLatestFrames() {
        setFrames(((Jupiter)getWorld()).getFrames());
    }
    
    private void checkShooting() {
        List<Asteroid> asteroids = getWorld().getObjects(Asteroid.class);
        if (!asteroids.isEmpty()) {
            Asteroid asteroid = asteroids.get(0);
            
            if (rightLetterTyped(asteroid.getLetter())) {
                if (!isKeyDown) {
                    // shoot projectile
                    Projectile p = new Projectile((int)asteroid.getExactX(), (int)asteroid.getExactY());
                    
                    getWorld().addObject(p, (int)getExactX() + 85, (int)getExactY());    
                    setIsKeyDown(true);
                }
            }
        } 
        
        if (isKeyDown && !Greenfoot.isKeyDown(currentLetter)) {
            setIsKeyDown(false);
        }
        
    }
    
    private boolean rightLetterTyped(String asteroidLetter) {
        for (char c = 'a'; c <= 'z'; c++) {
            String ch = c + "";
            if (Greenfoot.isKeyDown(ch) && ch.equals(asteroidLetter)) {
                setCurrentLetter(asteroidLetter);
                return true;
            }
        }
        
        return false;
    }
    
    private void updateImage() {
        if (frames % 7 == 0) {
            setImage(bg.getCurrentImage());    
        }
    }
    
    // GETTERS SETTERS
    public int getFrames() {
        return frames;
    }
    
    public void setFrames(int frames) {
        this.frames = frames;
    }
    
    public boolean getIsKeyDown() {
        return this.isKeyDown;
    }
    
    public void setIsKeyDown(boolean isKeyDown) {
        this.isKeyDown = isKeyDown;
    }
    
    public void setCurrentLetter(String currentLetter) {
        this.currentLetter = currentLetter;
    }
    
}
