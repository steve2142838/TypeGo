import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium extends Button
{
    public void act() {
        checkHover();
        checkClicked(new Jupiter(Difficulties.MEDIUM));
    
    }
}
