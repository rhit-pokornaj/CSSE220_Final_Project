package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;

public class Platform {
	private int x;
	private int y;
	private int length;
	private int thickness;
	
	
	public Platform(int x, int y, int length) {
		this.x = x;
		 this.y = y;
		this.length = length;
		this.thickness = 2;
	}
	public void draw (Graphics2D g2) {
		g2.setColor(Color.BLACK);
        g2.fillRect(x, y, length, thickness);
        
    }
}
