package finalvers1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

/**
 * Controller class for the game. Handles user input (buttons + keys) and
 * controls the main Timer loop.
 */

public class GamePanel extends JPanel {

	private final HudModel hudModel = new HudModel();
	private final HudView hudView = new HudView();
	private final GameComponent canvas = new GameComponent(hudModel, hudView);
	private final GameOverViewer over = new GameOverViewer(hudModel);
	private final WinViewer win = new WinViewer();


	private boolean[] keysHeld = new boolean[] { false, false };
	
	private boolean play = true;

	public GamePanel() {
		setBackground(GameComponent.BG);
		
		setLayout(new BorderLayout());
		JPanel layered = new JPanel();
		layered.setLayout(new OverlayLayout(layered));
		layered.setOpaque(false);

		layered.add(canvas);
		layered.add(hudView);  // overlays the game
		layered.add(over);
		layered.add(win);
		
		add(layered, BorderLayout.CENTER);
		add(hudView, BorderLayout.NORTH);
		
		hudView.refresh(hudModel);
		
		buildKeys();
		
		new Timer(100, e -> checkGameStatus()).start();

	}

	private void checkGameStatus() {
		if (hudModel.getLifeCount() <= 0) {
			over.setVisible(true);
			play = false;
		}else if(hudModel.getScore()>=6) {
			win.setVisible(true);
			play = false;
		}
	}

	private void buildKeys() {
		setFocusable(true);
		requestFocusInWindow();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!keysHeld[0]&&play) {
						canvas.goodGuy.setXVelocity(-10);
						keysHeld[0] = true;
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!keysHeld[1]&&play) {
						canvas.goodGuy.setXVelocity(10);
						keysHeld[1] = true;
					}
					break;
				case KeyEvent.VK_UP:
					if (play) {
						canvas.goodGuy.jump();
					}
					break;
				case KeyEvent.VK_0:
					hudModel.addScore(1);
					break;
				}
			}

			@Override
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