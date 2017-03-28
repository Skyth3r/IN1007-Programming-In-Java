package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the monkey to collect a power flask.
 */
public class PickupFlask implements CollisionListener {
    private Monkey monkey;
    private Game game;
    
    public PickupFlask(Monkey monkey, Game game) {
        this.monkey = monkey;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == monkey) {
            game.incrementFlaskCount();
            e.getReportingBody().destroy();
        }
    }
    
    
}