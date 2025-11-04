package finalvers1;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JComponent;
import javax.swing.Timer;
 
 
 
public class GameComponent extends JComponent {
 
 
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Color BG = Color.BLUE;
	public static final Color FG = Color.BLACK;
	Timer timer;
	
	// Enemy additions
	private final Enemy badGuy = new Enemy(150, 150);
	public Player goodGuy = new Player(250,250);
	public Collectible money = new Collectible(300, 500, 10);
	public final Platform floor = new Platform(0, HEIGHT-10, WIDTH);
	
	public GameComponent() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		//  seed a couple so something is visible immediately
		this.setBackground(BG);
		timer = new Timer(30,e-> {
			goodGuy.update();
			badGuy.update();
			repaint();
		});
		timer.start();
 
	}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			badGuy.draw(g2);
			goodGuy.draw(g2);
			money.draw(g2);
			floor.draw(g2);
	        }
			
		}