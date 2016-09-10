import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HouseMap extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public int[] xWall = {1,1,3,4,6,7,7,9,9,9,7,6,5,5,0,1,1,3,3,0,1,2,2,4,5,6,6,6,7,8,9,8,9,1};
    public int[] yWall = {0,1,0,1,0,0,1,2,3,4,3,3,3,4,3,3,4,3,5,6,6,7,8,7,9,9,8,6,9,7,7,5,8,8};
    public int xMurder, yMurder;
    
    public HouseMap()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 10, 50);
        setBackground("cell.jpg");
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        generateWall();
        generateFloor();
        generatePlayers();
        GreenfootSound bgEffect = new GreenfootSound("bgSound.mp3");
        bgEffect.play();
    }
    
    private void generatePlayers()
    {
        setPlayerPosition('m');
        setPlayerPosition('h');
    }
    
    private void setPlayerPosition(char command)
    {
        int xPlayer, yPlayer;
        do
        {
            xPlayer = Greenfoot.getRandomNumber(getWidth());
            yPlayer = Greenfoot.getRandomNumber(getHeight());
        }
        while (!checkLocation(xPlayer, yPlayer,command));
        
        if (command == 'm')
        {
            Murder murder = new Murder();
            xMurder = xPlayer;
            yMurder = yPlayer;
            addObject(murder, xPlayer, yPlayer);
        }
        else if (command == 'h')
        {
            Human human = new Human();
            addObject(human, xPlayer, yPlayer);
        }
    }
    
    public boolean checkLocation(int x,int y,char player)
    {
        for (int i = 0; i < 34; i++)
        {
            if (player == 'h' && x == xMurder && y == yMurder)
            {
                return false;
            }
            if (x == xWall[i] && y == yWall[i])
            {    
                return false;
            }
        }
        return true;
    }
    
    private void generateFloor()
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (checkLocation(i, j, 'f'))
                {
                   Floor floor = new Floor();
                   addObject(floor, i, j);
                }
            }
        }
    }
    
    private void generateWall()
    {
        for (int i = 0; i < 34; i++)
        {
            Wall wall = new Wall();
            addObject(wall,xWall[i],yWall[i]);
        }
    }
}
