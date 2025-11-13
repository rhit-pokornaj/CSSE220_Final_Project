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
    private int currentLevel = 1;

    // Make these fields so you can access them anywhere
    public EntityManager entities;
    public Player goodGuy;
    
    public boolean isDownPressed() { return GamePanel.keysHeld[2]; }

    public GameComponent(HudModel hud, HudView hudView) {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(BG);

        // Initialize the game world
        entities = new EntityManager(hud,hudView);
        goodGuy = entities.goodGuy;
        
        // Level loader
        String levelFile = "C:\\Users\\annusha\\eclipse-workspace\\CSSE220_Final_Project\\src\\finalvers1\\level1.txt";
        LevelLoader.loadPlatforms(levelFile, entities);
       

        // Game loop timer
        timer = new Timer(30, e -> {
        	
            entities.updateAll(isDownPressed());
            
            if (hud.getScore() == 6) {
                nextLevel(hud);
            }
            
            //player wraps around screen when going off edge
            if (goodGuy.getX() < -goodGuy.getWidth()) {
                goodGuy.setPosition(GameComponent.WIDTH, goodGuy.getY());
            } else if (goodGuy.getX() > GameComponent.WIDTH) {
                goodGuy.setPosition(-goodGuy.getWidth(), goodGuy.getY());
            }
            
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
    
   
    private void loadLevel(int levelNumber) {
        entities.clearLevel(); // clear old platforms/enemies/etc.
        String levelFile = "C:\\Users\\annusha\\eclipse-workspace\\CSSE220_Final_Project\\src\\finalvers1\\level" + levelNumber + ".txt";
        LevelLoader.loadPlatforms(levelFile, entities);
        System.out.println("Loaded level " + levelNumber);
    }

    // 🚪 Advance to next level
    private void nextLevel(HudModel hud) {
        currentLevel++;
        hud.setScore(0);
        
        if (currentLevel > 3) {
            System.out.println("🎉 All levels complete!");
            timer.stop();
            // optional: show win screen or restart game
            return;
        }

        // Reset player position (e.g. start at left side)
        goodGuy.setPosition(50, 400);
        loadLevel(currentLevel);
    }
    

    

}