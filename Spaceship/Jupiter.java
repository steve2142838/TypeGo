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
    
    public String asteroidWord = "functional";
    
    public Jupiter()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        scaleBG();
        prepare();
        
        createAsteroids(asteroidWord);
    }

    public void act() {
        updateFrames();
        //startGame();
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
    
    private void startGame() {
        //if (asteroidsList == null || asteroidsList.size() == 0)
        if (asteroidsList == null) {
            asteroidsList = Arrays.asList(Levels.getLevel(currentLvl++));
            Collections.shuffle(asteroidsList);
            createAsteroids(asteroidsList);
        }
    }
    
    private void createAsteroids(String word) {
            int x = getRandom(WIDTH - 60, WIDTH - 20);
            int y = HEIGHT / 2;
            addObject(new Asteroid(word), x, y);
        
    }
    
    private void createAsteroids(List<String> asteroidsList) {
        for (String asteroidWord : asteroidsList) {
            int x = getRandom(WIDTH - 60, WIDTH - 20);
            //int y = getRandom(40, HEIGHT - 40);
            int y = HEIGHT / 2;
            
            addObject(new Asteroid(asteroidWord), x, y);
        }
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
