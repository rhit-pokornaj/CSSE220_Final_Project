package finalvers1;

import java.awt.Graphics2D;

public class Level {
	
	public EntityManager entities = new EntityManager();
	
	
	
	public void drawAll(Graphics2D g) {
        //draw platforms
		for (Platform p : entities.platforms) {
            p.draw(g);
        }
        //draw collectible
        for (Collectible c : entities.blocks) {
            c.draw(g);
        }
        //draw enemies
        for (Enemy e : entities.badGuys) {
            e.draw(g);
        }
        //draw hero
        entities.goodGuy.draw(g);
	}
	

}
