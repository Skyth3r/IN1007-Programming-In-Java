package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    =========================================
    *** GLITCH LEVEL ONE: HALF COMPILED 3 ***
    =========================================
 */
public class GlitchLevel1 extends GameLevel {
    
    // creating the enemy
    private Enemy enemy;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        {   
            // Make Game floor
            //Shape floor = new BoxShape(15, 0.5f);
            //Body ground = new StaticBody(this, floor);
            //ground.setPosition(new Vec2(0, -11.5f));
            // Modifiy image to fit ground
            // ground.addImage(new BodyImage("data/platform.png"));  
        }
        
        {
            
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 6);
            Body leftWall = new StaticBody (this, leftWallShape);
            leftWall.setPosition (new Vec2(-15, 5));
            leftWall.addImage(new BodyImage("data/Level1/leftWall.png", 12.0f));
            // Right Wall
            Shape rightWallShape = new BoxShape(0.5f, 9.5f);
            Body rightWall = new StaticBody (this, rightWallShape);
            rightWall.setPosition (new Vec2(14.5f, 8.5f));
            // rightWall.addImage(new BodyImage("data/Level1/leftWall.png", 12.0f));
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
                // Square
                Shape shape3 = new BoxShape(2.5f, 2.5f);
                // Vertical platform
                Shape shape4 = new BoxShape(0.5f, 4);
                // Small rectangle platform shape
                Shape shape5 = new BoxShape(1.5f, 0.5f);
                // Rectangle platform shape above starting position
                Shape shape6 = new BoxShape(5, 0.5f);
                // Small square platform shape
                Shape shape7 = new BoxShape(0.5f, 0.5f);
            
            /*
            ============================
            *** SETTING PLATFORMS UP ***
            ============================
            */ 
                
                // Starting platform
                Body platform1 = new StaticBody(this, shape2);
                platform1.setPosition(new Vec2(1, 10.5f));
                // platform1.addImage(new BodyImage("data/Level1/platform-shape1.png", 0.8f));
                // Starting platform left wall
                Body platform2 = new StaticBody(this, shape4);
                platform2.setPosition(new Vec2(3.5f, 14));
                // Left ground part
                Body platform3 = new StaticBody(this, shape5);
                platform3.setPosition(new Vec2(-13, -0.5f));
                // Right ground part
                Body platform4 = new StaticBody(this, shape1);
                platform4.setPosition(new Vec2(10, -0.5f));
                // Ceiling
                Body platform5 = new StaticBody(this, shape6);
                platform5.setPosition(new Vec2(9, 17.5f));
                // Sqaure to the right
                Body platform6 = new StaticBody(this, shape3);
                platform6.setPosition(new Vec2(-13, 13.5f));
                // Sqaure platform to the right of th left wall
                Body platform7 = new StaticBody(this, shape7);
                platform7.setPosition(new Vec2(-16f, -0.5f));
                // Small platform with flask on it
                Body platform8 = new StaticBody(this, shape2);
                platform8.setPosition(new Vec2(-35, -0.5f));
                
                // Final platform
                Body platform10 = new StaticBody(this, shape2);
                platform10.setPosition(new Vec2(6, 10.5f));
        }

        //{ 
            
            // THIS CODE IS NO LONGER NEEDED AND HAS BEEN REPLACED 
            
            /*
            =======================
            *** MAKE A CHARCTER ***
            =======================
            */
            //monkey = new Monkey(this);
            //monkey.setPosition(new Vec2(8, -10));
        //}
        
        //{
            // THIS CODE IS NO LONGER NEEDED AND HAS BEEN REPLACED 
            
            /*
            ==============================
            *** ADDS A TROPHY TO LEVEL ***
            ==============================
            */
            //Body trophy = new Trophy (this);
            //trophy.setPosition(new Vec2(-10.5f,10));
            //trophy.addCollisionListener(new PickupTrophy(monkey));
        //}
        
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
            saw1.setPosition(new Vec2(i*2-9, -2));
            saw1.addCollisionListener(new SawCollisionGlitchLevel1(monkey, game));
            }
        }
        
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(1, 11);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(0, 100);
    }
    
    @Override
    public Vec2 blackHolePosition() {
        return new Vec2(5.5f, 12.5f);
    }

    // Don't change this. It works.
    @Override
    public boolean isCompleted() {
        return monkey.trueTrophyCount();
    }
}

