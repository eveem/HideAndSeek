import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class murder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Murder extends Actor
{
    /**
     * Act - do whatever the murder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 1, getY());
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 1, getY());
        }
        else if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 1);
        }
        else if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 1);
        }
        Greenfoot.delay(5);
    }
}
