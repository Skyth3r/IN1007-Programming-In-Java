package game;

import city.cs.engine.*;

/**
 * Portals allow player to advance to the next level. 
 */
public class Portal extends StaticBody {   
    
    /**
     * Initialise a new trophy.
     * @param world The world.
     */
    public Portal(World world) {
        super(world, new PolygonShape(-0.108f,-1.0f, -0.497f,-0.385f, -0.497f,0.389f, -0.118f,1.0f, 0.108f,1.0f, 0.5f,0.389f, 0.5f,-0.389f, 0.111f,-1.0f));
        
        addImage(new BodyImage("data/Portal.png", 2.0f));
    }
}
