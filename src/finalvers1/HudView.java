package finalvers1;

public class HudView extends javax.swing.JLabel {
public HudView() {
setOpaque(false);
setForeground(new java.awt.Color(230,240,255));
setFont(getFont().deriveFont(java.awt.Font.BOLD, 13f));
}
public void refresh(HudModel hud) {
StringBuilder html = new StringBuilder("Score");
html.append("Current: ").append(hud.getScore()).append(""); 
html.append("Lives: ").append(hud.getLifeCount()).append("");
html.append("");
setText(html.toString());
}
}
