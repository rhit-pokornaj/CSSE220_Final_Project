package finalvers1;

import javax.swing.JFrame;

/**
 * Top-level application window for the game.
 * <p>
 * This class sets up the main {@link JFrame} that contains the {@link GamePanel}.
 * The {@link #show()} method should be called from {@link Main}
 * to make the window visible.
 * </p>
 * 
 * <h2>Responsibilities:</h2>
 * <ul>
 *   <li>Create the main application frame</li>
 *   <li>Attach the {@link GamePanel} as the content area</li>
 *   <li>Configure window title, size, and close behavior</li>
 *   <li>Expose a {@code show()} method to display the frame</li>
 * </ul>
 * 
 * */


public class GameApp {
	private final JFrame frame = new JFrame("Gaming");
	private final GamePanel panel = new GamePanel();
	
	/**
     * Constructs the main game window and attaches the {@link GamePanel}.
     * The window is configured but not made visible yet.
     */
	public GameApp() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();                  // Fit to preferred component sizes
        frame.setLocationRelativeTo(null); // Center on screen
		
	}

	/**
     * Displays the game window on screen.
     */
	public void show() {
		frame.setVisible(true);
	}

}

