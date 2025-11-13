package finalvers1;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;
 
 
public class GameComponent extends JComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Color BG = Color.BLUE;
    public static final Color FG = Color.BLACK;
    private Image BGImg;
    private boolean imgLoaded = false;
    

    Timer timer;
    private int currentLevel = 1;

    // Make these fields so you can access them anywhere
    public EntityManager entities;
    public Player goodGuy;
    
    public boolean isDownPressed() { return GamePanel.keysHeld[2]; }

    public GameComponent(HudModel hud, HudView hudView) {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        try {
			BGImg = ImageIO.read(Player.class.getResource("SimpleBG.png"));
			imgLoaded = true;
		} catch (IOException | IllegalArgumentException ex) {
			imgLoaded = false;
		}
        this.setBackground(BG);

        // Initialize the game world
        entities = new EntityManager(hud,hudView);
        goodGuy = entities.goodGuy;
        
        // Level loader
        String levelFile = String.format("src/finalvers1/level%d.txt", 1);
        LevelLoader.loadPlatforms(levelFile, entities);
       

        // Game loop timer
        timer = new Timer(30, e -> {
        	
            entities.updateAll(isDownPressed());
            
            if (hud.getScore() == 6) {
                nextLevel(hud,hudView);
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
        if (imgLoaded) {
            g2.drawImage(BGImg, 0, 0, WIDTH, HEIGHT, null);
        } else {
            g2.setColor(Color.BLUE);
            g2.fillRect(0, 0, WIDTH, HEIGHT);
        }
        entities.drawAll(g2);
    }
    
   
    public void loadLevel(int levelNumber) {
        entities.clearLevel(); // clear old platforms/enemies/etc.
        String levelFile = String.format("src/finalvers1/level%d.txt", levelNumber);
        LevelLoader.loadPlatforms(levelFile, entities);
        System.out.println("Loaded level " + levelNumber);
    }

    // 🚪 Advance to next level
    private void nextLevel(HudModel hud, HudView hudV) {
        currentLevel++;
        
        if (currentLevel <= 3) {
        	hud.setScore(0);
        }
        
        if (currentLevel > 3) {
            System.out.println("🎉 All levels complete!");
            timer.stop();
            // optional: show win screen or restart game
            return;
        }

        // Reset player position (e.g. start at left side)
        if (currentLevel == 2) {
        	goodGuy.setPosition(600, 300);
        	hud.setLifeCount(3);
        } else if (currentLevel == 3) {
        	goodGuy.setPosition(600, 300);
        	hud.setLifeCount(3);
        } 
        loadLevel(currentLevel);
        hudV.refresh(hud);
    }
    
    public void setLevel(int l) {
    	currentLevel = l;
    }
    
    public int getLevel() {
    	return currentLevel;
    }
    

}