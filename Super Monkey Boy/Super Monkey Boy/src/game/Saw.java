package game;

import city.cs.engine.*;

/**
 *
 * @author Akash
 */

// Creates a
public class Saw extends StaticBody {
    private static final Shape shape = new PolygonShape(0.05f,-1.09f, -0.76f,-0.74f, -1.07f,-0.04f, -0.72f,0.78f, 0.01f,1.08f, 0.77f,0.73f, 1.06f,-0.01f, 0.72f,-0.76f);
    
    private static final BodyImage img = new BodyImage("data/Saw.gif", 3.0f);
    
    public Saw(World world) {
        super(world, shape);
        this.addImage(img);
    }
}