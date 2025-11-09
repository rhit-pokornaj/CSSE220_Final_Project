package finalvers1;

// HudModel class contains score and life status
public class HudModel {

	private int score = 0;
	private int lives = 3;
	
//returns the current score
	public int getScore() {
		return score;
	}

//	returns the amount of lives left
	public int getLifeCount() {
		return lives;
	}

	/**
	 * increments the score by delta amount 
	 * @param delta, the change in score
	 */
	public void addScore(int delta) {
		this.score += delta;
	}

	/**
	 * decrements the life count by delta amount 
	 * @param delta, the change in lives
	 */
	public void loseLife(int delta) {
		if (getLifeCount() > 0) {
			this.lives -= delta;
		}
	}
}
