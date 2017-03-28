package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
// These three neeeded for sound to work in the game
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*

PLEASE NOTE THE DOCUMNETATION HAS BEEN IMPORTED TO A TEXT FILE CALLED 'READ ME'

*/
public class Game {
    
    // Variables
    private int count;
    private int bananaCount;
    private int deathCount;
    private int flaskCount;
    private int portalCount;
    // Background Sound Music Variable
    private SoundClip gameMusic;

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    
    private int level;
    private int glitchLevel;
    
    
    boolean pause = false;
    private JFrame frame;
    
    public static final Color skyColour = new Color(225, 240, 255);
    
    private Controller controller;
        
    
    
    
    
    /** Initialise a new Game. */
    public Game() {
        
        // Variables
        // Setting item varibles
        count = 0;
        bananaCount = 0;
        deathCount = 0;
        flaskCount = 0;
        portalCount = 0;
        
        
        
        
        System.out.println("Level 1: Hello World");
        // Set Level counter to 1 (for level 1)
        level = 1;
        // Sets Glitch Level counter to 0 (as you start on level 1 not glitch level 1)
        glitchLevel = 0;
        // Change this back to Level1 when finsihed testing
        world = new Level1();
        world.populate(this);
        
        // Looping background music
        try {
                gameMusic = new SoundClip("data/Music/A_Night_Of_Dizzy_Spells.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } 
        catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
            }  

        // Old view
        // view = new UserView(world, 1000, 500);
        // Make a view
        view = new Hub(world, this, 1000, 500);
        // Sets background colour
        view.setBackground(skyColour);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Super Monkey Boy");
        // Trying to figure out full screen mode
        // frame.setSize(1650,1080);
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // frame.setVisible(true);
        

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        
        SettingsPanel settingsPanel = new SettingsPanel(this);
        frame.add(settingsPanel, BorderLayout.NORTH);
        // frame.requestFocusInWindow();
        
        // DOES let the game window be resized
        frame.setResizable(true);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        Container button = new SettingsPanel(this);

        // uncomment to make the view track the monkey
        world.addStepListener(new Tracker(view, world.getPlayer()));
        
        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 800, 800);

        
        // start!
        world.start();
    }
    
    // Code needed to pause and resume the game
    public void pause() {
       
        frame = new JFrame("Super Monkey Boy");
        frame.requestFocusInWindow();
        if(pause == false){
        world.stop();
        pause = true;
        } else {
        pause = false;
        world.start();
        }
         frame.requestFocusInWindow();
    }
    
    /*
    ========================
    *** COUNT MODIFIERS *** 
    ========================
    
    - I don't know what these do
    */
    
    public int getCount() {
        return count;
    }

    public void addOne() {
        count++;
    }
    
    /* 
    ========================
    *** BANANA MODIFIERS *** 
    ========================
    */
        // Getting the banana count
        public int getBananaCount() {
            return bananaCount;
        }
        // Increasing the banana count
        public void incrementBananaCount() {
            bananaCount++;
            System.out.println("Tasty!  Banana count = " + bananaCount);
        }
        
    /* 
    ========================
    *** DEATH MODIFIERS *** 
    ========================
    */
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
        
    /* 
    ========================
    *** FLASK MODIFIERS *** 
    ========================
    */
        // Getting the Flask count
        public int getFlaskCount() {
        return flaskCount;
        }
        // Increasing the Flask count
        public void incrementFlaskCount() {
            flaskCount++;
            System.out.println("Experimental power found! Power Flasks found = " + flaskCount);
        }

    /* 
    ========================
    *** PORTAL MODIFIERS *** 
    ========================
    */
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
    

    
    /** The player in the current level. */
    public Monkey getPlayer() {
        return world.getPlayer();
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    // public pauseFalse{
       //  return world.pauseFalse();
    // }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        level++;
        world.stop();
        
        // Starts Level 2
        if (level == 2) {
            // level++;
            System.out.println("Level 2: The Climb");
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        } 
        
        // Starts Level 3
        if (level == 3) {
            // level++;
            System.out.println("Level 3: The Gap");
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        }
        
        // Starts Level 4
        if (level == 4) {
            // level++;
            System.out.println("Level 4: Nutshell");
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        }
        
        // Starts Level 4
        if (level == 5) {
            // level++;
            System.out.println("Level 5: Holy Mountain");
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;
            // get a new world
            world = new Level5();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        }
        
        // Ends game after final level
        if (level == 6) {
            System.out.println("GAME COMPLETED");
            System.exit(0);
        } 
    }
    
    public void goNextGlitchLevel() {
        glitchLevel++;
        world.stop();
        
        // Start Glitch Level 1
        if (glitchLevel == 1) {
            System.out.println("ERROR ENTERING NULL DIMENSION. Level 1: Half Compiled 3");
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;            
            // level++;
            // get a new world
            world = new GlitchLevel1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        }
        
        // End of glitch levels
        if (glitchLevel == 2) {
            System.out.println("Glitch Level(s) Completed.");
            // Go back to Level 5
            bananaCount = 0;
            deathCount = 0;
            flaskCount = 0;
            // get a new world
            world = new Level5();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // uncomment to make the view track the monkey
            world.addStepListener(new Tracker(view, world.getPlayer()));

            world.start();
        }
    }
    
    
    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
