package game;

import city.cs.engine.*;

/*
 *
 * @author Akash
 */

// Creates a Flask
public class Flask extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.17f,-0.315f, 0.173f,-0.313f, 0.228f,-0.255f, 0.23f,-0.117f, 0.083f,0.313f, -0.082f,0.313f, -0.227f,-0.115f, -0.228f,-0.255f);
    
    private static final BodyImage img = new BodyImage("data/Pickups/Flask.png");
    
    public Flask(World world) {
        super(world, shape);
        this.addImage(img);
    }
}