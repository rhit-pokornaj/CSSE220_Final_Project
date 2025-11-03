package finalvers1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

	/**
	 * Controller class for the game.
	 * Handles user input (buttons + keys) and controls the main Timer loop.
	 */

	public class GamePanel extends JPanel {
//		private final Player player = new Player(50,50);
		private final GameComponent canvas = new GameComponent();
		// left, right
		private boolean[] keysHeld = new boolean[] {false, false};
	    /**
	     * Constructs the main game panel with controls and keyboard support.
	     */
	    
	    public GamePanel() {
	    	this.setLayout(new BorderLayout(8, 8));
	        this.add(canvas, BorderLayout.CENTER);
	        this.setBackground(canvas.BG);
	        
	    	this.buildKeys();
	    }
	    
	    
	private void buildKeys() {
			
			this.setFocusable(true);
			this.requestFocusInWindow();
			
			
			this.addKeyListener(new KeyAdapter() {
		        @Override
		        public void keyPressed(KeyEvent e) {
		            switch (e.getKeyCode()) {
		                case KeyEvent.VK_LEFT: 
		                	if (!keysHeld[0]) {
		                	canvas.goodGuy.setXVelocity(-10);
		                	keysHeld[0] = true;
		                }
		                	break;
		                	
		                case KeyEvent.VK_RIGHT: 
		                	if (!keysHeld[1]) {
		                	canvas.goodGuy.setXVelocity(10);
		                	keysHeld[1] = true;
		                }
		                	break;
		                	
		                case KeyEvent.VK_UP: 
		                	canvas.goodGuy.jump();
		                	break;
		            }
		        }
		        
		        public void keyReleased(KeyEvent e) {
		            switch (e.getKeyCode()) {
		                case KeyEvent.VK_LEFT: 
		                	if (keysHeld[0]) {
		                	canvas.goodGuy.setXVelocity(0);
		                	keysHeld[0] = false;
		                }
		                	break;
		                	
		                case KeyEvent.VK_RIGHT:
		                	if (keysHeld[1]) {
		                	canvas.goodGuy.setXVelocity(0);
		                	keysHeld[1] = false;
		                	}
		                	break;

		            }
		        }
		    });
			
		}

}
