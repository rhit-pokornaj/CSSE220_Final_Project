package finalvers1;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	
	protected int x, y;
	protected int width, height;
	protected BufferedImage sprite;
	protected boolean spriteLoaded = false;
	
	/**
	 * Defines the x, y positions and the width and height of the sprite.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics2D g2);
	/**
	 * getBounds gets the rectangular bounds of the sprite.
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	/**
	 * isTouching checks if bounds of one sprite overlaps with another.
	 * @param other is the other sprite whose bounds need to be checked.
	 * @return boolean value isTouching
	 */
	
	public boolean isTouching(Sprite other) {
		return this.getBounds().intersects(other.getBounds());
	}
	
	// getters and setters
	
	public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    
    public boolean isSpriteLoaded() { return spriteLoaded; }
    public BufferedImage getSprite() { return sprite; } 

}
