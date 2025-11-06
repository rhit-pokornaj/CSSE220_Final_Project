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
		JPanel endScreen = new JPanel();
		layered.setLayout(new OverlayLayout(layered));
		layered.setOpaque(false);
		layered.add(canvas);
		layered.add(hudView);


		hudView.setAlignmentX(0f);
		hudView.setAlignmentY(0f);

		add(layered, BorderLayout.CENTER);

		hudView.refresh(hudModel);
		buildKeys();
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
				case KeyEvent.VK_S:
					ScoreManager.save(hudModel.getScore(), hudModel.getLifeCount());
					System.out.println("Saved: score=" + hudModel.getScore() + ", lives=" + hudModel.getLifeCount());
					break;
				case KeyEvent.VK_0:
					hudModel.addScore(1);
					hudView.refresh(hudModel);
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