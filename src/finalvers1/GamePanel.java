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
	private final GameOverViewer over = new GameOverViewer();

	private boolean[] keysHeld = new boolean[] { false, false };

	public GamePanel() {
		setLayout(new BorderLayout(8, 8));
		setBackground(GameComponent.BG);

		JPanel layered = new JPanel();
		layered.setLayout(new OverlayLayout(layered));
		layered.setOpaque(false);

		layered.add(canvas);
		
		over.setAlignmentX(.5f);
		over.setAlignmentY(.5f);
		layered.add(over);
		
		add(layered,BorderLayout.CENTER);

		layered.add(hudView);

		add(hudView, BorderLayout.NORTH);
		
		hudView.refresh(hudModel);
		
		buildKeys();
		
		new Timer(100, e -> checkGameOver()).start();

	}

	private void checkGameOver() {
		if (hudModel.getLifeCount() <= 0) {
			over.setVisible(true);
			canvas.setEnabled(false);
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