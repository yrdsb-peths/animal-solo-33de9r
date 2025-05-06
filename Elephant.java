import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * The Elephant, our hero.
 * @author (your name) Jiayu
 * @version (a version number or a date) April 28
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idle = new GreenfootImage("images/el_idle/idle0.png");
    
    public Elephant() {
        setImage(idle);
    }
    
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left")) {
            move(-1);
        } else if (Greenfoot.isKeyDown("right")) {
            move(1);
        }
        
        eat();
    }
    
    public void eat() {
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
