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
    
    int count = 0;
    
    public void act() 
    {
        action();
        getWorld().addObject(this, getX(), getY());
    }    
    
    public void action()
    {
        World world = getWorld();
        int xPose = getX(), yPose = getY();
        //GreenfootSound step = new GreenfootSound("step.mp3");
        if (Greenfoot.isKeyDown("a") && canMove(getX() - 1, getY()))
        {
            xPose = getX() - 1;
            yPose = getY();
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("d") && canMove(getX() + 1, getY()))
        {
            xPose = getX() + 1;
            yPose = getY();
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("s") && canMove(getX(), getY() + 1))
        {
            xPose = getX();
            yPose = getY() + 1;
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("w") && canMove(getX(), getY() - 1))
        {
            xPose = getX();
            yPose = getY() - 1;
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("space"))
        {
            Actor floor;
            floor = getOneObjectAtOffset(0,0,Floor.class);
            if (floor != null)
            { 
                world.removeObject(floor);
            }
            Actor human;
            human = getOneObjectAtOffset(0,0,Human.class);
            if (human != null)
            {
                Actor over = new GameOver();
                world.addObject(over, 5, 5);
                GreenfootSound end = new GreenfootSound("endSound.mp3");
                end.play();
                Greenfoot.delay(5);
                Greenfoot.stop();
            }
            count = 0;
        }
        if (count <= 6)
        {
            setLocation(xPose, yPose);
        }
        Greenfoot.delay(4);
    }
    
    private boolean canMove (int x, int y)
    {
        if (((HouseMap)getWorld()).checkLocation(x, y, 'a'))
        {
            return true;
        }
        return false;
    }
}
