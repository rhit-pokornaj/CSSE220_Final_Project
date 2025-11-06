package finalvers1;

import java.awt.Color;

public class GameOverViewer extends javax.swing.JLabel {
	public GameOverViewer() {
		setOpaque(true);
		setForeground(Color.red);
		setFont(getFont().deriveFont(java.awt.Font.BOLD, 13f));
	}
}