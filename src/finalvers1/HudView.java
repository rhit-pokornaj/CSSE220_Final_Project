package finalvers1;


public class HudView extends javax.swing.JLabel {
	/**
	 * Hudview class contains the hud display
	 */
	public HudView() {
		setOpaque(false);
		setForeground(new java.awt.Color(230, 240, 255));
		setFont(getFont().deriveFont(java.awt.Font.BOLD, 20));
	}
	
	/**
	 * updates and displays the current score and life count
	 * @param hud
	 */
	public void refresh(HudModel hud) {
		StringBuilder html = new StringBuilder("<html>");
		html.append("Score: ").append(hud.getScore()).append("<br>");
		html.append("Lives: ").append(hud.getLifeCount()).append("<br>");
		html.append("Goal: ").append("6");
		html.append("</html>");
		setText(html.toString());
	}
}
