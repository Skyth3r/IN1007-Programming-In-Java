package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// Creates a heart
public class Heart extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.003f,-0.374f, -0.25f,-0.124f, -0.249f,0.186f, -0.187f,0.25f, 0.249f,0.25f, 0.313f,0.186f, 0.313f,-0.124f, 0.063f,-0.372f);
    
    private static final BodyImage img = new BodyImage("data/Pickups/Heart.png");
    
    public Heart(World world) {
        super(world, shape);
        this.addImage(img);
    }
}
