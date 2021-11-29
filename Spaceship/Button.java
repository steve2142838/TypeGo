import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Button extends Actor
{
    private static final double MENU_SCALE_FACTOR = .2;
    private static final int MAX_TRANSPARENCY = 255; 
    
    private boolean isMouseHover = false;
    private boolean isPlayHover = true;
    
    public Button() {
        setImage(scaleDown(getImage()));
    }
    
    public void checkHover() {
        if (Greenfoot.mouseMoved(null)) {
            setIsMouseHover(Greenfoot.mouseMoved(this));
        } 
        
        if (getIsMouseHover()) {
            hoverEffect((int)(MAX_TRANSPARENCY * .8));
            
            if (getIsPlayHover()) {
                Greenfoot.playSound("hover.wav");
                setIsPlayHover(false);
            }
            
        } else {
            hoverEffect(MAX_TRANSPARENCY);
            setIsPlayHover(true);
        }
    }
    
    public void checkClicked(World world) {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("clicked.wav");
            Greenfoot.setWorld(world);
        }
    }
    
    private void hoverEffect(int transparency) {
        GreenfootImage img = getImage();
        img.setTransparency(transparency);
        setImage(img);
    }
    
    public GreenfootImage scaleDown(GreenfootImage img) {
        int wid = (int)(img.getWidth() * MENU_SCALE_FACTOR);
        int hei = (int)(img.getHeight() * MENU_SCALE_FACTOR);
        img.scale(wid, hei);
        
        return img;
    }
    
    public boolean getIsMouseHover() {
        return isMouseHover;
    }
    
    public void setIsMouseHover(boolean isMouseHover) {
        this.isMouseHover = isMouseHover;
    }
    
    
    public boolean getIsPlayHover() {
        return isPlayHover;
    }
    
    public void setIsPlayHover(boolean isPlayHover) {
        this.isPlayHover = isPlayHover;
    }
    
}
