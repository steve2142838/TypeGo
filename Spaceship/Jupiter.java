import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Jupiter here.
 * @author (your name) @version (a version number or a date)
 */
public class Jupiter extends World
{
    private static final int WIDTH = 750;
    private static final int HEIGHT = 450;
    
    private int frames = 1;
    private int currentLvl = 1;
    private String difficulty;
    private int asteroidSpawnRate;
    
    private List<String> asteroids = new ArrayList<>();
    private int asteroidIdx = 0;
    
    private Counter counter, timer;

    /**
     * 
     */
    public Jupiter(String difficulty)
    {
        super(WIDTH, HEIGHT, 1);
        setBG();
        prepare();
        
        this.difficulty = difficulty;
        
        switch (difficulty) {
            case Difficulties.EASY : {
                asteroids = Arrays.asList(Levels.getWords());
                asteroidSpawnRate = 175;
                break;
            }
            case Difficulties.MEDIUM : {
                asteroids = Arrays.asList(Levels.getWords());
                asteroidSpawnRate = 150;
                //asteroids = Arrays.asList(Levels.getMedium());
                break;
            }
            case Difficulties.HARD : {
                asteroidSpawnRate = 120;
                asteroids = Arrays.asList(Levels.getWords());
                //asteroids = Arrays.asList(Levels.getHard());
                break;
            }
            default : {
                Greenfoot.setWorld(new TitleMenu());
            }
        }
        
        Collections.shuffle(asteroids);
    }

    public void act()
    {
        updateFrames();
        play();
        updateTimer();
    }
    
    private void updateTimer() {
        //60 frames / second
        if (frames % 60 == 0) {
            timer.increment();
        }
    }
    
    private void play() {
        addAsteroids();
    }
    
    private void addAsteroids() {
        if (asteroidIdx < asteroids.size()) {
            if (frames % asteroidSpawnRate == 0) {
                int x = getWidth();
                int y = (int)(getRandom(30, getHeight() - 30));
                String asteroidWord = asteroids.get(asteroidIdx++);
                
                Label lbl = new Label(asteroidWord, 27);
                Asteroid asteroid = new Asteroid(asteroidWord, lbl, difficulty);
                lbl.setDX(asteroid.getDX());
                
                addObject(asteroid, x, y);    
                addObject(lbl, x, y);
            }
        } else if (getObjects(Asteroid.class).isEmpty()) {
            displayWinner();
        }
    }

    private void setBG()
    {
        // get a background
        int bgIdx = getRandom(1, 3);
        GreenfootImage bg = new GreenfootImage("jupiter-" + bgIdx + ".jpg");
        
        // scale image
        switch (bgIdx) {
            case 3:
                bg.scale((int)(bg.getWidth() * 1.2), (int)(bg.getHeight() * 1.63));
                break;
            default:
                bg.scale(bg.getWidth(), (int)(bg.getHeight() * 1.63));
        }
        
        
        // set image
        setBackground(bg);
    }

    private void prepare()
    {
        counter = new Counter("Score: ");
        addObject(counter, 60, 33);
        
        Spaceship spaceship =  new  Spaceship();
        addObject(spaceship, 40, HEIGHT / 2);
        
        timer = new Counter("Timer: ");
        addObject(timer, getWidth() - 65, 33);
    }

    private void updateFrames()
    {
        frames = frames + 1;
    }

    public int getRandom(int min, int max)
    {
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }

    public void displayWinner()
    {
        Winner winnerScreen = new Winner();
        addObject(winnerScreen, WIDTH / 2, HEIGHT / 2);
        Greenfoot.stop();
    }
    
    public void displayGameOver()
    {
        GameOver gameOverScreen = new GameOver();
        addObject(gameOverScreen , WIDTH / 2, HEIGHT / 2);
        Greenfoot.stop();
    }
    
    
    public void incrementScore()
    {
        counter.increment();
    }
    
    //GETTERS SETTERS
    public int getFrames()
    {
        return frames;
    }

    public Counter getCounter()
    {
        return counter;
    }

}
