package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// The hitbox the enemy collions with to change directions
public class Hitbox extends StaticBody {
    private static final Shape shape = new PolygonShape(0.09f,-0.29f, -0.41f,-0.29f, -0.41f,0.2f, 0.09f,0.2f);
    
    private static final BodyImage img = new BodyImage("data/Square.png");
    
    public Hitbox(World world) {
        super(world, shape);
        this.addImage(img);
    }
}
