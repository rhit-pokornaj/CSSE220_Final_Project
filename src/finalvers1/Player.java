package finalvers1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JComponent;


public class Player extends JComponent{
	 public static final int WIDTH  = 800;
	 public static final int HEIGHT = 600;
	 public static final float GRAVITY = .98f;
	 public static final float JUMP_FORCE =-15f;
	 
	 private int x;
	 private int y;
	 private boolean onGround;
	 private float yVelocity;
	 private float xVelocity;
	 private BufferedImage sprite;
	 private boolean spriteLoaded = false;
	 
	 public Player(int startX,int startY) {
		 setPreferredSize(new Dimension(WIDTH,HEIGHT));
		 this.x = startX;
		 this.y = startY;
		 this.onGround = false;
		 this.yVelocity = 0;
		 this.xVelocity = 0;

	        try {
				sprite = ImageIO.read(Player.class.getResource("Runner.png"));
				spriteLoaded = true;
			} catch (IOException | IllegalArgumentException ex) {
				spriteLoaded = false;
			}
	    
	 }
	 	 public void draw (Graphics2D g2) {
	         if (spriteLoaded) {
	             g2.drawImage(sprite, x, y, 30, 50, null);
	         } else {
	             g2.setColor(Color.CYAN);
	             g2.fillRect(x, y, 30, 50);
	         }
	     }

	 	 
		 public void setXVelocity(int speed) {
			 xVelocity = speed;

		 }
		 public void setPosition(int xNew, int yNew) {
			 x=xNew;
			 y=yNew;

		 }
		 
		 public void update() {
			 if(!onGround) {
				 yVelocity+=GRAVITY;
				 y+=yVelocity;
				 
				 if (y>=HEIGHT-50) {
					 y=HEIGHT-50;
					 yVelocity=0;
					 onGround = true;
				 }
			 }
			 x+=xVelocity;

			 
		 }
		 public void jump() {
			 if(onGround) {
				 yVelocity= JUMP_FORCE;
				 onGround=false;

			 }

		 }
		 
		 
		 
	 
	

}
