package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Collectible class loads a collectible onto the game screen at the
 * given x and y positions. When the Player collects it, it disappears and
 * adds to the player's score.
 */

public class Collectible extends Sprite{    
	
	private boolean collected = false;
	private int value;
	
	/**
	 * The collectible class loads a collectible onto the game screen at the
	 * given x and y positions.
	 * @param x is the x-coordinate it needs to appear at.
	 * @param y is the y-coordinate in needs to appear at.
	 * @param value is the amount it increments the score by.
	 */
	
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
	
	/**
	 * collect checks if the Player collected it and if it has been collected
	 * it updates the collected boolean to true and prints "MONEY!" to the console 
	 * for confirmation.
	 * @param player
	 */
	
	public void collect(Player player) {	
		if (!collected) {
			collected = true;
			System.out.println("MONEY!");
		}
	}
	
	/**
	 * isCollected returns whether the collectible is collected or not.
	 * @return collected
	 */
	
	public boolean isCollected() {
		return collected;
	}

	public int getValue() {
		return value;
	}

}
