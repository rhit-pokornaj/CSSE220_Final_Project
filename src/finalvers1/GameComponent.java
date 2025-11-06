package finalvers1;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JComponent;
import javax.swing.Timer;
 
 
 
public class GameComponent extends JComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Color BG = Color.BLUE;
    public static final Color FG = Color.BLACK;

    private Timer timer;

    // Make these fields so you can access them anywhere
    public EntityManager entities;
    public Player goodGuy;

    public GameComponent(HudModel hud, HudView hudView) {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(BG);

        // Initialize the game world
        entities = new EntityManager(hud,hudView);
        goodGuy = entities.goodGuy;

        // Add some objects
        entities.addPlatform(0, 590, 800);
        entities.addPlatform(300, 520, 400);
        entities.addCollectible(250, 250);
        entities.addEnemy(150, 150);

        // Game loop timer
        timer = new Timer(30, e -> {
            entities.updateAll();
            
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        entities.drawAll(g2);
    }
}