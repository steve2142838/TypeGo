import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard extends Button
{
    public void act() {
        checkHover();
        checkClicked(new Jupiter(Difficulties.HARD));
    
    }
}
