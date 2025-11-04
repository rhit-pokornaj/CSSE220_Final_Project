package finalvers1;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	
	public List<Platform> platforms = new ArrayList<>();
	public List<Collectible> blocks = new ArrayList<>();
	public List<Enemy> badGuys = new ArrayList<>();
	public Player goodGuy = new Player(250,250);
	
	public void addPlatform(int x, int y, int length) {
		platforms.add(new Platform(x,y,length));
	}
	
	public void addCollectible(int x, int y) {
		blocks.add(new Collectible(x, y, 100));
	}
		
	public void addEnemy(int x, int y) {
		badGuys.add(new Enemy(x,y));
	}
	
	
	

}
