package game;

import city.cs.engine.*;

/**
 * Listener for collision with a BlackHole.  When the player collides with a BlakcHole,
 * the game is advanced to the next level. 
 */
public class BlackHoleCollision implements CollisionListener {
    private Game game;
    
    public BlackHoleCollision(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Monkey player = game.getPlayer();
        
        if (e.getOtherBody() == player) {
            game.goNextGlitchLevel();
        }
    }
}