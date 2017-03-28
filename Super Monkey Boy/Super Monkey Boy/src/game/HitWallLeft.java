package game;

import city.cs.engine.*;

// Left Hit box listener
// Causes enemy to change directions when hitting the left hitbox
public class HitWallLeft implements CollisionListener {
    private Enemy enemy;
    private Hitbox hitbox;
    
    public HitWallLeft(Enemy enemy, Hitbox hitboxleft) {
        this.enemy = enemy;
        this.hitbox = hitboxleft;
    }

    // Collision Listener allows event to occur between enemy and object.
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == enemy && this.hitbox.equals(hitbox)) {  
            e.getOtherBody().equals(enemy);
            // Enemy starts moving in opposite direction with a velocity of 3.
            enemy.startWalking(3);
        }
    }
}