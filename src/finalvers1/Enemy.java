package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Sprite {
	
	public static final int WIDTH  = 800;
	public static final int HEIGHT = 600;
	public static final float GRAVITY = .98f;
	
	private int dx = 3;
    private boolean onGround;
	private float yVelocity;
	
	/**
	 * The Enemy class loads the sprite into the given x and y-positions
	 * @param x is the initial x-position
	 * @param y is the initial y-position
	 */

    public Enemy(int x, int y) {
        super(x, y, 40, 40); // initialize Sprite fields

        try {
            sprite = ImageIO.read(Enemy.class.getResource("Enemy.png"));
            spriteLoaded = (sprite != null);
        } catch (IOException | IllegalArgumentException ex) {
            spriteLoaded = false;
        }
    }

    @Override
    public void update() {
        // move logic can go here (if you call update() from your timer)
        move(GameComponent.WIDTH);
    }

    @Override
    public void draw(Graphics2D g2) {
        if (spriteLoaded) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else {
            g2.setColor(Color.CYAN);
            g2.fillRect(x, y, width, height);
        }
    }
    
    /**
     * The move method updates the enemy's position to make him patrol from left to right.
     * @param screenWidth
     */
    
    public void move(int screenWidth) {
    	x += dx;

    	
    	if (x < 0 || x + width > screenWidth) { dx = -dx; }
    }
	
}
