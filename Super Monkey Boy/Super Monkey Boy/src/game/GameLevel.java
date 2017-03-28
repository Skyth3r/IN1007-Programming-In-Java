package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    public Monkey monkey;
    
    public Monkey getPlayer() {
        return monkey;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        monkey = new Monkey(this);
        monkey.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PickupPortal(game));
        
        BlackHole blackhole = new BlackHole(this);
        blackhole.setPosition(blackHolePosition());
        blackhole.addCollisionListener(new BlackHoleCollision(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit portal. */
    public abstract Vec2 portalPosition();
    
    /** The position of the door to the 4th dimension levels. */
    public abstract Vec2 blackHolePosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
