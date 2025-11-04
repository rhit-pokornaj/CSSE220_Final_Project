package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Platform class makes the ground or the walls that the enemy and player can
 * collide with. It has a predefined start position and length.
 */

public class Platform extends Sprite{
	
	public Platform(int x, int y, int length) {
		//need to add img file as a param so we can have different platforms
		super(x, y, 800, 10);
		
		try {
			
			sprite = ImageIO.read(Platform.class.getResource("Platform.png"));
			spriteLoaded = (sprite != null);
		} catch (IOException | IllegalArgumentException ex) {
			spriteLoaded = false;
		}
	}
	
	@Override
	public void draw (Graphics2D g2) {
		
		if (spriteLoaded) {
			g2.drawImage(sprite, x, y, 800, 10, null);
		} else {
			g2.setColor(Color.BLACK);
	        g2.fillRect(x, y, 800, 10);			
		}
        
    }
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
