package game;

import city.cs.engine.*;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class PickupPortal implements CollisionListener {
    private Game game;
    
    public PickupPortal(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Monkey player = game.getPlayer();
        
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            // System.out.println("Level completed. Going to next level.");
            game.goNextLevel();
        }
    }
}