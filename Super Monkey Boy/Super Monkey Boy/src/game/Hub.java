package game;

import java.awt.Graphics2D;
import city.cs.engine.*;

/**
 * extended view which allows player to see GUI (e.g. score, deaths, special power ups)
 */
public class Hub extends UserView {
    
    private Game game;
        
    public Hub(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
    }
    
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Total Deaths: " + game.getDeathCount(), 10, 20);
        g.drawString("Bananas: "  + game.getBananaCount(), 10, 40);
        g.drawString("Flasks: "  + game.getFlaskCount(), 10, 60);
    }
}
