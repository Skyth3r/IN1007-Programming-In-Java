package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    // Jumping speed can now be changed (needed to have sprint jumping to work)
    private static float JUMPING_SPEED = 8;
    // Walking speed can now be changed (needed to have sprint to work)
    private static float WALKING_SPEED = 4;
    
    private Walker body;

    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(- WALKING_SPEED); // A = walk left
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // D = walk right
        // Added the ability to sprint
        }else if (code == KeyEvent.VK_SHIFT) {
            WALKING_SPEED = 8; // Shift = Sprint
            JUMPING_SPEED = 12; // Shift = Sprint Jumping
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        // Stops character form sprinting
        } else if (code == KeyEvent.VK_SHIFT) {
            WALKING_SPEED = 4;
            JUMPING_SPEED = 8;
        }    
    }
    
    public void setBody(Walker body) {
        this.body = body;
    }
}
