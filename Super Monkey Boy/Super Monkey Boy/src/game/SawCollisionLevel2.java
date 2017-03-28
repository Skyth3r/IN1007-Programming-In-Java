package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener for saws in level 3.
 */
public class SawCollisionLevel2 implements CollisionListener {
    private Monkey monkey;
    private Game game;
    
    // Makes monkey from current 'this' session equal to monkey within this class
    public SawCollisionLevel2(Monkey monkey, Game game) {
        this.monkey = monkey;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == monkey) {
            game.increaseDeathCount();
            monkey.setPosition(new Vec2(-10, -10));
        }
    }
}