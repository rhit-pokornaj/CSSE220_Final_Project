package finalvers1;

public class HudModel {

	private int score = 0;
	private int lives = 3;

	public int getScore() {
		return score;
	}

	public int getLifeCount() {
		return lives;
	}

	public void addScore(int delta) {
		this.score += delta;
	}

	public void loseLife(int delta) {
		if (getLifeCount() > 0) {
			this.lives -= delta;
		}
	}
}
