import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        rocket rocket = new rocket();
        addObject(rocket,262,263);
        Asteroid asteroid = new Asteroid();
        addObject(asteroid,489,221);
        Asteroid asteroid2 = new Asteroid();
        addObject(asteroid2,445,122);
        Asteroid asteroid3 = new Asteroid();
        addObject(asteroid3,496,316);
        Asteroid asteroid4 = new Asteroid();
        addObject(asteroid4,511,49);
        Counter counter = new Counter();
        addObject(counter,29,22);
        counter.setLocation(30,27);
        Counter counter2 = new Counter();
        addObject(counter2,90,72);
        counter2.setLocation(43,14);
        Counter counter3 = new Counter();
        addObject(counter3,119,123);
        counter3.setLocation(42,22);
        counter.addScore();
        counter.update();
        counter3.addScore();
        counter.setLocation(38,12);
        counter2.update();
        counter3.update();
        counter3.addScore();
        counter3.update();
        counter3.update();
        counter3.addScore();
    }
}
