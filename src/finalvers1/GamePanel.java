package finalvers1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

	/**
	 * Controller class for the game.
	 * Handles user input (buttons + keys) and controls the main Timer loop.
	 */

	public class GamePanel extends JPanel {
		private final HudModel hudModel = new HudModel();
		private final HudView hudView = new HudView();

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
	        
	        setLayout(new BorderLayout());


	        JPanel layered = new JPanel();
	        layered.setLayout(new OverlayLayout(layered));
	        layered.setOpaque(false);


	        layered.add(canvas); // back


	        hudView.setOpaque(false);
	        hudView.setAlignmentX(0f); // left
	        hudView.setAlignmentY(0f); // top
	        hudView.setBorder(javax.swing.BorderFactory.createEmptyBorder(8,8,0,0));
	        layered.add(hudView); // top


	        add(layered, BorderLayout.CENTER);
//	        add(buildControls(), BorderLayout.SOUTH);


	        // initial sync
	        hudModel.setLifeCount(hudModel.getLifeCount());
	        hudView.refresh(hudModel);
	        
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
		                	
		                case KeyEvent.VK_S :
		                    ScoreManager.save(hudModel.getScore(), hudModel.getLifeCount());
		                    // quick feedback (optional)
		                    System.out.println("Saved: score=" + hudModel.getScore() + ", balls=" + hudModel.getLifeCount());
		                break;
		                case KeyEvent.VK_0:
		                		hudModel.addScore(1);
		                		System.out.println("scored!");
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
