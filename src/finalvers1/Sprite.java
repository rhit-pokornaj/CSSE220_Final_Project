package finalvers1;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	
	protected int x, y;
	protected int width, height;
	protected BufferedImage sprite;
	protected boolean spriteLoaded = false;
	
	
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics2D g2);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public boolean isTouching(Sprite other) {
		return this.getBounds().intersects(other.getBounds());
	}
	
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
