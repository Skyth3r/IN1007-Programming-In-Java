package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// Creates a Banana
public class Banana extends DynamicBody {
    private static final Shape shape = new PolygonShape(0.119f,-0.339f, -0.199f,-0.34f, -0.36f,-0.221f, -0.36f,-0.062f, 0.039f,0.34f, 0.197f,0.343f, 0.319f,0.18f, 0.32f,-0.139f);
    
    private static final BodyImage img = new BodyImage("data/Pickups/Banana.png");
    
    public Banana(World world) {
        super(world, shape);
        this.addImage(img);
    }
}
