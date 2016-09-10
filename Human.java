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
    
    int count = 0;
    
    public void act() 
    {
        action();
    }    
    
    public void action()
    {
        int xPose = getX(), yPose = getY();
        //GreenfootSound step = new GreenfootSound("step.mp3");
        if (Greenfoot.isKeyDown("left") && canMove(getX() - 1, getY()))
        {
            xPose = getX() - 1;
            yPose = getY();
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("right") && canMove(getX() + 1, getY()))
        {
            xPose = getX() + 1;
            yPose = getY();
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("down") && canMove(getX(), getY() + 1))
        {
            xPose = getX();
            yPose = getY() + 1;
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("up") && canMove(getX(), getY() - 1))
        {
            xPose = getX();
            yPose = getY() - 1;
            count += 1;
            //step.play();
        }
        else if (Greenfoot.isKeyDown("enter"))
        {
            Actor floor = new Floor();
            World world = getWorld();
            world.addObject(floor, getX(), getY());
            count = 0;
            Actor murder;
            murder = getOneObjectAtOffset(0,0,Murder.class);
            if (murder != null)
            {
                Actor over = new GameOver();
                world.addObject(over, 5, 5);
                world.stopped();
            }
        }
        
        if (count <= 5)
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
