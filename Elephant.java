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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant() {
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        setImage(idleRight[0]);
        
        for (int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        setImage(idleLeft[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant() {
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark(); 
        
        if (facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left")) {
            move(-1);
            facing = "left";
        } else if (Greenfoot.isKeyDown("right")) {
            move(1);
            facing = "right";
        }
        
        eat();
        
        animateElephant();
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
