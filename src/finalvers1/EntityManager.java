package finalvers1;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


public class EntityManager {
	
	public List<Sprite> sprites = new ArrayList<>();
	Player goodGuy = new Player(150,150);
	
	private HudModel hudModel;
	private HudView hudView;
	
	public EntityManager(HudModel hudModel,HudView hudView) {
		this.hudModel = hudModel;
		this.hudView = hudView;
	}
	public void addPlatform(int x, int y, int length) {
		sprites.add(new Platform(x,y,length));
	}
	
	public void addCollectible(int x, int y) {
		sprites.add(new Collectible (x+50, y+200, 100));
		sprites.add(new Collectible (x+100, y+200, 100));
		sprites.add(new Collectible (x+150, y+200, 100));
		sprites.add(new Collectible (x+200, y+200, 100));
		sprites.add(new Collectible (x+250, y+200, 100));
		sprites.add(new Collectible (x+300, y+200, 100));
	}
		
	public void addEnemy(int x, int y) {
		sprites.add(new Enemy(x,y+200));
	}
	
	public void handleCollisions(boolean downPressed) {
		
		boolean onFloor = false;
		Sprite on = null;
		
		for (Sprite s : sprites) {
			// Enemy collisions
			if (s instanceof Enemy) {
				if (goodGuy.isTouching(s)) {
					goodGuy.setXVelocity(0);
					goodGuy.setYVelocity(0);
					goodGuy.setPosition(250, 250);
					hudModel.loseLife(1);
					hudView.refresh(hudModel);
				}
			}
			
			// Platform Collisions
			if (s instanceof Platform) {
				if (goodGuy.isTouching(s) && goodGuy.getY() < s.getY()) {
					onFloor = true;
					on = s;
				} else if (goodGuy.isTouching(s) && goodGuy.getY() > s.getY()) {
					goodGuy.setYVelocity(0);
					goodGuy.setY(s.getY()+10);
				}
			}
				
			if (!onFloor) {
				goodGuy.inAir();
			} else {
				goodGuy.setY(on.getY()-goodGuy.getHeight()+1);
				goodGuy.grounded();
			}
			
			// Collectible Collisions
			if (s instanceof Collectible) {
				if (!((Collectible) s).isCollected() && goodGuy.isTouching(s) && downPressed) {
					((Collectible) s).collect(goodGuy);
					hudModel.addScore(1);
	                hudView.refresh(hudModel);
				}
			}
			
		}	
		
	}
	

	
	public void drawAll(Graphics2D g) {
        //draw sprites
		for (Sprite s : sprites) {
            s.draw(g);
		}
		// draw Player
        goodGuy.draw(g);
	}
	
	public void updateAll(boolean downPressed) {
        //update sprites
        for (Sprite s : sprites) {
            s.update();
        }
        // update Player
        goodGuy.update();
        // handle all collisions
        handleCollisions(downPressed);
	}
	
}
