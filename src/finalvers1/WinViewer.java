package finalvers1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class WinViewer extends JLabel {
	public WinViewer(HudModel hud) {

		setText("YOU WIN!");
		setOpaque(true);

		setBackground(new Color(0, 0, 0, 180));
		setForeground(Color.GREEN);
		setFont(new Font("Arial", Font.BOLD, 120));

		setVisible(false); // hidden by default
		setAlignmentX(.5f);
		setAlignmentY(.5f);
	}
}
