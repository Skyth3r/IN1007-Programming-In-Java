package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/*
    =================================
    *** LEVEL FIVE: HOLY MOUNTAIN ***
    =================================
 */
public class Level5 extends GameLevel{
    
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
                // Square
                Shape shape3 = new BoxShape(2.5f, 2.5f);
                // Vertical platform
                Shape shape4 = new BoxShape(0.5f, 9);
                // Smaller vertical platform
                Shape shape5 = new BoxShape(0.5f, 4.5f);
                // Small wall
                Shape shape6 = new BoxShape(0.5f, 2.5f);
                // Small roof
                Shape shape7 = new BoxShape(2, 0.5f);
            
            // Square platform
            Body platform1 = new StaticBody(this, shape3);
            platform1.setPosition(new Vec2(7.5f, 5.5f));
            
            // platform attached to right wall
            Body platform2 = new StaticBody(this, shape1);
            platform2.setPosition(new Vec2(11, 12.5f));

            // Vertical platform
            Body platform3 = new StaticBody(this, shape4);
            platform3.setPosition(new Vec2(7.5f, 21));
            
            // Smaller Vertical platform
            Body platform4 = new StaticBody(this, shape5);
            platform4.setPosition(new Vec2(-0.5f, 20.5f));

            // Square platform 2
            Body platform5 = new StaticBody(this, shape3);
            platform5.setPosition(new Vec2(-2.5f, 27.5f));
            
            // Small left wall
            Body platform6 = new StaticBody(this, shape6);
            platform6.setPosition(new Vec2(-4.5f, 32.5f));
            
            // Small roof
            Body platform7 = new StaticBody(this, shape7);
            platform7.setPosition(new Vec2(-2, 34.5f));
            
            // Square platform 3
            Body platform8 = new StaticBody(this, shape3);
            platform8.setPosition(new Vec2(10.5f, 32.5f));
            
            // Final platform
            Body platform10 = new StaticBody(this, shape2);
            platform10.setPosition(new Vec2(13, 35.5f));
        }
        
    }
        
    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, -10);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(14, 37);
    }
    
    @Override
    public Vec2 blackHolePosition() {
        return new Vec2(-2.5f, 31.5f);
    }

    // Don't change this. It works.
    @Override
    public boolean isCompleted() {
        return monkey.trueTrophyCount();
    }
}
