package game;

import city.cs.engine.*;

// Right Hit box listener
// Causes enemy to change directions when hitting the right hitbox
public class HitWallRight implements CollisionListener {
    private Enemy enemy;
    private Hitbox hitbox;
    
    public HitWallRight(Enemy enemy, Hitbox hitboxright) {
        this.enemy = enemy;
        this.hitbox = hitboxright;
    }

    // Collision Listener allows event to occur between enemy and object.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == enemy && this.hitbox.equals(hitbox)) {  
            e.getOtherBody().equals(enemy);
            // Enemy starts moving in opposite direction with a velocity of 3.
            enemy.startWalking(-3);
        }
    }
}