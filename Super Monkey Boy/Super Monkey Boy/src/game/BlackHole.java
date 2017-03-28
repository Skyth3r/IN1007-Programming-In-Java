package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// Creates a static blackhole (like a portal but only used in the later levels
public class BlackHole extends StaticBody {
    private static final Shape shape = new PolygonShape(-0.15f,-1.05f, -1.05f,-0.47f, -1.08f,0.44f, -0.06f,0.99f, 1.02f,0.47f, 0.99f,-0.47f);
    
    private static final BodyImage img = new BodyImage("data/Blackhole.gif", 15.0f);
    
    public BlackHole(World world) {
        super(world, shape);
        this.addImage(img);
    }
}