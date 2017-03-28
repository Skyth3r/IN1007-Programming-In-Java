package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the enemy to increase deathCount when monkey touches enemy.
 */
public class EnemyCollisionLevel2 implements CollisionListener {
    private Monkey monkey;
    private Game game;
    
    public EnemyCollisionLevel2(Monkey monkey, Game game) {
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