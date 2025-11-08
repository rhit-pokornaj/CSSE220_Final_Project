package finalvers1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class GameOverViewer extends JLabel {
    public GameOverViewer() {
        super("GAME OVER");
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 180)); // semi-transparent black background
        setForeground(Color.RED);
        setFont(new Font("Arial", Font.BOLD, 60));
        setVisible(false); // hidden by default
        setAlignmentX(.5f);
        setAlignmentY(.5f);
    }
}