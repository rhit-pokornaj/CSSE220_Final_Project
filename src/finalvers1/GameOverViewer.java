package finalvers1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOverViewer extends JLabel {
    public GameOverViewer(HudModel hud) {
    	
        setText("GAME OVER Press 'R' to Restart");
        setOpaque(true);

        setBackground(new Color(0, 0, 0, 180)); 
        setForeground(Color.RED);
        setFont(new Font("Arial", Font.BOLD, 40));
//		setText("Score: "+ hud.getScore());

//        JButton restart = new JButton();
        
//        add(restart);
        
        setVisible(false); // hidden by default
        setAlignmentX(0.5f);
        setAlignmentY(0.0f);
    }
}