package finalvers1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class WinViewer extends JLabel {
	
	 // The winViewer class contains the screen that shows when a user wins
	public WinViewer() {

		setText("YOU WIN! Press 'R' to Restart");
		setOpaque(true);

		setBackground(new Color(0, 0, 0, 180));
		setForeground(Color.GREEN);
		setFont(new Font("Arial", Font.BOLD, 60));

		setVisible(false); // hidden by default
		setAlignmentX(.5f);
		setAlignmentY(.5f);
	}
}
