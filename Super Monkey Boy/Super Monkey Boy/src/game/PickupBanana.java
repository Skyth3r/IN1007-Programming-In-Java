package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the monkey to collect bananas.
 */
public class PickupBanana implements CollisionListener {
    
    private Monkey monkey;
    private Game game;
    
    public PickupBanana(Monkey monkey, Game game) {
        this.monkey = monkey;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == monkey) {
            game.incrementBananaCount();
            e.getReportingBody().destroy();
        }
    }
    
    
}

