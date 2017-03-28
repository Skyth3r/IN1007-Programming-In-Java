package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    ============================
    *** LEVEL THREE: THE GAP ***
    ============================
 */
public class Level3 extends GameLevel{
    
    @Override
    public void populate(Game game) {
        super.populate(game);
        {   // Make Game floor
            //Shape floor = new BoxShape(15, 0.5f);
            //Body ground = new StaticBody(this, floor);
            //ground.setPosition(new Vec2(0, -11.5f));
            // Modifiy image to fit ground
            // ground.addImage(new BodyImage("data/platform.png"));   
        }
        
        {
            // Walls
            // Left Wall
            Shape leftWallShape = new BoxShape(0.5f, 16);
            Body leftWall = new StaticBody (this, leftWallShape);
            leftWall.setPosition (new Vec2(-15.5f, 4));
            // Right Wall
            Shape rightWallShape = new BoxShape(0.5f, 16);
            Body rightWall = new StaticBody (this, rightWallShape);
            rightWall.setPosition (new Vec2(15.5f, 4));
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
            
            // Starting platform
            Body platform1 = new StaticBody(this, shape1);
            platform1.setPosition(new Vec2(-12, -11.5f));
            
            // Hidden platform
            Body platform2 = new StaticBody(this, shape1);
            platform2.setPosition(new Vec2(-19, 20.5f));
            
            // Ending platform
            Body platform3 = new StaticBody(this, shape1);
            platform3.setPosition(new Vec2(12, -11.5f));
        }
        
        {
         /*
            ======================
            *** SPAWNS BANANAS ***
            ======================
            */
            Body banana = new Banana(this);
            banana.setPosition(new Vec2(-20, 21));
            Body banana2 = new Banana(this);
            banana2.setPosition(new Vec2(-18, 21));
            Body banana3 = new Banana(this);
            banana3.setPosition(new Vec2(-16, 21));
            banana.addCollisionListener(new PickupBanana(monkey, game));
            banana2.addCollisionListener(new PickupBanana(monkey, game));
            banana3.addCollisionListener(new PickupBanana(monkey, game));
        }
        
        {
            /*
            ===================================================
            *** ADDS A EXMEPIMENTAL FLASK POWER UP TO LEVEL ***
            ===================================================
            */
            Body flask = new Flask (this);
            flask.setPosition(new Vec2(-22, 21));
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
            saw1.addCollisionListener(new SawCollisionLevel3(monkey, game));
            }
            
            for (int i = 0; i < 8; i++) {
            Body saw2 = new Saw (this);
            saw2.setPosition(new Vec2(i*2-7, -12.5f));
            saw2.addCollisionListener(new SawCollisionLevel3(monkey, game));
            }
        }
        
    }
        
    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(12, -10);
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
