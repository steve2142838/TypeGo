import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Jupiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jupiter extends World
{   
    private static final int WIDTH = 750;
    private static final int HEIGHT = 450;

    private int frames = 1;
    private int currentLvl = 1;
    private Counter counter;
    private List<String> asteroidsList;
    int asteroidCount = 1;
    public Jupiter(String difficulty)
    {    
        super(WIDTH, HEIGHT, 1); 
        scaleBG();
        prepare();
        
        showText("Difficulty: " + difficulty, 100, 300);
        
        switch (difficulty) {
            case Difficulties.EASY: 
                //playEasyMode();
                break;
            case Difficulties.MEDIUM:
                //playMediumMode();
                break;
            case Difficulties.HARD:
                //playHardMode();
                break;
            default:
                Greenfoot.setWorld(new TitleMenu());
        }
        
    }

    public void act() {
        updateFrames();
        if (asteroidCount<10)
        {
            addAsteroid();
        }
    }
    
    public void addAsteroid()
    {
        addObject(new Asteroid(), 750,Greenfoot.getRandomNumber(450));
    }
    
    private void scaleBG() {
        // scale image
        GreenfootImage bg = getBackground();
        bg.scale(bg.getWidth(), (int)(bg.getHeight() * 1.63));

        //set image
        setBackground(bg);
    }
    
    private void prepare()
    {
        counter = new Counter("Score: ");
        addObject(counter,60, 33);

        Spaceship spaceship = new Spaceship();
        addObject(spaceship,100,HEIGHT / 2);
    }
    
    private void updateFrames() {
        frames++;
    }
    
    public int getRandom(int min, int max) {
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }
    
    public void winner() {
        showText("WINNER", WIDTH / 2, HEIGHT / 2);
        Greenfoot.stop();
    }
    
    public int getFrames() {
        return frames;
    }
    
    public Counter getCounter() {
        return counter;
    }
    
    public List<String> getAsteroidsList() {
        return asteroidsList;
    }
    
    
    public void setAsteroidsList(List<String> asteroidsList) {
        this.asteroidsList = asteroidsList;
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
