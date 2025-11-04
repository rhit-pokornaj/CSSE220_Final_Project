package finalvers1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;




public class ScoreManager {

	
	private static final String FILE = "data/scores.txt";
	
	public static void save(int score, int lives) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE, true))) {
            out.println(score + "," + lives + "," + System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace(); // or show a dialog if you prefer
        }
    }
	
	public static List load() {
        List lines = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return lines;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
	
}
