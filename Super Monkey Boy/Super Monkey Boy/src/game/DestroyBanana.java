package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the enemy to destroy bananas.
 */
public class DestroyBanana implements CollisionListener {
    
    private Enemy enemy;
    //private Game game;
    
    public DestroyBanana(Enemy enemy) {
        this.enemy = enemy;
        //this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == enemy) {
            e.getReportingBody().destroy();
        }
    }
    
    
}