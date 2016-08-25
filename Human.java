import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Human extends Actor
{
    /**
     * Act - do whatever the human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move()
    {
        if (Greenfoot.isKeyDown("left") && ((HouseMap) getWorld()).checkLocation(getX() - 1, getY(), 'a'))
        {
            setLocation(getX() - 1, getY());
        }
        else if (Greenfoot.isKeyDown("right") && ((HouseMap) getWorld()).checkLocation(getX() + 1, getY(), 'a'))
        {
            setLocation(getX() + 1, getY());
        }
        else if (Greenfoot.isKeyDown("down") && ((HouseMap) getWorld()).checkLocation(getX(), getY() + 1, 'a'))
        {
            setLocation(getX(), getY() + 1);
        }
        else if (Greenfoot.isKeyDown("up") && ((HouseMap) getWorld()).checkLocation(getX(), getY() - 1, 'a'))
        {
            setLocation(getX(), getY() - 1);
        }
        Greenfoot.delay(4);
    }
}
