package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Sprite {
	
	public static final float GRAVITY = .98f;
	private int dx = 3;
	private Platform platform;
	private int startX;
	
	/**
	 * The Enemy class loads in the enemy sprite at the given start position.
	 * 
	 * @param x is the initial x-coordinate
	 * @param y is the initial y-coordinate
	 */
    public Enemy(int x, int y, Platform platform) {
        super(x, y, 40, 40); // initialize Sprite fields

        this.startX = x;
        this.platform = platform;
        
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
        move();
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
   
    public int getStartX() {
    	return startX;
    }
    
    public void move() {
    	x += dx;

    	
    	if (x < platform.getX() || x > platform.getX() + platform.getWidth() - 40) { dx = -dx; }
    }
	
}
