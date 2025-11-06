package finalvers1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player extends Sprite {
	 public static final int WIDTH  = 800;
	 public static final int HEIGHT = 600;
	 public static final float GRAVITY = .98f;
	 public static final float JUMP_FORCE =-15f;
	 
	 private boolean onGround;
	 private float yVelocity;
	 private float xVelocity;
	 
	 private int height, width;
	 
	 
	 /**
	  * The Player class loads in the hero sprite at the given start position.
	  * @param startX is the initial x-coordinate
	  * @param startY is the initial y-coordinate
	  */
	 
	 public Player(int startX,int startY) {
		 super(startX, startY, 30, 50);
		 
		 this.onGround = false;
		 this.yVelocity = 0;
		 this.xVelocity = 0;
		 this.width = 30;
		 this.height = 50;

	        try {
				sprite = ImageIO.read(Player.class.getResource("Runner.png"));
				spriteLoaded = true;
			} catch (IOException  | IllegalArgumentException ex) {
				spriteLoaded = false;
			}
	    
	 }
	 	 public void draw (Graphics2D g2) {
	         if (spriteLoaded) {
	             g2.drawImage(sprite, x, y, width, height, null);
	         } else {
	             g2.setColor(Color.CYAN);
	             g2.fillRect(x, y, width, height);
	         }
	     }

	 	 public int getY() {
	 		 return y;
	 	 }
	 	 
	 	 /**
	 	  * setXVelocity sets the running speed of the player to the given speed.
	 	  * @param speed
	 	  */
		 public void setXVelocity(int speed) {
			 xVelocity = speed;

		 }
		 
		 public void setYVelocity(int speed) {
			 yVelocity = speed;

		 }
		 
		 public void setPosition(int xNew, int yNew) {
			 x=xNew;
			 y=yNew;

		 }	
		 
		 /**
		  * jump allows the player to jump implementing a jump force and gravity.
		  */
		 public void jump() {
			 if(onGround) {
				 yVelocity= JUMP_FORCE;
				 onGround=false;

			 }
		 }
		 
		 public void grounded() { 
			 	onGround = true;
		 }
		 
		 public void inAir() {
			 onGround = false;
		 }
		 
		 /**
		  * update checks if the player is on a platform and if not, makes the player fall.
		  * @param p
		  */
		 
		 @Override
		 public void update() {
			 
			 if(!onGround) {
				 yVelocity+=GRAVITY;
				 y+=yVelocity;
			 }
			 x+=xVelocity;
			 
		 }
		
		 
		 
		 
	 
	

}
