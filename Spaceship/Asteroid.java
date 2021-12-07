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
    private static final double SCALE_FACTOR = 1.2;
    private static double DX;
    
    private String asteroidWord;
    private Label lbl;

    
    public Asteroid(String asteroidWord, Label lbl, String difficulty) {
        scaleDownImage();
        this.asteroidWord = asteroidWord;
        this.lbl = lbl;
        
        setAsteroidSpeed(difficulty);
    }
    
    
    public void act()
    {
        move(-DX);
        
        // if touching beginning, you lose
        if (getExactX() <= 0) {
            ((Jupiter)getWorld()).displayGameOver();
        }
        
        //if word is empty, remove asteroid
        if (getAsteroidWord() == null || getAsteroidWord().isEmpty()) {
            Jupiter world = (Jupiter)getWorld();
            world.removeObject(lbl);
            world.removeObject(this);
            world.incrementScore();
            return;
        }
            
        //if projectile is touching asteroid, update text 
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null) { 
            setAsteroidWord(getAsteroidWord().substring(1));    
            lbl.setValue(getAsteroidWord());
            getWorld().removeObject(projectile);
        }
        
    }
    
    private void setAsteroidSpeed(String difficulty) {
        switch (difficulty) {
            case Difficulties.EASY : {
                this.DX = .65;
                break;
            }
            case Difficulties.MEDIUM : {
                this.DX = 1.25;
                break;
            }
            case Difficulties.HARD : {
                this.DX = 1.75;
                break;
            }
            default : {
                this.DX = .65;
            }
        }
        
    }
    
    private void scaleDownImage() {
        GreenfootImage asteroid = getImage();
        int wid = (int)(asteroid.getWidth() * SCALE_FACTOR);
        int hei = (int)(asteroid.getHeight() * SCALE_FACTOR);
        asteroid.scale(wid, hei);
        setImage(asteroid);
    }
    
    //GETTERS SETTERS
    public double getDX() {
        return DX;
    }
    
    private String getAsteroidWord() {
        return asteroidWord;
    }
    
    public String getLetter() {
        return asteroidWord == null || asteroidWord.isEmpty() ? "123" : asteroidWord.charAt(0) + "";
    }
    
    public void setAsteroidWord(String asteroidWord) {
        this.asteroidWord = asteroidWord;
    }
    
    
    
    
    
    
    
}
