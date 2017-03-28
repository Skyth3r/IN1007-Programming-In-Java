package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the monkey to collect hearts.
 */
public class PickupHeart implements CollisionListener {
    private Monkey monkey;
    private Game game;
    
    public PickupHeart(Monkey monkey, Game game) {
        this.monkey = monkey;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == monkey) {
            game.decreaseDeathCount();
            e.getReportingBody().destroy();
        }
    }
    
    
}

