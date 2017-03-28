package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    ==============================
    *** LEVEL ONE: HELLO WORLD ***
    ==============================
 */
public class Level1 extends GameLevel {
    
    // creating the enemy
    private Enemy enemy;
    private Game game;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);      

        {   
            // Make Game floor
            Shape floor = new BoxShape(7, 0.5f);
            Body ground = new StaticBody(this, floor);
            ground.setPosition(new Vec2(-18, -11.5f));
            // Modifiy image to fit ground
            ground.addImage(new BodyImage("data/Level1/ground.png"));
        }
        
        {
            
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 6);
            Body leftWall = new StaticBody (this, leftWallShape);
            leftWall.setPosition (new Vec2(-24.5f, -5));
            leftWall.addImage(new BodyImage("data/Level1/leftWall.png", 12.0f));
            // Right Wall
            Shape rightWallShape = new BoxShape(1, 6);
            Body rightWall = new StaticBody (this, rightWallShape);
            rightWall.setPosition (new Vec2(25, -0.8f));
            rightWall.addImage(new BodyImage("data/Level1/rightWall.png", 12.0f));
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
                // Large rectangle platform shape
                Shape shape3 = new BoxShape(5.25f, 2);
                // Floating rectangle platform shape
                Shape shape4 = new BoxShape(0.5f, 0.5f); 
                // Floating rectangle platform shape
                Shape shape5 = new BoxShape(0.1f, 0.1f); 
            
            /*
            ============================
            *** SETTING PLATFORMS UP ***
            ============================
            */ 
                // Upper platform (below the platform holding the trophy)
                //Body platform1 = new StaticBody(this, shape1);
                //platform1.setPosition(new Vec2(-7, 5.5f));
                //platform1.addImage(new BodyImage("data/platform-shape.png"));
                
                // First tilted platform on ground
                Body platform1 = new StaticBody(this, shape2);
                platform1.setPosition(new Vec2(-10, -10.5f));
                platform1.rotate(-210);
                platform1.addImage(new BodyImage("data/Level1/platform-shape2-flipped.png", 0.8f));
                // Platform attached to first tilted platform
                Body platform2 = new StaticBody(this, shape1);
                platform2.setPosition(new Vec2(-4.5f, -9.7f));
                platform2.addImage(new BodyImage("data/Level1/platform-shape1.png"));
                // Second tilted platform
                Body platform3 = new StaticBody(this, shape1);
                platform3.setPosition(new Vec2(2, -8));
                platform3.rotate(-210);
                platform3.addImage(new BodyImage("data/Level1/platform-shape1-flipped.png", 0.95f));
                // Platform attached to second tilted platform
                Body platform4 = new StaticBody(this, shape1);
                platform4.setPosition(new Vec2(9.1f, -6.3f));
                platform4.addImage(new BodyImage("data/Level1/platform-shape1.png"));
                // Platform attached to right side of map
                Body platform5 = new StaticBody(this, shape3);
                platform5.setPosition(new Vec2(18.75f, -4.8f));
                platform5.addImage(new BodyImage("data/Level1/platform-rectangle.png", 4.0f));
                // First floating platform
                Body platform6 = new StaticBody(this, shape2);
                platform6.setPosition(new Vec2(8, -0.5f));
                platform6.addImage(new BodyImage("data/Level1/platform-shape2.png", 0.95f));
                // Second floating platform
                Body platform7 = new StaticBody(this, shape1);
                platform7.setPosition(new Vec2(-2, 2.5f));
                platform7.addImage(new BodyImage("data/Level1/platform-shape1.png", 0.95f));
                // Third floating platform
                Body platform8 = new StaticBody(this, shape1);
                platform8.setPosition(new Vec2(-15, 4.5f));
                platform8.addImage(new BodyImage("data/Level1/platform-shape1.png", 0.95f));
                
                // Secret platform
                Body platform9 = new StaticBody(this, shape2);
                platform9.setPosition(new Vec2(45, 4.5f));
                platform9.addImage(new BodyImage("data/Level1/platform-shape2.png", 0.9f));
                
                // Secret platform
                Body Hitboxleft = new StaticBody(this, shape2);
                Hitboxleft.setPosition(new Vec2(450, 45f));
                //platform9.addImage(new BodyImage("data/Level1/platform-shape2.png", 0.9f));
                
        }

        { 
  
            /*
            ======================
            *** MAKE AN ENEMY ***
            ======================
            */
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(16, -2.5f));
            enemy.startWalking(-3);
            enemy.addCollisionListener(new EnemyCollisionLevel1(monkey, game));
            
        }
        
        {
            
            /*
            ======================
            *** SPAWNS BANANAS ***
            ======================
            */
            for (int i = 0; i < 10; i++) {
            Body banana = new Banana(this);
            banana.setPosition(new Vec2(i*2-9, 10));
            banana.addCollisionListener(new PickupBanana(monkey, game));
            banana.addCollisionListener(new DestroyBanana(enemy));
            }
            
        }
        
        {

            /*
            =============================
            *** ADDS A HEART TO LEVEL ***
            =============================
            */
            Body heart = new Heart (this);
            heart.setPosition(new Vec2(-10,-10));
            heart.addCollisionListener(new PickupHeart(monkey, game));
        }
        
        {
            /*
            ===================================================
            *** ADDS A EXMEPIMENTAL FLASK POWER UP TO LEVEL ***
            ===================================================
            */
            Body flask = new Flask (this);
            flask.setPosition(new Vec2(45,5));
            flask.addCollisionListener(new PickupFlask(monkey, game));
        }
        
        {
            /*
            ============================
            *** ADDS ENEMY TO LEVEL ***
            ============================
            */
            // Enemy added as a global varialbe to get the setLinearVelocity to work
            // enemy = new Enemy(this);
            // enemy.setPosition(new Vec2(15,-2.5f));
            // enemy.addCollisionListener(new EnemyCollision(monkey));
            // Sets the Enemy to move to the right
            // enemy.setLinearVelocity(new Vec2(9,6));
            // enemy.startWalking(-6);
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
            saw1.addCollisionListener(new SawCollisionLevel1(monkey, game));
            }
        }
        
        {   // Adds left hit box for enemy.
            Hitbox leftHitbox = new Hitbox(this);
            leftHitbox.setPosition(new Vec2(13.7f, -3));
            leftHitbox.addCollisionListener(new HitWallLeft(enemy, leftHitbox));
        }
        
        {   // Adds right hit box for enemy.
            Hitbox rightHitbox = new Hitbox(this);
            rightHitbox.setPosition(new Vec2(24.4f, -3));
            rightHitbox.addCollisionListener(new HitWallRight(enemy, rightHitbox));
        }
        
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(-22, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(-18,6);
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
