package finalvers1;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


public class EntityManager {
	
	public List<Platform> platforms = new ArrayList<>();
	public List<Collectible> blocks = new ArrayList<>();
	public List<Enemy> badGuys = new ArrayList<>();
	Player goodGuy = new Player(150,150);
	
	private HudModel hud;
	
	public EntityManager(HudModel hud) {
		this.hud = hud;
	}
	public void addPlatform(int x, int y, int length) {
		platforms.add(new Platform(x,y,length));
	}
	
	public void addCollectible(int x, int y) {
		blocks.add(new Collectible(x, y, 100));
	}
		
	public void addEnemy(int x, int y) {
		badGuys.add(new Enemy(x,y));
	}
	
	public void handleCollisions() {
		for (Enemy e : badGuys) {
			if (goodGuy.isTouching(e)) {
				System.out.println("dead");
                hud.setLifeCount(hud.getLifeCount() - 1);
			} 
		}
		
		for (Collectible c : blocks) {
			if (goodGuy.isTouching(c)) {
				System.out.println("hooray");
			} 
		}
		
//		for (Platform p: platforms) {
//			if (goodGuy.x + goodGuy.width >= p.getX() && goodGuy.y + goodGuy.height >= p.getY() && goodGuy.x <= p.getX() + 2 && goodGuy.y <= p.getY() + 2) {
//				System.out.println("grounded");
//			}
//		}
	}
	
	public void drawAll(Graphics2D g) {
        //draw platforms
		for (Platform p : platforms) {
            p.draw(g);
        }
        //draw collectible
        for (Collectible c : blocks) {
            c.draw(g);
        }
        //draw enemies
        for (Enemy e : badGuys) {
            e.draw(g);
        }
        //draw hero
        goodGuy.draw(g);
	}
	
	public void updateAll() {
        //update enemies
        for (Enemy e : badGuys) {
            e.update();
        }
        //update hero
        goodGuy.update();
        //deal with all collisions
        handleCollisions();
	}
	
}
