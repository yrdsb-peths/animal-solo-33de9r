import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * Title Screen
 * @author (your name) Jiayu
 * @version (a version number or a date) 05/07/25
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 250, 100);
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,492,82);
        elephant.setLocation(495,86);
        Label label = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label, 220, 257);
        label.setLocation(297, 243);
        label.setLocation(305, 240);
        Label label2 = new Label("Press <space> to Start", 40);
        addObject(label2, 249, 331);
        label2.setLocation(326, 319);
        label.setLocation(328, 253);
        label2.setLocation(295, 326);
        label.setLocation(278, 261);
    }
}
