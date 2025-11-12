// LEVEL LOADER

package finalvers1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LevelLoader {
	
	public static List<Platform> loadPlatforms(String filename, EntityManager em){
		
		List<Platform> platforms = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			int row = 0;
			
			while((line = br.readLine()) != null) {
				
				int col = 0;
				
				while (col < line.length()) {
                    char currentChar = line.charAt(col);

                    if (currentChar == '-') {
                        int startCol = col;
                        // Count consecutive '-'
                        while (col < line.length() && line.charAt(col) == '-') col++;
                        
                        int length = (col - startCol) * 20;
                        int x = startCol * 20;
                        int y = (row * 20) + 100;
                        
                        Platform p = new Platform(x, y, length);
                        platforms.add(p);	
                        em.addPlatform(p);
                        
                    } else if (currentChar == 'e') {
                    	int enemyX = col * 20;
                    	Platform platformEnemy = null;
                    	
                    	for (Platform p : platforms) {
                    		if (p.getX() <= enemyX && enemyX <= p.getX() + p.getWidth()) {
                                if (platformEnemy == null || p.getY() > platformEnemy.getY()) {
                                    platformEnemy = p;
                                }
                            }
                    	}
                    	
                    	if (platformEnemy != null) {
                    		int enemyY = platformEnemy.getY() - 40;
                    		em.addEnemy(new Enemy(enemyX, enemyY, platformEnemy));
                    	}
                    	
                        col++;
                    } else {
                        col++;
                    }
                }
				
				row++;
				
			}
		} catch(IOException e) { e.printStackTrace(); }
		
		return platforms;
	}

}
