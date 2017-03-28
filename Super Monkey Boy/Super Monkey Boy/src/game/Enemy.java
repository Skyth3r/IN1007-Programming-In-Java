package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// Creates the enemy
public class Enemy extends Walker {
    private static final Shape shape = new PolygonShape(-0.373f,0.502f, 0.375f,0.502f, 0.377f,-0.5f, -0.377f,-0.498f);
    
    private static final BodyImage img = new BodyImage("data/Enemy.png");
    
    public Enemy(World world) {
        super(world, shape);
        this.addImage(img);
    }
}