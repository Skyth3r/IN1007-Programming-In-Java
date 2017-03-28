package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    ==============================
    *** LEVEL TWO: THE CLIMB ***
    ==============================
 */
public class Level2 extends GameLevel {

    // creating the enemy
    private Enemy enemy;
    
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        {   // Make Game floor
            Shape floor = new BoxShape(15, 0.5f);
            Body ground = new StaticBody(this, floor);
            ground.setPosition(new Vec2(0, -11.5f));
            // Modifiy image to fit ground
            ground.addImage(new BodyImage("data/Level2/ground.png"));   
        }
        
        {
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 8);
            Body leftWall = new StaticBody (this, leftWallShape);
            leftWall.setPosition (new Vec2(-14.5f, -4));
            leftWall.addImage(new BodyImage("data/Level2/leftWall.png", 16.0f));   
            // Right Wall
            Shape rightWallShape = new BoxShape(0.5f, 10);
            Body rightWall = new StaticBody (this, rightWallShape);
            rightWall.setPosition (new Vec2(14.5f, -1));
            rightWall.addImage(new BodyImage("data/Level2/rightWall.png", 20.0f)); 
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
                // Large Square platform shape
                Shape shape3 = new BoxShape(3, 3);
                // Rectangle platform shape
                Shape shape4 = new BoxShape(1, 4);
                // Small square platform shape
                Shape shape5 = new BoxShape(0.5f, 0.5f);
            
            // First platform attached to right wall
            Body platform1 = new StaticBody(this, shape2);
            platform1.setPosition(new Vec2(12, -8.5f));
            // First floating platform
            Body platform2 = new StaticBody(this, shape2);
            platform2.setPosition(new Vec2(5, -5.5f));
            // Second platform attached to right wall
            Body platform3 = new StaticBody(this, shape2);
            platform3.setPosition(new Vec2(12, -2.5f));
            // Vertical wall
            Body platform4 = new StaticBody(this, shape4);
            platform4.setPosition(new Vec2(7, 4));
            // Platform attached to vertical wall
            Body platform5 = new StaticBody(this, shape1);
            platform5.setPosition(new Vec2(2, 7.5f));
            
            // Secret platform
            Body platform6 = new StaticBody(this, shape5);
            platform6.setPosition(new Vec2(-16.5f, -11.5f));
            
            // Sqaure Final platform
            Body platform10 = new StaticBody(this, shape3);
            platform10.setPosition(new Vec2(-12, 7));
        }
        
        { 
  
            /*
            ======================
            *** MAKE AN ENEMY ***
            ======================
            */
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(0, -9.5f));
            enemy.startWalking(-3);
            enemy.addCollisionListener(new EnemyCollisionLevel2(monkey, game));
            
        }
        
        {
         /*
            ======================
            *** SPAWNS BANANAS ***
            ======================
            */
            for (int i = 0; i < 12; i++) {
            Body banana = new Banana(this);
            banana.setPosition(new Vec2(i*2-9, 10));
            banana.addCollisionListener(new PickupBanana(monkey, game));
            banana.addCollisionListener(new DestroyBanana(enemy));
            }
        }
        
        
        {
            /*
            ===================================================
            *** ADDS A EXMEPIMENTAL FLASK POWER UP TO LEVEL ***
            ===================================================
            */
            Body flask = new Flask (this);
            flask.setPosition(new Vec2(-16.5f, -11));
            flask.addCollisionListener(new PickupFlask(monkey, game));
        }

        {
            /*
            ==========================
            *** ADDS SAWS TO LEVEL ***
            ==========================
            */
            
            // Used to prevent player from leaving the map
            for (int i = -60; i < 60; i++) {
            Body saw1 = new Saw (this);
            saw1.setPosition(new Vec2(i*2-9, -16));
            saw1.addCollisionListener(new SawCollisionLevel2(monkey, game));
            }
        }
        
        {   // Adds left hit box for enemy.
            Hitbox leftHitbox = new Hitbox(this);
            leftHitbox.setPosition(new Vec2(-14, -10.7f));
            leftHitbox.addCollisionListener(new HitWallLeft(enemy, leftHitbox));
        }
        
        {   // Adds right hit box for enemy.
            Hitbox rightHitbox = new Hitbox(this);
            rightHitbox.setPosition(new Vec2(14.3f, -10.7f));
            rightHitbox.addCollisionListener(new HitWallRight(enemy, rightHitbox));
        }
        
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(-12, 11);
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
