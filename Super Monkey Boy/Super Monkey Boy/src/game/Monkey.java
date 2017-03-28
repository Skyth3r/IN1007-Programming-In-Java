package game;

import city.cs.engine.*;

/**
 * Main char
 */
public class Monkey extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(-0.437f,-0.498f, -0.5f,-0.444f, -0.5f,0.44f, -0.442f,0.5f, 0.458f,0.498f, 0.502f,0.431f, 0.502f,-0.444f, 0.433f,-0.504f);

    private static final BodyImage image = new BodyImage("data/Monkey.png", 1.0f);

    
    
    // Setting item varibles
    // private int count;
    // private int orangeCount;
    // private int bananaCount;
    // private int deathCount;
    // private int flaskCount;
    // private int portalCount;
    // private boolean trueTrophyCount;
    

    public Monkey(World world) {
        // I cant remember what this does but im not deleting it now
        super(world, shape);
        addImage(image);
        // Sets item variables count to 0 (and heartCount to 3)
        // orangeCount = 0;
        // bananaCount = 0;
        // deathCount = 0;
        // flaskCount = 0;
        // portalCount = 0;
        // count = 0;
    }

    /*
    ========================
    *** COUNT MODIFIERS *** 
    ========================
    
    - I don't know what these do
    
    public int getCount() {
        return count;
    }

    public void addOne() {
        count++;
    }
    */
    
    
    /* 
    ========================
    *** ORANGE MODIFIERS *** 
    ========================
    
        // Getting the Orange count
        public int getOrangeCount() {
            return orangeCount;
        }
        // Increasing the orange count
        public void incrementOrangeCount() {
            orangeCount++;
            System.out.println("What? what are you doing with ORANGES? whatever.  Orange count = " + orangeCount);
        }
    */
    
    
    /* 
    ========================
    *** BANANA MODIFIERS *** 
    ========================
    
        // Getting the banana count
        public int getBananaCount() {
            return bananaCount;
        }
        // Increasing the banana count
        public void incrementBananaCount() {
            bananaCount++;
            System.out.println("Tasty!  Banana count = " + bananaCount);
        }
    */
    
    
    /* 
    ========================
    *** DEATH MODIFIERS *** 
    ========================
    
        // Getting the heart count
        public int getDeathCount() {
            return deathCount;
        }
        // Increasing the heart count
        public void increaseDeathCount() {
            deathCount++;
            System.out.println("Ouch! Deaths = " + deathCount);
        }
        // Decreasing the heart count
        public void decreaseDeathCount() {
            deathCount--;
            System.out.println("1UP! Deaths = " + deathCount);
        }
    */
    
    /* 
    ========================
    *** FLASK MODIFIERS *** 
    ========================
    
        // Getting the Flask count
        public int getFlaskCount() {
        return flaskCount;
        }
        // Increasing the Flask count
        public void incrementFlaskCount() {
            flaskCount++;
            System.out.println("Experimental power found! Power Flasks found = " + flaskCount);
        }
    */
    
    
    /* 
    ========================
    *** PORTAL MODIFIERS *** 
    ========================
    
        // Getting the Portal count
        public int getPortalCount() {
            return portalCount;
        }
        // Increasing the banana count
        public void incrementPortalCount() {
            portalCount++;
            System.out.println("YAY! You have completed this level. Number of levels completed = " + portalCount);
            System.out.println("You have collected "+ bananaCount +" banana(s).");
            System.out.println("You have found "+ flaskCount +" Experimental power(s).");
            System.out.println("You have "+ deathCount +" lives left.");
        }
    */
        
        // returns the true value
        public boolean trueTrophyCount() {
            return true;
        }
    
}
