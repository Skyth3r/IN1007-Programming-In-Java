package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    ============================
    *** LEVEL FOUR: NUTSHELL ***
    ============================
 */
public class Level4 extends GameLevel{
    
    // creating the enemy
    private Enemy enemy;
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        {   // Make Game floor
            Shape floor = new BoxShape(15, 0.5f);
            Body ground = new StaticBody(this, floor);
            ground.setPosition(new Vec2(0, -11.5f));
            // Modifiy image to fit ground
            // ground.addImage(new BodyImage("data/platform.png"));  
            
            // Make Game ceiling
            Shape floor2 = new BoxShape(15, 0.5f);
            Body top = new StaticBody(this, floor2);
            top.setPosition(new Vec2(0, 44.5f));
            // Modifiy image to fit ground
            // ground.addImage(new BodyImage("data/platform.png"));  
        }
        
        {
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 28.5f);
            Body leftWall = new StaticBody (this, leftWallShape);
            leftWall.setPosition (new Vec2(-15.5f, 16.5f));
            // Right Wall
            Shape rightWallShape = new BoxShape(0.5f, 28.5f);
            Body rightWall = new StaticBody (this, rightWallShape);
            rightWall.setPosition (new Vec2(15.5f, 16.5f));
        }
        
        {   
            /*
            ==============================
            *** MAKING PLATFORM SHAPES ***
            ==============================
            */ 
                // Default platform shape
                Shape shape1 = new BoxShape(4, 0.5f);
                // Smaller platform shape
                Shape shape2 = new BoxShape(2, 0.5f); 
                // Rectangle platform shape above starting position
                Shape shape3 = new BoxShape(12.5f, 1);
                // Square
                Shape shape4 = new BoxShape(2.5f, 2.5f);
                // Square v2
                Shape shape5 = new BoxShape(4.5f, 3.5f);
                // Vertical platform
                Shape shape6 = new BoxShape(1, 9);
                // Smaller, but wider platform shape
                Shape shape7 = new BoxShape(2, 1); 
            
            // Platform above starting postion
            Body platform1 = new StaticBody(this, shape3);
            platform1.setPosition(new Vec2(-2.5f, -5));
            
            // Square platform platform
            Body platform2 = new StaticBody(this, shape4);
            platform2.setPosition(new Vec2(7.5f, -1.5f));
            
            // Second platform above starting postion
            Body platform3 = new StaticBody(this, shape3);
            platform3.setPosition(new Vec2(2.5f, 8));
            
            // Square v2 platform
            Body platform4 = new StaticBody(this, shape5);
            platform4.setPosition(new Vec2(-5.5f, 3.5f));
            
            // Vertical platform: 1
            Body platform5 = new StaticBody(this, shape6);
            platform5.setPosition(new Vec2(-9, 21));
            
            // Vertical platform: 2
            Body platform6 = new StaticBody(this, shape6);
            platform6.setPosition(new Vec2(1, 21));
            
            // Vertical platform: 3
            Body platform7 = new StaticBody(this, shape6);
            platform7.setPosition(new Vec2(11, 21));
            
            // Small platfomr attached to right wall
            Body platform8 = new StaticBody(this, shape2);
            platform8.setPosition(new Vec2(13, 12.5f));
            
            // Final platform
            Body platform9 = new StaticBody(this, shape7);
            platform9.setPosition(new Vec2(1, 36));
        }
        
        { 
  
            /*
            ======================
            *** MAKE AN ENEMY ***
            ======================
            */
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(0, -10.5f));
            enemy.startWalking(-3);
            enemy.addCollisionListener(new EnemyCollisionLevel2(monkey, game));
            
        }
        
        {   // Adds left hit box for enemy.
            Hitbox leftHitbox = new Hitbox(this);
            leftHitbox.setPosition(new Vec2(-15, -10.7f));
            leftHitbox.addCollisionListener(new HitWallLeft(enemy, leftHitbox));
        }
        
        {   // Adds right hit box for enemy.
            Hitbox rightHitbox = new Hitbox(this);
            rightHitbox.setPosition(new Vec2(15.4f, -10.7f));
            rightHitbox.addCollisionListener(new HitWallRight(enemy, rightHitbox));
        }
        
    }
        
    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(1, 38);
    }
    
    @Override
    public Vec2 blackHolePosition() {
        return new Vec2(0, 100);
    }

    // Don't change this. It works.
    @Override
    public boolean isCompleted() {
        return monkey.trueTrophyCount();
    }
}
