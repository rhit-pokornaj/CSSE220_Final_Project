package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Collectible extends Sprite{    
	
	private boolean collected = false;
	private int value;
	
	public Collectible (int x, int y, int value) {
		super(x, y, 30, 30);
		this.value = value;
		
		try {
			sprite = ImageIO.read(Collectible.class.getResource("Money.png"));
			spriteLoaded = (sprite != null);
		} catch (IOException | IllegalArgumentException ex) {
			spriteLoaded = false;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		if (!collected) {
            if (spriteLoaded) {
                g2.drawImage(sprite, x, y, width, height, null);
            } else {
                g2.setColor(Color.YELLOW);
                g2.fillRect(x, y, width, height);
            }
        }
		
	}
	
	public void collect(Player player) {
		if (!collected) {
			collected = true;
			System.out.println("MONMEY!");
		}
	}
	
	public boolean isCollected() {
		return collected;
	}
	
	public int getValue() {
		return value;
	}

}
